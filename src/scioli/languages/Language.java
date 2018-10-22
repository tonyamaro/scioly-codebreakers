package scioli.languages;

public interface Language {

    Language ENGLISH = new English();
    Language SPANISH = new Spanish();

    String getAlphabet();

    int length();
}
