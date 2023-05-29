package es.iesmz.ed.algoritmes;

/**
 * Clase con un número long y una función para determinar si todos sus dígitos son pares.
 */
public class Hyperpar {

    private final long numero;
    /**
     * Constructor para el comprobador de que todos los dígitos de un número son pares.
     * @param numero el número sobre el que se realizará la comprobación.
     */
    public Hyperpar(long numero) {
        this.numero = numero;
    }

    /**
     * Función que calcula si todos los dígitos del atributo numero son pares.
     * @return boolean
     */
    public boolean esHyperPar() {
        String hyperPar = String.valueOf(Math.abs(this.numero));
        boolean esHyperPar = true;
        for (int i = 0; i < hyperPar.length(); i++) {
            int currentDigit = Character.getNumericValue(hyperPar.charAt(i));
            if (currentDigit % 2 != 0) {
                esHyperPar = false;
                break;
            }
        }
        return esHyperPar;
    }
}
