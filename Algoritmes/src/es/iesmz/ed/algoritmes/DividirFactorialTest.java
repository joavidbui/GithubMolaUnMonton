package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DividirFactorialTest {
    static DividirFactorial dividirFactorial;
    static int expectedInt;
    static int actualInt;
    @BeforeEach
    void setUp() {
        dividirFactorial = null;
        expectedInt = 0;
        actualInt = 0;
    }
    @ParameterizedTest
    @MethodSource("inputsShouldReturnHyperPar")
        // six numbers
    void shouldReturnHyperPar(int numerador, int denominador, int expectedArgument) {
        dividirFactorial = new DividirFactorial(numerador, denominador);
        expectedInt = expectedArgument;
        actualInt = dividirFactorial.calcula();
        Assertions.assertEquals(expectedInt, actualInt);
    }
    private static Stream<Arguments> inputsShouldReturnHyperPar() {
        return Stream.of(
                Arguments.of(9, 7, 72),
                Arguments.of(13, 11, 156),
                Arguments.of(10, 3, 604800),
                Arguments.of(1, 1, 1),
                Arguments.of(0, 1, 1),
                Arguments.of(1, 0, 1),
                Arguments.of(0, 0, 1)
        );
    }
}