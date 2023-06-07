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

        // CHECK FILES
        for (int i = 0; i < 9; i++) {
            nombresUtilitzats.clear();
            for (int j = 0; j < 9; j++) {
                if (nombresUtilitzats.contains(matriuSudoku[i][j])) return false;
                else nombresUtilitzats.add(matriuSudoku[i][j]);
            }
        }

        // CHECK COLUMNES
        for (int i = 0; i < 9; i++) {
            nombresUtilitzats.clear();
            for (int j = 0; j < 9; j++) {
                if (nombresUtilitzats.contains(matriuSudoku[j][i])) return false;
                else nombresUtilitzats.add(matriuSudoku[j][i]);
            }
        }

        // CHECK QUADRANTS 3x3
        for(int k = 0; k < 9; k++) {
            nombresUtilitzats.clear();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int casillaX = ( i+(k/3)*3 );
                    int casillaY = ( j + (k%3) * 3);

                    if (nombresUtilitzats.contains(matriuSudoku[casillaX][casillaY])) return false;
                    else nombresUtilitzats.add(matriuSudoku[casillaX][casillaY]);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        try {
            Sudoku sudo =  new Sudoku(new int[][]{
                    { 4, 1, 3, 8, 2, 5, 6, 7, 9 },
                    { 5, 6, 7, 1, 4, 9, 8, 3, 2 },
                    { 2, 8, 9, 7, 3, 6, 1, 4, 5 },
                    { 1, 9, 5, 4, 6, 2, 7, 8, 3 },
                    { 7, 2, 6, 9, 8, 3, 5, 1, 4 },
                    { 3, 4, 8, 5, 1, 7, 2, 9, 6 },
                    { 8, 5, 1, 6, 9, 4, 3, 2, 7 },
                    { 9, 7, 2, 3, 5, 8, 4, 6, 1 },
                    { 6, 3, 4, 2, 7, 1, 9, 5, 8 }});
            System.out.println(sudo.esCorrecte());
        } catch (SudokuException e) {
            throw new RuntimeException(e);
        }
        try {
            Sudoku sudo2 =  new Sudoku(new int[][]{
                    { 1, 1, 3, 8, 2, 5, 6, 7, 9 },
                    { 5, 6, 7, 1, 4, 9, 8, 3, 2 },
                    { 2, 8, 9, 7, 3, 6, 1, 4, 5 },
                    { 1, 9, 5, 4, 6, 2, 7, 8, 3 },
                    { 7, 2, 6, 9, 8, 3, 5, 1, 4 },
                    { 3, 4, 8, 5, 1, 7, 2, 9, 6 },
                    { 8, 5, 1, 6, 9, 4, 3, 2, 7 },
                    { 9, 7, 2, 3, 5, 8, 4, 6, 1 },
                    { 6, 3, 4, 2, 7, 1, 9, 5, 8 }});
            System.out.println(sudo2.esCorrecte());
        } catch (SudokuException e) {
            throw new RuntimeException(e);
        }
    }
}
