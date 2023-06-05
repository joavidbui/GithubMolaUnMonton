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

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {


    static Sudoku sudoku;

    @BeforeEach
    void setUp() {
        sudoku = null;
    }

    @ParameterizedTest
    @MethodSource("InputsSudokuEsCorrecteShouldReturnTrue")
        // six numbers
    void sudokuEsCorrecteShouldReturnTrue(int[][] inputSudoku, ArrayList<Integer> expectedOutputs) {
        sudoku = new Sudoku(inputSudoku);
        Assertions.assertTrue(sudoku.esCorrecte());
    }

    private static Stream<Arguments> InputsSudokuEsCorrecteShouldReturnTrue() {
        return Stream.of(
                Arguments.of((Object) new int[][]{
                        { 4, 1, 3, 8, 2, 5, 6, 7, 9 },
                        { 5, 6, 7, 1, 4, 9, 8, 3, 2 },
                        { 2, 8, 9, 7, 3, 6, 1, 4, 5 },
                        { 1, 9, 5, 4, 6, 2, 7, 8, 3 },
                        { 7, 2, 6, 9, 8, 3, 5, 1, 4 },
                        { 3, 4, 8, 5, 1, 7, 2, 9, 6 },
                        { 8, 5, 1, 6, 9, 4, 3, 2, 7 },
                        { 9, 7, 2, 3, 5, 8, 4, 6, 1 },
                        { 6, 3, 4, 2, 7, 1, 9, 5, 8 }})
                );
    }

}