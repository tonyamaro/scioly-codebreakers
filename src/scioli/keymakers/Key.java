package scioli.keymakers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Key {

    private String name;
    private String plain;
    private String cypher;
    private Map<Character, Character> encoderMap;
    private Map<Character, Character> decoderMap;

    public Key(final String name, final String plain, final String cypher) {

        if (plain == null || cypher == null) {
            throw new IllegalArgumentException(String.format("plain [%s] and cypher [%s] are required", plain, cypher));
        }
        if (plain.length() != cypher.length()) {
            throw new IllegalArgumentException(String.format("plain [%s] and cypher [%s] should have same length", plain, cypher));
        }
        encoderMap = new HashMap<>();
        decoderMap = new HashMap<>();
        for (int i = 0; i < plain.length(); i++) {
            Character previousValue = encoderMap.put(plain.charAt(i), cypher.charAt(i));
            if (previousValue != null) {
                throw new IllegalArgumentException(String.format("plain [%s] has same character [%s] twice", plain, previousValue));
            }
            previousValue = decoderMap.put(cypher.charAt(i), plain.charAt(i));
            if (previousValue != null) {
                throw new IllegalArgumentException(String.format("cypher [%s] has same character [%s] twice", cypher, previousValue));
            }
        }
        this.name = name;
        this.plain = plain;
        this.cypher = cypher;

    }

    public String encode(final String plainText) {
        return plainText.toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> encoderMap.getOrDefault(c, c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }


    public String decode(final String encodedText) {
        return encodedText.toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> decoderMap.getOrDefault(c, c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }


    public int[] calculateFrequency(final String plainText) {
        final String encodedText = this.encode(plainText);
        final int[] frequency = new int[this.cypher.length()];
        encodedText.toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> this.plain.indexOf(c))
                .filter(i -> i > -1)
                .forEach(i -> frequency[i]++);
        return frequency;
    }


    public boolean isLeaky() {
        final Optional<Character> leaky = this.encoderMap.keySet().stream()
                .filter(c -> this.encoderMap.get(c) == c)
                .findFirst();

        return leaky.isPresent();
    }

    public String getName() {
        return name;
    }

    String getPlain() {
        return plain;
    }

    String getCypher() {
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
