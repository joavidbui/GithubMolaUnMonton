package es.iesmz.ed.algoritmes;

/**
 * Clase con un atributo numérico long y una función para determinar si dicho número es polidivisible.
 */
public class Polidivisible {

    private final long numero;

    /**
     * Constructor para el comprobador de que todos un número es polidivisible.
     * @param numero el número sobre el que se realizará la comprobación.
     */
    public Polidivisible(long numero) {
        this.numero = numero;
    }

    /**
     * Función que devuelve un boolean en función de si el atributo "número" del objeto es polidivisible.
     * @return boolean
     */
    public boolean esPolidivisible() {
        String numeroString = String.valueOf(Math.abs(this.numero));
        boolean esPolidivisible = true;
        for (int i = 1; i <= numeroString.length(); i++) {
            long currentNumber = Long.parseLong(numeroString.substring(0, i));
            if (currentNumber % i != 0) {
                esPolidivisible = false;
                break;
            }
        }
        return esPolidivisible;
    }
}
