package scioli.formatters;

import scioli.Cipher;

public class PatristocratFormatter implements Formatter {

    @Override
    public String format(final Cipher cipher) {
        final StringBuilder s = new StringBuilder();
        s.append("\nPatristocrat " + cipher.getKey().getName() + " length " + cipher.getEncoded().length());

        s.append("\nlength: " + cipher.getEncoded().length());
        s.append("\n\n");

        int cc = 0;
        s.append("\n");
        for (char c : cipher.getEncoded().toCharArray()) {
            if (cipher.getLanguage().getAlphabet().indexOf(c) > 0) {
                s.append(c);
                cc++;
                if (cc % 5 == 0) {
                    s.append("  ");
                }
            }
        }

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
