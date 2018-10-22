package scioli.keymakers;

import org.junit.jupiter.api.Test;
import scioli.languages.Language;

import java.util.stream.IntStream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class K2KeyMakerTest {


    @Test
    void makeKeyWithShift4English() {
        final K2KeyMaker mockK2KeyMaker = mock(K2KeyMaker.class);
        when(mockK2KeyMaker.getKeyword()).thenReturn("ZOO");
        when(mockK2KeyMaker.calculateInsertPoint(Language.ENGLISH.length())).thenReturn(2);
        when(mockK2KeyMaker.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockK2KeyMaker.makeKey(Language.ENGLISH)).isEqualTo("XYZOABCDEFGHIJKLMNPQRSTUVW");
    }


    @Test
    void makeKeyWithShift4Spanish() {
        final K2KeyMaker mockK2KeyMaker = mock(K2KeyMaker.class);
        when(mockK2KeyMaker.getKeyword()).thenReturn("ZOO");
        when(mockK2KeyMaker.calculateInsertPoint(Language.SPANISH.length())).thenReturn(2);
        when(mockK2KeyMaker.makeKey(Language.SPANISH)).thenCallRealMethod();
        assertThat(mockK2KeyMaker.makeKey(Language.SPANISH)).isEqualTo("XYZOABCDEFGHIJKLMNÑPQRSTUVW");
    }


    @Test
    void makeKeyWithShift6() {
        final K2KeyMaker mockK2KeyMaker = mock(K2KeyMaker.class);
        when(mockK2KeyMaker.getKeyword()).thenReturn("TEST");
        when(mockK2KeyMaker.calculateInsertPoint(Language.ENGLISH.length())).thenReturn(6);
        when(mockK2KeyMaker.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockK2KeyMaker.makeKey(Language.ENGLISH)).isEqualTo("UVWXYZTESABCDFGHIJKLMNOPQR");
    }

    @Test
    void makeKeyWithShift22() {
        final K2KeyMaker mockK2KeyMaker = mock(K2KeyMaker.class);
        when(mockK2KeyMaker.getKeyword()).thenReturn("LONGKEYWORD");
        when(mockK2KeyMaker.calculateInsertPoint(Language.ENGLISH.length())).thenReturn(22);

        when(mockK2KeyMaker.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockK2KeyMaker.makeKey(Language.ENGLISH)).isEqualTo("KEYWRDABCFHIJMPQSTUVXZLONG");
    }


    @Test
    void makeKeyStressEnglish() {
        IntStream.range(0, 100).forEach(n -> {
            final K2KeyMaker a = new K2KeyMaker("EXCEPTIONAL");
            final String key = a.makeKey(Language.ENGLISH);
            assertThat(key).isNotNull();
            assertThat(key.length()).isEqualTo(Language.ENGLISH.length());
            IntStream.range(0, key.length()).forEach(i -> {
                assertThat(key).containsOnlyOnce(Language.ENGLISH.getAlphabet().charAt(i) + "");
                assertThat(key.charAt(i)).isNotEqualTo(Language.ENGLISH.getAlphabet().charAt(i));
            });
        });
    }

    @Test
    void makeKeyStressSpanish() {
        IntStream.range(0, 100).forEach(n -> {
            final K2KeyMaker a = new K2KeyMaker("CARAMBA");
            final String key = a.makeKey(Language.SPANISH);
            assertThat(key).isNotNull();
            assertThat(key.length()).isEqualTo(Language.SPANISH.length());
            IntStream.range(0, key.length()).forEach(i -> {
                assertThat(key).containsOnlyOnce(Language.SPANISH.getAlphabet().charAt(i) + "");
                assertThat(key.charAt(i)).isNotEqualTo(Language.SPANISH.getAlphabet().charAt(i));
            });
        });
    }
}