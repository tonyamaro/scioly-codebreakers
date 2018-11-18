package scioli;

import scioli.keymakers.Key;
import scioli.keymakers.KeyMaker;
import scioli.languages.Language;

public class Cypher {

    private Language language;
    private String phrase;
    private Key key;


    public Cypher(Language language, String phrase, KeyMaker keyMaker) {
        this.language = language;
        this.phrase = phrase;
        this.key = keyMaker.makeKey(language);
    }

    public Language getLanguage() {
        return language;
    }

    public String getPhrase() {
        return phrase;
    }

    public Key getKey() {
        return key;
    }

}
