package scioli;

import scioli.keymakers.KeyMaker;
import scioli.languages.Language;

public class Encoder {


    public Cypher encode(final Language language, final String clearText, final KeyMaker keyMaker){

        final String key = keyMaker.makeKey(language);

        final StringBuilder encodedBuilder = new StringBuilder();
        final int[] frequency = new int[key.length()];
        clearText.toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> {
                    final int i = language.getAlphabet().indexOf(c);
                    if (i < 0)
                        return c;
                    final char encodedC = key.charAt(i);
                    frequency[language.getAlphabet().indexOf(encodedC)]++;
                    return encodedC;
                })
                .forEach(c -> encodedBuilder.append(c));

        return new Cypher(language, clearText, key, encodedBuilder.toString(), frequency);
    }




}
