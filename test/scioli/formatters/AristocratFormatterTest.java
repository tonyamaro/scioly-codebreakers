package scioli.formatters;

import org.junit.jupiter.api.Test;
import scioli.Cypher;
import scioli.Encoder;
import scioli.keymakers.CesarKeyMaker;
import scioli.languages.Language;

import static org.assertj.core.api.Java6Assertions.assertThat;

class AristocratFormatterTest {

    @Test
    void format() {


        final Cypher cypher = new Encoder()
                .encode(Language.ENGLISH,
                        "This is just a test.",
                        new CesarKeyMaker(5));


        assertThat(

                new AristocratFormatter().format(cypher)).isEqualTo(

                "\n" +
                        "size: 20\n" +
                        "\n" +
                        "\n" +
                        "YMNX NX OZXY F YJXY.\n" +
                        "\n" +
                        "  A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z\n" +
                        "  0  0  0  0  0  1  0  0  0  1  0  0  1  2  1  0  0  0  0  0  0  0  0  4  4  1\n");


    }
}