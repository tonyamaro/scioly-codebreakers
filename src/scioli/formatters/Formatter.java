package scioli.formatters;

import scioli.Cypher;

public interface Formatter {

    public static Formatter ARISTOCRAT = new AristocratFormatter();
    public static Formatter PATRISTOCRAT = new PatristocratFormatter();

    String format(final Cypher cypher);
}
