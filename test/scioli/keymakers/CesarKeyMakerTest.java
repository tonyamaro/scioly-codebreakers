package scioli.keymakers;

import org.junit.jupiter.api.Test;
import scioli.languages.Language;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CesarKeyMakerTest {

    @Test
    void makeKey() {

        assertThat(new CesarKeyMaker(5).makeKey(Language.ENGLISH))
                .isEqualTo(new Key(Language.ENGLISH.getAlphabet(), "FGHIJKLMNOPQRSTUVWXYZABCDE"));

    }
}