package es.iesmz.ed.algoritmes;

import java.util.ArrayList;

/**
 * Clase con un atributo int[9][9] (Un sudoku resuelto) y un método para comprobar si está resuelto correctamente.
 */
public class Sudoku {
    int[][] matriuSudoku;

    /**
     * El constructor del objeto Sudoku.
     *
     * @param matriuSudoku Vector bidimensional de 9x9 numeros enteros.
     * @throws SudokuException Si el parámetro no es un vector de 9x9
     */
    public Sudoku(int[][] matriuSudoku) throws SudokuException {
        if (matriuSudoku.length != 9 || matriuSudoku[0].length != 9)
            throw new SudokuException("El sudoku debe ser " + "de " + "9x9.");
        this.matriuSudoku = matriuSudoku;
    }

    /**
     * Devuelve si el sudoku del atributo matriuSudoku está correctamente resuelto.
     *
     * @return boolena
     */
    public boolean esCorrecte() {
        ArrayList<Integer> nombresUtilitzats = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            nombresUtilitzats.clear();
            for (int j = 0; j < 9; j++) {
                if (nombresUtilitzats.contains(matriuSudoku[i][j])) return false;
                else nombresUtilitzats.add(matriuSudoku[i][j]);
            }
        }
        return true;
    }
}
