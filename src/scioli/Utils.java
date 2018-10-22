package scioli;

import scioli.languages.Language;

import java.util.stream.Collectors;

public class Utils {


    /**
     * @return whether any character is placed in the same position of its original language alphabet
     */
    public static boolean isLeaky(final String key, final Language language) {
        return key.chars()
                .mapToObj(c -> (char) c + "")
                .anyMatch(c -> key.indexOf(c) == language.getAlphabet().indexOf(c));
    }


    public static String removeChars(String originalString, String charsToBeRemoves) {
        return originalString.chars()
                .mapToObj(c -> (char) c + "")
                .filter(c -> charsToBeRemoves.indexOf(c) < 0)
                .collect(Collectors.joining());
    }

    public static String removeDups(final String seed) {

        return seed.chars()
                .mapToObj(c -> (char) c + "")
                .distinct()
                .collect(Collectors.joining());
    }

    private Utils() {
    }
}
