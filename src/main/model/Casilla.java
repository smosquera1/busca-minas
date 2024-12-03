package main.model;

import java.io.Serializable;

// Clase que representa una casilla del tablero
public class Casilla implements Serializable {
    private boolean tieneMina; // Indica si la casilla contiene una mina
    private int numero; // Número de minas adyacentes a la casilla
    private boolean descubierta; // Indica si la casilla ha sido descubierta

    // Método para verificar si la casilla tiene una mina
    public boolean tieneMina() {
        return tieneMina;
    }

    // Método para colocar una mina en la casilla
    public void ponerMina() {
        this.tieneMina = true;
    }

    // Método para asignar el número de minas adyacentes
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Método para verificar si la casilla ha sido descubierta
    public boolean esDescubierta() {
        return descubierta;
    }

    // Método para descubrir la casilla
    public void descubrir() {
        descubierta = true;
    }

    // Representación textual de la casilla para depuración o visualización
    @Override
    public String toString() {
        if (!descubierta) { // Si la casilla no está descubierta, muestra un "-"
            return "-";
        } else if (tieneMina) { // Si la casilla tiene una mina, muestra una "X"
            return "X";
        } else { // Si no tiene mina, muestra el número de minas adyacentes
            return String.valueOf(numero);
        }
    }
}
