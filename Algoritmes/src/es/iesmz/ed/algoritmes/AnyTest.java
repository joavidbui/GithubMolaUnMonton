package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AnyTest {
    static Any any;
    static int expectedInt;
    static int actualInt;
    @BeforeEach
    void setUp() {
        any = null;
        expectedInt = 0;
        actualInt = 0;
    }
    @ParameterizedTest
    @MethodSource ("inputsShouldReturnHyperPar")
        // six numbers
    void shouldReturnHyperPar(long number, int expectedArgument) {
        any = new Any(number);
        expectedInt = expectedArgument;
        actualInt = any.digitsDiferents();
        Assertions.assertEquals(expectedInt, actualInt);
    }
    private static Stream<Arguments> inputsShouldReturnHyperPar() {
        return Stream.of(
                Arguments.of(0L, 1),
                Arguments.of(-12345L, 5),
                Arguments.of(121212L, 2),
                Arguments.of(123450L, 6),
                Arguments.of(111111L, 1),
                Arguments.of(Long.MAX_VALUE, 9)
        );
    }
}