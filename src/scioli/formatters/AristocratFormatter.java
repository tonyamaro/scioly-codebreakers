package scioli.formatters;

import scioli.Cipher;

public class AristocratFormatter implements Formatter {

    @Override
    public String format(final Cipher cipher) {
        final StringBuilder s = new StringBuilder();
        s.append("\nlength: " + cipher.getEncoded().length());
        s.append("\n\n");

        s.append("\n" + cipher.getEncoded());
        s.append("\n\n");
        for (int i = 0; i < cipher.getLanguage().length(); i++) {
            s.append("  " + cipher.getLanguage().getAlphabet().charAt(i));
        }
        s.append("\n");
        for (int i = 0; i < cipher.getLanguage().length(); i++) {
            s.append(String.format("%3d", cipher.getFrequencyTable()[i]));
        }
        s.append("\n");
        return s.toString();
    }
}
