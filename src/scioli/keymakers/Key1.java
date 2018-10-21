package scioli.keymakers;

import scioli.languages.Language;

import java.util.stream.Collectors;

public class Key1 implements KeyMaker {

    private String seed;

    public Key1(String seed) {
        this.seed = seed;
    }


    @Override
    public String makeKey(final Language language) {

        final String cleanSeed = removeDups(getSeed());
        final int insertPoint =  calculateInsertPoint(language.size());
        final String rotatedAlphabet = new CesarKeyMaker(insertPoint + cleanSeed.length()).makeKey(language);
        final String cleanedRotatedAlphabet = removeChars(rotatedAlphabet, cleanSeed);
        final int split = language.size() - (insertPoint + cleanSeed.length());
        final String a = cleanedRotatedAlphabet.substring(split);
        final String b = cleanedRotatedAlphabet.substring(0, split);
        return a
                + cleanSeed
                + b;
    }

    protected String getSeed(){
        return seed;
    }

    protected int calculateInsertPoint(final int range){
        return (int) (Math.random() * range);
    }

    protected String removeChars(String originalString, String charsToBeRemoves) {
        return originalString.chars()
                .mapToObj(c -> (char) c + "")
                .filter(c -> charsToBeRemoves.indexOf(c)<0)
                .collect(Collectors.joining());
    }

    protected String removeDups(final String seed) {

        return seed.chars()
                .mapToObj(c -> (char) c + "")
                .distinct()
                .collect(Collectors.joining());
    }
}
