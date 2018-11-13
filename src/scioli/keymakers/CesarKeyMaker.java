package scioli.keymakers;

import scioli.languages.Language;

public class CesarKeyMaker implements KeyMaker {

    private int shift;

    public CesarKeyMaker(int shift) {
        if (shift < 0) {
            throw new IllegalArgumentException(String.format("Shift must be positive. '%s' is invalid", shift));
        }
        this.shift = shift;
    }

    @Override
    public Key makeKey(final Language language) {
        return new Key(language.getAlphabet(), language.getAlphabet().substring(shift) + language.getAlphabet().substring(0, shift));
    }
}
