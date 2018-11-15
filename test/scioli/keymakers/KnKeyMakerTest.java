package scioli.keymakers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import scioli.languages.Language;

import java.util.stream.IntStream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

class KnKeyMakerTest {


    @Test
    void makeKey1WithShift4English() {
        final KnKeyMaker mockKnKeyMaker = Mockito.spy(new KnKeyMaker(KnKeyMaker.KModel.K1, "ZOO"));
        when(mockKnKeyMaker.calculateInsertPoint(Language.ENGLISH.length())).thenReturn(4);
        when(mockKnKeyMaker.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockKnKeyMaker.makeKey(Language.ENGLISH)).isEqualTo(new Key("K1","VWXYZOABCDEFGHIJKLMNPQRSTU", Language.ENGLISH.getAlphabet()));
    }

    @Test
    void makeKey2WithShift4English() {
        final KnKeyMaker mockKnKeyMaker = Mockito.spy(new KnKeyMaker(KnKeyMaker.KModel.K2, "ZOO"));
        when(mockKnKeyMaker.calculateInsertPoint(Language.ENGLISH.length())).thenReturn(4);
        when(mockKnKeyMaker.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockKnKeyMaker.makeKey(Language.ENGLISH)).isEqualTo(new Key("K2", Language.ENGLISH.getAlphabet(),"VWXYZOABCDEFGHIJKLMNPQRSTU"));
    }


    @Test
    void makeKey3WithShift4English() {
        final KnKeyMaker mockKnKeyMaker = Mockito.spy(new KnKeyMaker(KnKeyMaker.KModel.K3, "ZOO"));
        when(mockKnKeyMaker.calculateInsertPoint(Language.ENGLISH.length())).thenReturn(4);
        when(mockKnKeyMaker.calculateRangeBetweenInsertPoints(Language.ENGLISH.length()-1)).thenReturn(1);
        when(mockKnKeyMaker.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockKnKeyMaker.makeKey(Language.ENGLISH)).isEqualTo(new Key("K3","VWXYZOABCDEFGHIJKLMNPQRSTU","TUVWXYZOABCDEFGHIJKLMNPQRS"));
    }

    @Test
    void makeKey2WithShift4Spanish() {
        final KnKeyMaker mockKnKeyMaker = Mockito.spy(new KnKeyMaker(KnKeyMaker.KModel.K2, "ZOO"));
        when(mockKnKeyMaker.calculateInsertPoint(Language.SPANISH.length())).thenReturn(4);
        when(mockKnKeyMaker.makeKey(Language.SPANISH)).thenCallRealMethod();
        assertThat(mockKnKeyMaker.makeKey(Language.SPANISH)).isEqualTo(new Key("K2", Language.SPANISH.getAlphabet(),"VWXYZOABCDEFGHIJKLMNÑPQRSTU"));
    }


    @Test
    void makeKey2WithShift6() {
        final KnKeyMaker mockKnKeyMaker = Mockito.spy(new KnKeyMaker(KnKeyMaker.KModel.K2, "TEST"));
        when(mockKnKeyMaker.calculateInsertPoint(Language.ENGLISH.length())).thenReturn(6);
        when(mockKnKeyMaker.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockKnKeyMaker.makeKey(Language.ENGLISH)).isEqualTo(new Key("K2", Language.ENGLISH.getAlphabet(),"UVWXYZTESABCDFGHIJKLMNOPQR"));
    }

    @Test
    void makeKey2WithShift22() {
        final KnKeyMaker mockKnKeyMaker = Mockito.spy(new KnKeyMaker(KnKeyMaker.KModel.K2, "LONGKEYWORD"));
        when(mockKnKeyMaker.calculateInsertPoint(Language.ENGLISH.length())).thenReturn(22);

        when(mockKnKeyMaker.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockKnKeyMaker.makeKey(Language.ENGLISH)).isEqualTo(new Key("K2", Language.ENGLISH.getAlphabet(),"KEYWRDABCFHIJMPQSTUVXZLONG"));
    }


    @Test
    void makeKey2StressEnglish() {
        IntStream.range(0, 100).forEach(n -> {
            final KnKeyMaker a = new KnKeyMaker(KnKeyMaker.KModel.K2, "EXCEPTIONAL");
            final Key key = a.makeKey(Language.ENGLISH);
            assertThat(key).isNotNull();
            assertThat(key.getCypher().length()).isEqualTo(Language.ENGLISH.length());
            IntStream.range(0, key.getCypher().length())
                    .parallel()
                    .forEach(i -> {
                        assertThat(key.getCypher()).containsOnlyOnce(Language.ENGLISH.getAlphabet().charAt(i) + "");
                        assertThat(key.getCypher().charAt(i)).isNotEqualTo(Language.ENGLISH.getAlphabet().charAt(i));
                    });
        });
    }

    @Test
    void makeKey3StressEnglish() {
        IntStream.range(0, 100).forEach(n -> {
            final KnKeyMaker a = new KnKeyMaker(KnKeyMaker.KModel.K3, "EXCEPTIONAL");
            final Key key = a.makeKey(Language.ENGLISH);
            assertThat(key).isNotNull();
            assertThat(key.getCypher().length()).isEqualTo(Language.ENGLISH.length());
            IntStream.range(0, key.getCypher().length())
                    .parallel()
                    .forEach(i -> {
                        assertThat(key.getCypher()).containsOnlyOnce(Language.ENGLISH.getAlphabet().charAt(i) + "");
                        assertThat(key.getCypher().charAt(i)).isNotEqualTo(key.getPlain().charAt(i));
                    });
        });
    }

    @Test
    void makeKey2StressSpanish() {
        IntStream.range(0, 100).forEach(n -> {
            final KnKeyMaker a = new KnKeyMaker(KnKeyMaker.KModel.K2, "CARAMBA");
            final Key key = a.makeKey(Language.SPANISH);
            assertThat(key).isNotNull();
            assertThat(key.getCypher().length()).isEqualTo(Language.SPANISH.length());
            IntStream.range(0, key.getCypher().length())
                    .parallel()
                    .forEach(i -> {
                        assertThat(key.getCypher()).containsOnlyOnce(Language.SPANISH.getAlphabet().charAt(i) + "");
                        assertThat(key.getCypher().charAt(i)).isNotEqualTo(Language.SPANISH.getAlphabet().charAt(i));
                    });
        });
    }
}