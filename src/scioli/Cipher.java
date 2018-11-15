package scioli;

import scioli.keymakers.Key;
import scioli.languages.Language;

public class Cipher {

    private Language language;
    private String phrase;
    private Key key;
    private String encoded ;
    private int[] frequencyTable;


    public Cipher(Language language, String phrase, Key key, String encoded, int[] frequencyTable) {
        this.language = language;
        this.phrase = phrase;
        this.key = key;
        this.encoded = encoded;
        this.frequencyTable = frequencyTable;
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

    public String getEncoded() {
        return encoded;
    }

    public int[] getFrequencyTable() {
        return frequencyTable;
    }
}
