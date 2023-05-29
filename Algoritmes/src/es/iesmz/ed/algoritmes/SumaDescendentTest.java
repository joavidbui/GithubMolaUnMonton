package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class SumaDescendentTest {
    static SumaDescendent sumaDescendent;
    static long expectedLong;
    static long actualLong;
    @BeforeEach
    void setUp() {
        sumaDescendent = null;
        expectedLong = 0;
        actualLong = 0;
    }
    @ParameterizedTest
    @MethodSource("inputsParametrizedSumaTests")
        // six numbers
    void parametrizedSumaTests(long numero, long resultado) {
        sumaDescendent = new SumaDescendent(numero);
        expectedLong = resultado;
        actualLong = sumaDescendent.suma();
        Assertions.assertEquals(expectedLong, actualLong);
    }
    private static Stream<Arguments> inputsParametrizedSumaTests() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(-1234, 0)
        );
    }

}