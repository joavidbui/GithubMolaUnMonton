package es.iesmz.ed.algoritmes;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase con un número y un método para determinar cuantos dígitos diferentes tiene.
 */
public class Any {
    long numero;

    /**
     * Constructor para el comprobador de cantidad de dígitos diferentes.
     * @param numero long sobre que el que se ejecutará la función.
     */
    public Any(long numero) {
        this.numero = numero;
    }

    /**
     * Devuelve la cantidad de dígitos diferentes contiene el atributo número.
     * @return int
     */
    public int digitsDiferents(){
        List<Character> uniqueNumbers = new ArrayList<>();

        long unsignedNumero = Math.abs(numero);
        char[] numeroArray = String.valueOf(unsignedNumero).toCharArray();

        for (Character c : numeroArray) {
            if (!uniqueNumbers.contains(c)) uniqueNumbers.add(c);
        }
        return uniqueNumbers.size();
    }
}
