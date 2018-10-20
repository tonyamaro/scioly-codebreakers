package scioli.formatters;

import scioli.Cypher;

public class AristocratFormatter implements Formatter {

    @Override
    public String format(final Cypher cypher) {
        final StringBuilder s = new StringBuilder();
        s.append("\nsize: " + cypher.getEncoded().length());
        s.append("\n\n");

        s.append("\n" + cypher.getEncoded());
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
