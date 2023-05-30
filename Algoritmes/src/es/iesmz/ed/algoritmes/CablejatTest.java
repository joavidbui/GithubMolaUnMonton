package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CablejatTest {
    static Cablejat cablejat;
    @BeforeEach
    void setUp() {
        cablejat = null;
    }
    @ParameterizedTest
    @MethodSource("inputsShouldReturnConectable")
        // six numbers
    void shouldReturnConectable(String[] inputs) {
        try {
            cablejat = new Cablejat(inputs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(cablejat.esPotConnectar());
    }
    private static Stream<Arguments> inputsShouldReturnConectable() {
        return Stream.of(
                Arguments.of((Object) new String[]{"MM", "HH"}),
                Arguments.of((Object) new String[]{"HM", "HM"}),
                Arguments.of((Object) new String[]{"MM", "HM", "HM"}),
                Arguments.of((Object) new String[]{"HH", "HM", "HM"}),
                Arguments.of((Object) new String[]{"MM", "MM", "HM", "HM", "HM", "HM"}),
                Arguments.of((Object) new String[]{"MM", "MM", "HM", "HM", "HM", "HM"})
        );
    }

    @ParameterizedTest
    @MethodSource("inputsShouldReturnNOTConectable")
        // six numbers
    void shouldReturnNOTConectable(String[] conectores) {
        try {
            cablejat = new Cablejat(conectores);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertFalse(cablejat.esPotConnectar());
    }
    private static Stream<Arguments> inputsShouldReturnNOTConectable() {
        return Stream.of(
                Arguments.of((Object) new String[]{"MM", "MM"}),
                Arguments.of((Object) new String[]{"HH", "HH"}),
                Arguments.of((Object) new String[]{"MM", "HM"}),
                Arguments.of((Object) new String[]{"HH", "HM"}),
                Arguments.of((Object) new String[]{"HH", "HH", "HM"}),
                Arguments.of((Object) new String[]{"MM", "MM", "HM"})
        );
    }

}