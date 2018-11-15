package scioli.keymakers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Key {

    private String plain;
    private String cypher;
    private Map<Character, Character> conversionMap;
    private String name;

    public Key(final String name, final String plain, final String cypher) {

        if(plain == null || cypher == null){
            throw new IllegalArgumentException( String.format("plain [%s] and cypher [%s] are required", plain, cypher));
        }
        if(plain.length() != cypher.length()){
            throw new IllegalArgumentException( String.format("plain [%s] and cypher [%s] should have same length", plain, cypher));
        }
        conversionMap = new HashMap<>();
        for(int i = 0; i< plain.length(); i++){
            final Character previousValue = conversionMap.put(plain.charAt(i), cypher.charAt(i));
            if(previousValue != null){
                throw new IllegalArgumentException( String.format("plain [%s] has same character [%s] twice", plain, previousValue));
            }
        }
        this.name = name;
        this.plain = plain;
        this.cypher = cypher;

    }

    public String convert(final String text){
        return  text.chars()
                .mapToObj(c -> (char) c)
                .map(c -> conversionMap.get(c) + "")
                .collect(Collectors.joining());
    }


    public boolean isLeaky() {
        final boolean leaky = this.conversionMap.keySet().stream()
                .anyMatch(c -> this.conversionMap.get(c) == c);
        return leaky;
    }

    public String getName() {
        return name;
    }

    public String getPlain() {
        return plain;
    }

    public String getCypher() {
        return cypher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(getPlain(), key.getPlain()) &&
                Objects.equals(getCypher(), key.getCypher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlain(), getCypher());
    }

    @Override
    public String toString() {
        return "Key{" +
                "plain='" + plain + '\'' +
                ", cypher='" + cypher + '\'' +
                '}';
    }
}
