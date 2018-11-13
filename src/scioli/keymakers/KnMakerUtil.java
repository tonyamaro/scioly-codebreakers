package scioli.keymakers;

import scioli.Utils;
import scioli.languages.Language;

public class KnMakerUtil {

    public static String createSequenceWithKeyword(final String keyword, final Language language, final int insertPoint) {
        final String cleanSeed = Utils.removeDups(keyword);
        final String cleanedAlphabet = Utils.removeChars(language.getAlphabet(), cleanSeed);

        final String keyBeforeRotation = cleanSeed + cleanedAlphabet;
        final int l = language.length();

        final int split = (l - insertPoint) % l;
        return keyBeforeRotation.substring(split) + keyBeforeRotation.substring(0, split);
    }

}
