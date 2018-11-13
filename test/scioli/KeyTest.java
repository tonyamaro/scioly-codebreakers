package scioli;

import org.junit.jupiter.api.Test;
import scioli.keymakers.Key;

import static org.assertj.core.api.Java6Assertions.assertThat;

class KeyTest {

    @Test
    void test() {
        final Key key = new Key("ABCD", "WXYZ");
        assertThat(key.convert("DAB")).isEqualTo("ZWX");

    }


}