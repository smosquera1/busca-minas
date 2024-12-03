package main.view;

import main.model.Casilla;

public class VistaConsola {

    /**
     * Muestra el tablero del juego en formato de consola.
     * Las filas están etiquetadas con letras (A-J) y las columnas con números (1-10).
     *
     * @param casillas Matriz bidimensional que representa el estado actual del tablero.
     */
    public void mostrarTablero(Casilla[][] casillas) {
        System.out.println("  1 2 3 4 5 6 7 8 9 10"); // Encabezado de columnas
        char filaLetra = 'A'; // Letras para las filas
        for (int i = 0; i < casillas.length; i++) {
            System.out.print(filaLetra++ + " "); // Etiqueta de la fila
            for (int j = 0; j < casillas[i].length; j++) {
                // Imprimir cada casilla del tablero usando su método toString()
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }

    /**
     * Muestra un mensaje al usuario en la consola.
     *
     * @param mensaje Mensaje que se mostrará.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje); // Imprimir el mensaje recibido
    }
}
