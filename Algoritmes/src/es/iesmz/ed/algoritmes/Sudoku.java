package es.iesmz.ed.algoritmes;

import java.util.ArrayList;

public class Sudoku {
    int [][] matriuSudoku;

    public Sudoku(int[][] matriuSudoku) {
        this.matriuSudoku = matriuSudoku;
    }

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
