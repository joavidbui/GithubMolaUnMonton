package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class CalculMentalTest {
    static CalculMental calculMental;

    @BeforeEach
    void setUp() {
        calculMental = null;
    }

    @ParameterizedTest
    @MethodSource("inputsCalculMentalParametrized")
        // six numbers
    void calculMentalParametrized(String inputs, ArrayList<Integer> expectedOutputs) {
        calculMental = new CalculMental(inputs);
        Assertions.assertEquals(expectedOutputs, calculMental.calcula());
    }

    private static Stream<Arguments> inputsCalculMentalParametrized() {
        return Stream.of(
                Arguments.of("15 + 8 - 7 + 10 - 3",
                        new ArrayList<>(Arrays.asList(23, 16, 26, 23))),
                Arguments.of("25 - 24 + 7 + 555 - 80",
                        new ArrayList<>(Arrays.asList(1, 8, 563, 483))),
                Arguments.of("877 - 712",
                        new ArrayList<>(List.of(165))),
                Arguments.of("0 + 0 - 0 + 0 - 0",
                        new ArrayList<>(Arrays.asList(0, 0, 0, 0))),
                Arguments.of("1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1",
                        new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)))
        );
    }

}