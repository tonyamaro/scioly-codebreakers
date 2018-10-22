package scioli.keymakers;

import scioli.Utils;
import scioli.languages.Language;

import java.util.Optional;
import java.util.stream.IntStream;

public class K2KeyMaker implements KeyMaker {

    private String keyword;

    public K2KeyMaker(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String makeKey(final Language language) {

        final String cleanSeed = Utils.removeDups(getKeyword());
        final String cleanedAlphabet = Utils.removeChars(language.getAlphabet(), cleanSeed);

        final String keyBeforeRotation = cleanSeed + cleanedAlphabet;
        final int l = language.length();
        final int insertPoint = calculateInsertPoint(l);

        final Optional<String> key = IntStream.range(0, l)
                .map(i -> (l - insertPoint + i) % l)
                .mapToObj(split -> keyBeforeRotation.substring(split)
                        + keyBeforeRotation.substring(0, split))
                .filter(aKey -> !Utils.isLeaky(aKey, language))
                .findAny();
        if (key.isPresent()) {
            return key.get();
        }

        throw new IllegalStateException(String.format("Cannot find valid K1 for keyword '%s'.", this.getKeyword()));

    }

    String getKeyword() {
        return keyword;
    }

    int calculateInsertPoint(final int range) {
        return (int) (Math.random() * range);
    }
}
