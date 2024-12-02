package main.model;

import java.io.Serializable;

public class Casilla implements Serializable {
    private boolean tieneMina;
    private int numero;
    private boolean descubierta;

    public boolean tieneMina() {
        return tieneMina;
    }

    public void ponerMina() {
        this.tieneMina = true;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean esDescubierta() {
        return descubierta;
    }

    public void descubrir() {
        descubierta = true;
    }

    @Override
    public String toString() {
        if (!descubierta) {
            return "-";
        } else if (tieneMina) {
            return "X";
        } else {
            return String.valueOf(numero);
        }
    }
}
