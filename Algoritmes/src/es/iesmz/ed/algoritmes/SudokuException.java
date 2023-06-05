package es.iesmz.ed.algoritmes;

/**
 * Throwable que se usa para indicar un error en el constructor de Sudokus.
 */
public class SudokuException extends Throwable {
    public SudokuException(String message) {
        super(message);
    }
}
