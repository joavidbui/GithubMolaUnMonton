package es.iesmz.ed.algoritmes;

public class SumaDescendent {
    long numero;

    public SumaDescendent(long numero) {
        this.numero = numero;
    }

    public long suma() {
        String sumaString = String.valueOf(Math.abs(this.numero));
        long res = 0L;
        for (int i = 0; i < sumaString.length(); i++) {
            long currentNumber = Long.valueOf(sumaString.substring(i));
            res += currentNumber;
        }
        return res;
    }

}
