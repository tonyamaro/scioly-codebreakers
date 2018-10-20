package scioli.keymakers;

import scioli.languages.Language;

public class RandomKeyMaker implements KeyMaker {

    @Override
    public String makeKey(final Language language) {
        final char[] letters = language.getAlphabet().toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == language.getAlphabet().charAt(i)) {
                int swappingI = (int) (Math.random() * 25);
                if (swappingI >= i) swappingI++;
                final char swapChar = letters[swappingI];
                letters[swappingI] = letters[i];
                letters[i] = swapChar;
            }
        }
        return new String(letters);
    }
}
