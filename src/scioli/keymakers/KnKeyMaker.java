package scioli.keymakers;

import scioli.languages.Language;

public class KnKeyMaker implements KeyMaker {


    public static enum KModel {
        K1(1), K2(1), K3(1), K4(2);

        private int numberOfKeywords;

        KModel(int numberOfKeywords) {
            this.numberOfKeywords = numberOfKeywords;
        }

        public int getNumberOfKeywords() {
            return numberOfKeywords;
        }
    }

    private KModel kModel;
    private String keyword1;
    private String keyword2;

    public KnKeyMaker(final KModel kModel, final String keyword) {
        if (kModel.getNumberOfKeywords() != 1 || keyword == null) {
            throw new IllegalArgumentException(String.format("model %s requires one keyword.", kModel));
        }
        this.kModel = kModel;
        this.keyword1 = keyword;
    }

    public KnKeyMaker(final KModel kModel, final String keyword1, final String keyword2) {
        if (kModel.getNumberOfKeywords() != 1 || keyword1 == null || keyword2 == null) {
            throw new IllegalArgumentException(String.format("model %s requires two keywords.", kModel));
        }
        this.kModel = kModel;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
    }

    @Override
    public Key makeKey(final Language language) {

        final int insertPoint = calculateInsertPoint(language.length());
        final int anotherInsertPoint = insertPoint + calculateRangeBetweenInsertPoints(language.length()) ;


        for (int i = 0; i < language.length(); i++) {
            final String sequenceWithKeyword = KnMakerUtil.createSequenceWithKeyword(getKeyword1(), language, insertPoint - i);

            Key key;
            switch (this.kModel) {

                case K1:
                    key = new Key(sequenceWithKeyword, language.getAlphabet());
                    break;
                case K2:
                    key = new Key(language.getAlphabet(), sequenceWithKeyword);
                    break;
                case K3:
                    final String anotherSequenceWithKeyword = KnMakerUtil.createSequenceWithKeyword(getKeyword1(), language, anotherInsertPoint - i);
                    key = new Key(sequenceWithKeyword, anotherSequenceWithKeyword);
                    break;
                case K4:
                    final String sequenceWithKeyword2 = KnMakerUtil.createSequenceWithKeyword(getKeyword2(), language, anotherInsertPoint - i);
                    key = new Key(sequenceWithKeyword, sequenceWithKeyword2);
                    break;
                default:
                    throw new IllegalStateException(String.format("%s not implemented", kModel));
            }
            if (!key.isLeaky()) {
                return key;
            }
        }

        throw new IllegalStateException(String.format("Cannot find valid %s for keyword%s '%s'%s.",
                this.kModel,
                this.kModel.getNumberOfKeywords() == 1 ? "" : "s",
                this.getKeyword1(),
                this.kModel.getNumberOfKeywords() == 1 ? "" : " and '" + keyword2 + "'"
        ));

    }

    String getKeyword1() {
        return keyword1;
    }

    String getKeyword2() {
        return keyword2;
    }

    int calculateInsertPoint(final int range) {
        return (int) (Math.random() * range);
    }

    int calculateRangeBetweenInsertPoints(final int range) {
        return (int) (Math.random() * range);
    }
}
