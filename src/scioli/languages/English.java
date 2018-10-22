package scioli.languages;

public class English implements Language {
    @Override
    public String getAlphabet() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    @Override
    public int length() {
        return 26;
    }
}
