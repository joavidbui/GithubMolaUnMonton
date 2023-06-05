package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculMentalTest {
    static Cablejat calculMental;

    @BeforeEach
    void setUp() {
        calculMental = null;
    }

    @ParameterizedTest
    @MethodSource("inputsCalculMentalParametrized")
        // six numbers
    void calculMentalParametrized(int quantitatCasosProva, String input, ArrayList<Integer> expectedOutput) {

    }

    private static Stream<Arguments> inputsCalculMentalParametrized() {
        return Stream.of(Arguments.of(1, "15 + 8 − 7 + 10 − 3", Arrays.asList(23, 16, 26, 23))
        );
    }

}