package scioli.keymakers;

import org.junit.jupiter.api.Test;
import scioli.languages.Language;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class Key1Test {

    @Test
    void cleanWithDup() {

        assertThat(new Key1("any").removeDups("TESTWITHDUP")).isEqualTo("TESWIHDUP");

    }

    @Test
    void cleanNoDup() {

        assertThat(new Key1("any").removeDups("NODUPLICATE")).isEqualTo("NODUPLICATE");

    }

    @Test
    void removeChars() {

        assertThat(new Key1("any").removeChars("ABCDE", "BDE")).isEqualTo("AC");
        assertThat(new Key1("any").removeChars("ABCDE", "ABD")).isEqualTo("CE");

    }


    @Test
    void makeKeyWithShift4(){
        final Key1 mockKey1 = mock(Key1.class);
        when(mockKey1.getSeed()).thenReturn("ZOO");
        when(mockKey1.calculateInsertPoint(Language.ENGLISH.size())).thenReturn(2);
        when(mockKey1.removeDups(anyString())).thenCallRealMethod();
        when(mockKey1.removeChars(anyString(), anyString())).thenCallRealMethod();
        when(mockKey1.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockKey1.makeKey(Language.ENGLISH)).isEqualTo("CDZOEFGHIJKLMNPQRSTUVWXYAB");
    }


    @Test
    void makeKeyWithShift6(){
        final Key1 mockKey1 = mock(Key1.class);
        when(mockKey1.getSeed()).thenReturn("TEST");
        when(mockKey1.calculateInsertPoint(Language.ENGLISH.size())).thenReturn(6);
        when(mockKey1.removeDups(anyString())).thenCallRealMethod();
        when(mockKey1.removeChars(anyString(), anyString())).thenCallRealMethod();
        when(mockKey1.makeKey(Language.ENGLISH)).thenCallRealMethod();
        assertThat(mockKey1.makeKey(Language.ENGLISH)).isEqualTo("CDFGHITESJKLMNOPQRUVWXYZAB");

    }
}