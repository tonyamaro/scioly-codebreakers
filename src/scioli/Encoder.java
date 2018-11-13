package scioli;

import scioli.keymakers.Key;
import scioli.keymakers.KeyMaker;
import scioli.languages.Language;

public class Encoder {


    public Cipher encode(final Language language, final String clearText, final KeyMaker keyMaker){

        final Key key = keyMaker.makeKey(language);

        final StringBuilder encodedBuilder = new StringBuilder();
        final int[] frequency = new int[key.getCypher().length()];
        clearText.toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> {
                    final int i = language.getAlphabet().indexOf(c);
                    if (i < 0)
                        return c;
                    final char encodedC = key.getCypher().charAt(i);
                    frequency[language.getAlphabet().indexOf(encodedC)]++;
                    return encodedC;
                })
                .forEach(c -> encodedBuilder.append(c));

        return new Cipher(language, clearText, key.getCypher(), encodedBuilder.toString(), frequency);
    }




}
