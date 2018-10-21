package scioli.languages;

public interface Language {

    Language ENGLISH = new English();

    String getAlphabet();

    int size();
}
