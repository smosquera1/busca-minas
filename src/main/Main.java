package main;

import main.controller.JuegoController;

public class Main {

	/**
	 * Punto de entrada principal del programa.
	 * Crea una instancia del controlador del juego y lo inicializa.
	 */
	public static void main(String[] args) {
		// Crear una instancia del controlador del juego
		JuegoController controller = new JuegoController();

		// Iniciar el juego llamando al método principal del controlador
		controller.iniciarJuego();
	}
}
