package scioli.formatters;

import scioli.Cipher;

public interface Formatter {

    public static Formatter ARISTOCRAT = new AristocratFormatter();
    public static Formatter PATRISTOCRAT = new PatristocratFormatter();

    String format(final Cipher cipher);
}
