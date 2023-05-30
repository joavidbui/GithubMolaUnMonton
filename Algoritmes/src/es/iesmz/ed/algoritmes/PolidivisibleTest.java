package es.iesmz.ed.algoritmes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PolidivisibleTest {
    static Polidivisible polidivisible;

    @BeforeEach
    void setUp() {
        polidivisible = null;
    }

    @ParameterizedTest
    @ValueSource(longs = {})
    void shouldReturnPolydivisible(long number) {
        polidivisible = new Polidivisible(number);
        Assertions.assertTrue(polidivisible.esPolidivisible());
    }

    @ParameterizedTest
    @ValueSource(longs = {})
    void shouldReturnNOTPolydivisible(long number) {
        polidivisible = new Polidivisible(number);
        Assertions.assertFalse(polidivisible.esPolidivisible());
    }

}