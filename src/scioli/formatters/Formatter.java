package scioli.formatters;

import scioli.Cypher;

public interface Formatter {

    Formatter ARISTOCRAT = new AristocratFormatter();
    Formatter PATRISTOCRAT = new PatristocratFormatter();

    String format(final Cypher cypher);
}
