package es.iesmz.ed.algoritmes;

import java.util.ArrayList;

public class CalculMental {
    private String operacio;

    public CalculMental(String operacion) {
        this.operacio = operacion;
    }

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
