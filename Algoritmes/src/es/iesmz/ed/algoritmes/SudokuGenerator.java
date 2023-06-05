package es.iesmz.ed.algoritmes;

import java.lang.*;

public class SudokuGenerator {
    int[][] sudokuBoard;
    int N;
    int SRN;

    SudokuGenerator(boolean shouldBeWrong)
    {
        this.N = 9;

        // Compute square root of N
        double SRNd = Math.sqrt(N);
        SRN = (int) SRNd;

        sudokuBoard = new int[N][N];

        fillValues();

        if (shouldBeWrong) {
            int wrongColumn = randomGenerator(8);
            int wrongNumber = randomGenerator(8);
            for (int i = 0; i < 9; i++) {
                sudokuBoard[wrongColumn][i] = wrongNumber;
            }
        }
    }

    public int[][] getSudokuBoard() {
        return sudokuBoard;
    }

    public void fillValues()
    {
        fillDiagonal();
        fillRemaining(0, SRN);
    }

    void fillDiagonal()
    {

        for (int i = 0; i<N; i=i+SRN)
            fillBox(i, i);
    }

    boolean unUsedInBox(int rowStart, int colStart, int num)
    {
        for (int i = 0; i<SRN; i++)
            for (int j = 0; j<SRN; j++)
                if (sudokuBoard[rowStart+i][colStart+j]==num)
                    return false;

        return true;
    }

    void fillBox(int row,int col)
    {
        int num;
        for (int i=0; i<SRN; i++)
        {
            for (int j=0; j<SRN; j++)
            {
                do
                {
                    num = randomGenerator(N);
                }
                while (!unUsedInBox(row, col, num));

                sudokuBoard[row+i][col+j] = num;
            }
        }
    }

    int randomGenerator(int num)
    {
        return (int) Math.floor((Math.random()*num+1));
    }

    boolean CheckIfSafe(int i,int j,int num)
    {
        return (unUsedInRow(i, num) &&
                unUsedInCol(j, num) &&
                unUsedInBox(i-i%SRN, j-j%SRN, num));
    }

    boolean unUsedInRow(int i,int num)
    {
        for (int j = 0; j<N; j++)
            if (sudokuBoard[i][j] == num)
                return false;
        return true;
    }

    boolean unUsedInCol(int j,int num)
    {
        for (int i = 0; i<N; i++)
            if (sudokuBoard[i][j] == num)
                return false;
        return true;
    }

    boolean fillRemaining(int i, int j)
    {
        if (j>=N && i<N-1)
        {
            i = i + 1;
            j = 0;
        }
        if (i>=N && j>=N)
            return true;

        if (i < SRN)
        {
            if (j < SRN)
                j = SRN;
        }
        else if (i < N-SRN)
        {
            if (j== (i/SRN) *SRN)
                j =  j + SRN;
        }
        else
        {
            if (j == N-SRN)
            {
                i = i + 1;
                j = 0;
                if (i>=N)
                    return true;
            }
        }

        for (int num = 1; num<=N; num++)
        {
            if (CheckIfSafe(i, j, num))
            {
                sudokuBoard[i][j] = num;
                if (fillRemaining(i, j+1))
                    return true;

                sudokuBoard[i][j] = 0;
            }
        }
        return false;
    }
}