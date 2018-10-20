package scioli.languages;

public interface Language {


    public static final Language ENGLISH = new English();

    String getAlphabet();

    int size();
}
