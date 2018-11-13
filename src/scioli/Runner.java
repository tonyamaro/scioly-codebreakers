package scioli;

import scioli.formatters.Formatter;
import scioli.keymakers.KnKeyMaker;
import scioli.keymakers.RandomKeyMaker;
import scioli.languages.Language;

public class Runner {

    public static void main(String[] a) {

        final Cipher cipher = new Encoder()
                .encode(Language.ENGLISH,
                        "This is just a test.",
                        new RandomKeyMaker());
        System.out.println(Formatter.ARISTOCRAT.format(cipher));
        System.out.println(Formatter.PATRISTOCRAT.format(cipher));


        final Cipher key1Cipher = new Encoder()
                .encode(Language.ENGLISH,
                        "This is just a test.",
                        new KnKeyMaker(KnKeyMaker.KModel.K2, "AMAZING"));
        System.out.println(Formatter.ARISTOCRAT.format(key1Cipher));
        System.out.println(Formatter.PATRISTOCRAT.format(key1Cipher));


    }


}
