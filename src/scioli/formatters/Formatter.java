package scioli.formatters;

import scioli.Cipher;

public interface Formatter {

    Formatter ARISTOCRAT = new AristocratFormatter();
    Formatter PATRISTOCRAT = new PatristocratFormatter();

    String format(final Cipher cipher);
}
