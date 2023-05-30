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
     * @param connectors Debe ser un String[] contentiendo "HM", "MH", "HH", "MM". De lo contrario se lanzará una
     *                   excepción por nombre no válido.
     * @throws InvalidNameException
     */
    public Cablejat(String[] connectors) throws InvalidNameException {

        this.connectors = new ArrayList();
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
     * @return
     */
    public boolean esPotConnectar() {
        int mix = Collections.frequency(connectors, "HM") + Collections.frequency(connectors, "MH");
        int male = Collections.frequency(connectors, "HH");
        int female = Collections.frequency(connectors, "MM");

        if ((male + female + mix) < 2) return false;
        if (male == female) return true;
        if ((male + female) <= mix / 2) return true;
        return false;
    }
}
