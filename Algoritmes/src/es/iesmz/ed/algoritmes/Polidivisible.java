package es.iesmz.ed.algoritmes;

public class Polidivisible {

    private long numero;

    public Polidivisible(long numero) {
        this.numero = numero;
    }

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
