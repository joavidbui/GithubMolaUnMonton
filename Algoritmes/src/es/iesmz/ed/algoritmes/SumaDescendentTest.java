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
                Arguments.of(0L, 0L),
                Arguments.of(-1234L, 1506L),
                Arguments.of(123456789L, 150891621L),
                Arguments.of(Long.MAX_VALUE, -1),
                Arguments.of(Long.MIN_VALUE, -1),
                Arguments.of(9999999L, 11111103L)
        );
    }

}