package scioli.keymakers;

import scioli.Utils;
import scioli.languages.Language;

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

        for (int tries = 0; tries < l; tries++) {
            int split = (l - insertPoint + tries) % l;
            final String key = keyBeforeRotation.substring(split) + keyBeforeRotation.substring(0, split);
            if (!Utils.isLeaky(key, language)) {
                return key;
            }
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
