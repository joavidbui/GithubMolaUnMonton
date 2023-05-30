package es.iesmz.ed.algoritmes;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase con un atributo Array de Strings y una función para calcular su suma descendiente.
 */
public class Cablejat {
    List<String> connectors;

    /**
     * Constructor para el comprobador de que todos los cables de un array se podrían conectar hasta formar un
     * circuito cerrado.
     * @param connectors Debe ser un array de Strings conteniendo los nombres de los cables.
     * @throws InvalidNameException Si alguno de los nombres no es "HH", "HM", "MH" o "MM".
     */
    public Cablejat(String[] connectors) throws InvalidNameException {

        this.connectors = new ArrayList<>();
        for (String s : connectors) {
            if (!s.equalsIgnoreCase("HM") && !s.equalsIgnoreCase("MH") && !s.equalsIgnoreCase(
                    "HH") && !s.equalsIgnoreCase("MM")) {
                throw new InvalidNameException("Error al crear el arraylist.");
            }
            this.connectors.add(s.toUpperCase());
        }
    }

    /**
     * Función que devuelve true si los cables del atributo "connectors" se podrían conectar hasta formar un circuito
     * cerrado.
     * @return boolean
     */
    public boolean esPotConnectar() {
        int mix = Collections.frequency(connectors, "HM") + Collections.frequency(connectors, "MH");
        int male = Collections.frequency(connectors, "HH");
        int female = Collections.frequency(connectors, "MM");

        if ((male + female + mix) < 2) return false;
        if (male == female) return true;
        return ((male + female) <= mix / 2);
    }
}
