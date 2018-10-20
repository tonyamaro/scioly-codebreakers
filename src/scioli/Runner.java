package scioli;

import scioli.formatters.AristocratFormatter;
import scioli.formatters.Formatter;
import scioli.keymakers.RandomKeyMaker;
import scioli.languages.Language;

public class Runner {

    public static void main(String[] a) {

        final Cypher cypher = new Encoder()
                .encode(Language.ENGLISH,
                        "This is just a test.",
                        new RandomKeyMaker());

        System.out.println(Formatter.ARISTOCRAT.format(cypher));
        System.out.println(Formatter.PATRISTOCRAT.format(cypher));

    }


}
