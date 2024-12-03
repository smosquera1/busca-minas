package main.model;

import java.io.Serializable;

public class Tablero implements Serializable {
    // Matriz de casillas que representa el tablero
    private Casilla[][] casillas;
    private int filas = 10; // Número de filas del tablero
    private int columnas = 10; // Número de columnas del tablero
    private int minas = 20; // Número total de minas en el tablero
    private int casillasDescubiertas; // Contador de casillas descubiertas por el jugador

    // Constructor: inicializa el tablero y coloca las minas
    public Tablero() {
        casillas = new Casilla[filas][columnas];
        inicializarTablero(); // Crea casillas vacías
        colocarMinas(); // Distribuye minas aleatoriamente
        calcularNumeros(); // Calcula los números de casillas adyacentes a minas
        casillasDescubiertas = 0; // Inicia el contador de casillas descubiertas en 0
    }

    // Inicializa todas las casillas del tablero como vacías
    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla(); // Cada casilla se crea sin mina inicialmente
            }
        }
    }

    // Coloca las minas aleatoriamente en el tablero
    private void colocarMinas() {
        int colocadas = 0;
        while (colocadas < minas) { // Itera hasta colocar todas las minas
            int fila = (int) (Math.random() * filas);
            int columna = (int) (Math.random() * columnas);
            if (!casillas[fila][columna].tieneMina()) { // Solo coloca una mina si la casilla no tiene ya una
                casillas[fila][columna].ponerMina();
                colocadas++;
            }
        }
    }

    // Calcula los números de cada casilla según las minas adyacentes
    private void calcularNumeros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].tieneMina()) { // Solo calcula números para casillas sin minas
                    int minasAdyacentes = contarMinasAdyacentes(i, j);
                    casillas[i][j].setNumero(minasAdyacentes); // Asigna el número de minas adyacentes
                }
            }
        }
    }

    // Cuenta el número de minas adyacentes a una casilla específica
    private int contarMinasAdyacentes(int fila, int columna) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) { // Recorre las casillas vecinas
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (esValida(nuevaFila, nuevaColumna) && casillas[nuevaFila][nuevaColumna].tieneMina()) {
                    contador++; // Incrementa el contador si encuentra una mina
                }
            }
        }
        return contador;
    }

    // Verifica si una posición en el tablero es válida
    private boolean esValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    // Descubre una casilla específica
    public void descubrirCasilla(int fila, int columna) {
        Casilla casilla = casillas[fila][columna];
        if (!casilla.esDescubierta()) { // Solo descubre casillas no descubiertas
            casilla.descubrir();
            if (!casilla.tieneMina()) { // Si la casilla no tiene mina, incrementa el contador
                casillasDescubiertas++;
            }
        }
    }

    // Verifica si el jugador ha ganado (condición específica)
    public boolean haGanado() {
        return casillasDescubiertas == 10; // Victoria al descubrir exactamente 10 casillas
    }

    // Revela todas las casillas del tablero (usualmente al finalizar el juego)
    public void revelarTodo() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j].descubrir(); // Descubre todas las casillas
            }
        }
    }

    // Devuelve una casilla específica del tablero
    public Casilla obtenerCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    // Obtiene todas las casillas del tablero
    public Casilla[][] getCasillas() {
        return casillas;
    }
}
