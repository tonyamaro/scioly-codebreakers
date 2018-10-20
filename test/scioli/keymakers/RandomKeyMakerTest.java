package scioli.keymakers;

import org.junit.jupiter.api.Test;
import scioli.languages.English;
import scioli.languages.Language;

import java.util.stream.IntStream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class RandomKeyMakerTest {

    @Test
    void makeKey() {

        final Language english = new English();

        IntStream.range(0, 100).forEach(n -> {
            final RandomKeyMaker a = new RandomKeyMaker();
            final String key = a.makeKey(english);
            assertThat(key).isNotNull();
            assertThat(key.length()).isEqualTo(26);
            for (int i = 0; i < key.length(); i++) {
                assertThat(key).containsOnlyOnce(english.getAlphabet().charAt(i) + "");
                assertThat(key.charAt(i)).isNotEqualTo(english.getAlphabet().charAt(i));
            }
        });

    }
}