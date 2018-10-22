package scioli;

import org.junit.jupiter.api.Test;
import scioli.languages.Language;

import static org.assertj.core.api.Java6Assertions.assertThat;

class UtilsTest {

    @Test
    void cleanWithDup() {
        assertThat(Utils.removeDups("TESTWITHDUP")).isEqualTo("TESWIHDUP");
    }

    @Test
    void cleanNoDup() {
        assertThat(Utils.removeDups("NODUPLICATE")).isEqualTo("NODUPLICATE");
    }

    @Test
    void removeChars() {
        assertThat(Utils.removeChars("ABCDE", "BDE")).isEqualTo("AC");
        assertThat(Utils.removeChars("ABCDE", "ABD")).isEqualTo("CE");
    }


    @Test
    void isLeaky() {
        assertThat(Utils.isLeaky("XYZOABCDEFGHIJKLMNPQRSTUVW", Language.ENGLISH)).isFalse();
    }



}