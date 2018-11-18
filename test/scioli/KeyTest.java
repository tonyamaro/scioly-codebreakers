package scioli;

import org.junit.jupiter.api.Test;
import scioli.keymakers.Key;

import static org.assertj.core.api.Java6Assertions.assertThat;

class KeyTest {

    @Test
    void testEncode() {
        final Key key = new Key("Test", "ABCD", "WXYZ");
        assertThat(key.encode("DAB")).isEqualTo("ZWX");
    }

    @Test
    void testDecode() {
        final Key key = new Key("Test", "ABCD", "WXYZ");
        assertThat(key.decode("ZWX")).isEqualTo("DAB");

    }


}