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
    @ValueSource(longs = {1L, 2L, 3L, 4L, 10L, 102L, 1020L, 10200L, 345654L, 102000L, 1020005L, 10200056L, 102000564L,
            381654729L, 1020005640L})
    void shouldReturnPolydivisible(long number) {
        polidivisible = new Polidivisible(number);
        Assertions.assertTrue(polidivisible.esPolidivisible());
    }

    @ParameterizedTest
    @ValueSource(longs = {11L, 125L, 1234L, 4897654L, 546857645L})
    void shouldReturnNOTPolydivisible(long number) {
        polidivisible = new Polidivisible(number);
        Assertions.assertFalse(polidivisible.esPolidivisible());
    }

}