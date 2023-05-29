package es.iesmz.ed.algoritmes;

/**
 * Clase con un atributo long y una función para calcular su suma descendiente.
 */
public class SumaDescendent {
    long numero;

    /**
     * Constructor para el objeto que realiza sumas descendientes de un número.
     * @param numero el número sobre el que se realizará la operación.
     */
    public SumaDescendent(long numero) {
        this.numero = numero;
    }

    /**
     * Función que devuelve la suma descendiente del número almacenado en el atributo "numero".
     * @return long. Devuelve -1 en caso de error.
     */
    public long suma() {
        String sumaString = String.valueOf(Math.abs(this.numero));
        long res = 0L;
        for (int i = 0; i < sumaString.length(); i++) {
            try {
                long currentNumber = Long.parseLong(sumaString.substring(i));
                res += currentNumber;
            } catch (NumberFormatException nfe) {
                return -1L;
            }
        }
        return (res < 0) ? -1 : res;
    }
}
