package scioli.formatters;

import scioli.Cypher;

public class PatristocratFormatter implements Formatter {

    @Override
    public String format(final Cypher cypher) {
        final StringBuilder s = new StringBuilder();
        s.append("\nsize: " + cypher.getEncoded().length());
        s.append("\n\n");

        int cc = 0;
        s.append("\n");
        for(char c :  cypher.getEncoded().toCharArray()) {
            if(cypher.getLanguage().getAlphabet().indexOf(c)>0) {
                s.append(c);
                cc++;
                if (cc % 5 == 0) {
                    s.append("  ");
                }
            }
        }

        s.append("\n\n");
        for (int i = 0; i < cypher.getLanguage().size(); i++) {
            s.append("  " + cypher.getLanguage().getAlphabet().charAt(i));
        }
        s.append("\n");
        for (int i = 0; i < cypher.getLanguage().size(); i++) {
            s.append(String.format("%3d", cypher.getFrequencyTable()[i]));
        }
        s.append("\n");
        return s.toString();
    }
}
