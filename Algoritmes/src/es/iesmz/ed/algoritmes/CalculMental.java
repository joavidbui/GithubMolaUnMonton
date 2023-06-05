package es.iesmz.ed.algoritmes;

import java.util.ArrayList;

/**
 * Clase con un atributo String - que debe contener una serie de operaciones matemáticas con números naturales - y una
 * función para realizar la serie de cálculos.
 */
public class CalculMental {
    private final String operacio;

    /**
     * Contructor de la clase CalculMental
     * @param operacion Una sucesión de sumas y restas de números naturales en formato String.
     */
    public CalculMental(String operacion) {
        this.operacio = operacion;
    }

    /**
     * Convierte la string almacenada en el objeto en una serie de números naturales, resultados sucesivos de las
     * sumas y restas que ésta indica.
     * @return ArrayList/<Integer/>
     */
    public ArrayList<Integer> calcula() {
        ArrayList<Integer> solucio = new ArrayList<>();
        ArrayList<Integer> nombresEnters = new ArrayList<>();

        String operacioPreparada = operacio.replaceAll("\\+ ", "");
        operacioPreparada = operacioPreparada.replaceAll("- ", "-");

        for (String s : operacioPreparada.split(" ")) {
            nombresEnters.add(Integer.parseInt(s));
        }

        solucio.add(nombresEnters.get(0) + nombresEnters.get(1));
        for (int i = 2; i < nombresEnters.size(); i++) {
            solucio.add(solucio.get(solucio.size()-1) + nombresEnters.get(i));
        }
        return solucio;
    }
}
