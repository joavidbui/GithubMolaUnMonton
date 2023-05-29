package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HyperparTest {
    static Hyperpar hyperpar;

    @BeforeEach
    void setUp() {
        hyperpar = null;
    }

    @ParameterizedTest
    @ValueSource(longs = {2222222222222222L, -246802468024680L, 0L})
        // six numbers
    void shouldReturnHyperPar(long number) {
        hyperpar = new Hyperpar(number);
        Assertions.assertTrue(hyperpar.esHyperPar());
    }

    @ParameterizedTest
    @ValueSource(longs = {1111111111111111111L, -136913691369136913L, Long.MIN_VALUE, Long.MAX_VALUE})
        // six numbers
    void shouldReturnNotHyperPar(long number) {
        hyperpar = new Hyperpar(number);
        Assertions.assertFalse(hyperpar.esHyperPar());
    }
}