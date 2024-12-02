package main.model;
import java.io.Serializable;

public class Tablero implements Serializable {
    private Casilla[][] casillas;
    private int filas = 10;
    private int columnas = 10;
    private int minas = 20;
    private int casillasDescubiertas;

    public Tablero() {
        casillas = new Casilla[filas][columnas];
        inicializarTablero();
        colocarMinas();
        calcularNumeros();
        casillasDescubiertas = 0;
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void colocarMinas() {
        int colocadas = 0;
        while (colocadas < minas) {
            int fila = (int) (Math.random() * filas);
            int columna = (int) (Math.random() * columnas);
            if (!casillas[fila][columna].tieneMina()) {
                casillas[fila][columna].ponerMina();
                colocadas++;
            }
        }
    }

    private void calcularNumeros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].tieneMina()) {
                    int minasAdyacentes = contarMinasAdyacentes(i, j);
                    casillas[i][j].setNumero(minasAdyacentes);
                }
            }
        }
    }

    private int contarMinasAdyacentes(int fila, int columna) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (esValida(nuevaFila, nuevaColumna) && casillas[nuevaFila][nuevaColumna].tieneMina()) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private boolean esValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public void descubrirCasilla(int fila, int columna) {
        Casilla casilla = casillas[fila][columna];
        if (!casilla.esDescubierta()) {
            casilla.descubrir();
            if (!casilla.tieneMina()) {
                casillasDescubiertas++;
            }
        }
    }

    public boolean haGanado() {
        return casillasDescubiertas == 10; // Victoria al descubrir 10 casillas.
    }

    public void revelarTodo() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j].descubrir();
            }
        }
    }

    public Casilla obtenerCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }
}
