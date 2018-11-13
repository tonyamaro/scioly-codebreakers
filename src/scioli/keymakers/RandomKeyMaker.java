package scioli.keymakers;

import scioli.languages.Language;

import java.util.stream.IntStream;

public class RandomKeyMaker implements KeyMaker {

    @Override
    public Key makeKey(final Language language) {
        final char[] letters = language.getAlphabet().toCharArray();
        IntStream.range(0, letters.length)
                .forEach(i -> {
                    if (letters[i] == language.getAlphabet().charAt(i)) {
                        int swappingI = (int) (Math.random() * (language.length() - 1));
                        if (swappingI >= i) swappingI++;
                        final char swapChar = letters[swappingI];
                        letters[swappingI] = letters[i];
                        letters[i] = swapChar;
                    }
                });
        return new Key(language.getAlphabet(), new String(letters));
    }
}
