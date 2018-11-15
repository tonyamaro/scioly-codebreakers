package scioli;

import scioli.formatters.Formatter;
import scioli.keymakers.CesarKeyMaker;
import scioli.keymakers.KnKeyMaker;
import scioli.languages.Language;

public class Runner {

    public static void main(String[] a) {

        Cipher key1Cipher = new Encoder()
                .encode(Language.ENGLISH,
                        "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.",
                        new KnKeyMaker(KnKeyMaker.KModel.K1, "EINSTEIN"));
        System.out.println(Formatter.ARISTOCRAT.format(key1Cipher));

        key1Cipher = new Encoder()
                .encode(Language.ENGLISH,
                        "You've gotta dance like there's nobody watching, and live like it's heaven on earth.",
                        new KnKeyMaker(KnKeyMaker.KModel.K2, "HOWTOLIVE"));
        System.out.println(Formatter.PATRISTOCRAT.format(key1Cipher));

        key1Cipher = new Encoder()
                .encode(Language.ENGLISH,
                        "You know you're in love when you can't fall asleep because reality is finally better than your dreams.",
                        new KnKeyMaker(KnKeyMaker.KModel.K2, "ABOUTLOVE"));
        System.out.println(Formatter.ARISTOCRAT.format(key1Cipher));

        key1Cipher = new Encoder()
                .encode(Language.ENGLISH,
                        "In three words I can sum up everything I've learned about life: it goes on.",
                        new KnKeyMaker(KnKeyMaker.KModel.K2, "ROBERTFROST"));
        System.out.println(Formatter.PATRISTOCRAT.format(key1Cipher));

        key1Cipher = new Encoder()
                .encode(Language.ENGLISH,
                        "I've learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.",
                        new CesarKeyMaker(10));
        System.out.println(Formatter.ARISTOCRAT.format(key1Cipher));


    }


}
