package scioli.formatters;

import scioli.Cypher;

public class PatristocratFormatter implements Formatter {

    @Override
    public String format(final Cypher cypher) {
        final int[] frequencyTable = cypher.getKey().calculateFrequency(cypher.getPhrase());
        final String encoded = cypher.getKey().encode(cypher.getPhrase());


        final StringBuilder s = new StringBuilder();
        s.append("\nPatristocrat " + cypher.getKey().getName() + " length " + encoded.length());

        s.append("\nlength: " + encoded.length());
        s.append("\n\n");

        int cc = 0;
        s.append("\n");
        for (char c : encoded.toCharArray()) {
            if (cypher.getLanguage().getAlphabet().indexOf(c) > 0) {
                s.append(c);
                cc++;
                if (cc % 5 == 0) {
                    s.append("  ");
                }
            }
        }

        s.append("\n\n");
        for (int i = 0; i < cypher.getLanguage().length(); i++) {
            s.append("  " + cypher.getLanguage().getAlphabet().charAt(i));
        }
        s.append("\n");
        for (int i = 0; i < cypher.getLanguage().length(); i++) {
            s.append(String.format("%3d", frequencyTable[i]));
        }
        s.append("\n");
        return s.toString();
    }
}
