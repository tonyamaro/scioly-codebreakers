package scioli.languages;

public class Spanish implements Language {
    @Override
    public String getAlphabet() {
        return "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    }

    @Override
    public int length() {
        return 27;
    }
}
