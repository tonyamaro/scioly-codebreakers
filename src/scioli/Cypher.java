package scioli;

import scioli.languages.Language;

public class Cypher {

    private Language language;
    private String phrase;
    private String key = "";
    private String encoded = "";
    private int[] frequencyTable;


    public Cypher(Language language, String phrase, String key, String encoded, int[] frequencyTable) {
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

    public String getKey() {
        return key;
    }

    public String getEncoded() {
        return encoded;
    }

    public int[] getFrequencyTable() {
        return frequencyTable;
    }
}
