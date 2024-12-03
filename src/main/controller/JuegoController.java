package main.controller;

import main.model.Tablero;
import main.model.Jugador;
import main.view.VistaConsola;

import java.io.*;
import java.util.Scanner;

public class JuegoController {
    private Tablero tablero; // Modelo del tablero del juego
    private Jugador jugador; // Jugador actual
    private VistaConsola vista; // Vista para interactuar con el usuario
    private Scanner scanner; // Para leer las entradas del usuario

    public JuegoController() {
        vista = new VistaConsola();
        scanner = new Scanner(System.in);
    }

    /**
     * Método principal para iniciar el juego.
     * Solicita el nombre del jugador, carga una partida guardada si es necesario,
     * y llama al método recursivo para manejar el juego.
     */
    public void iniciarJuego() {
        vista.mostrarMensaje("¡Bienvenido al Buscaminas!");
        vista.mostrarMensaje("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        jugador = new Jugador(nombre); // Crear el jugador con el nombre ingresado

        vista.mostrarMensaje("¿Deseas cargar una partida guardada? (s/n): ");
        String opcion = scanner.nextLine();
        if (opcion.equalsIgnoreCase("s")) {
            cargarPartida(); // Cargar el estado guardado del juego
        } else {
            tablero = new Tablero(); // Crear un nuevo tablero
        }

        jugar(); // Llamada al método recursivo para manejar el juego
    }

    /**
     * Método recursivo que maneja el flujo del juego.
     * Permite al jugador realizar acciones (descubrir una casilla o guardar el juego).
     * Termina cuando el jugador gana, pierde o guarda la partida.
     */
    private void jugar() {
        vista.mostrarTablero(tablero.getCasillas()); // Mostrar el estado actual del tablero
        vista.mostrarMensaje("Introduce una coordenada (Ej: A5) o escribe 'guardar' para guardar la partida: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("guardar")) { // Opción para guardar el juego
            guardarPartida();
            vista.mostrarMensaje("Partida guardada. ¡Hasta luego!");
            return; // Salir de la recursión
        }

        try {
            // Convertir la entrada del jugador a coordenadas del tablero
            int fila = input.charAt(0) - 'A';
            int columna = Integer.parseInt(input.substring(1)) - 1;

            // Descubrir la casilla seleccionada
            tablero.descubrirCasilla(fila, columna);

            if (tablero.getCasillas()[fila][columna].tieneMina()) {
                // Caso de derrota: el jugador descubre una mina
                vista.mostrarMensaje("¡Boom! Has perdido.");
                vista.mostrarTablero(tablero.getCasillas()); // Mostrar el tablero final
                return; // Salir de la recursión
            } else if (tablero.haGanado()) {
                // Caso de victoria: el jugador ha descubierto suficientes casillas seguras
                vista.mostrarMensaje("¡Felicidades, " + jugador.getNombre() + "! Has ganado.");
                tablero.revelarTodo(); // Revelar todo el tablero al ganar
                vista.mostrarTablero(tablero.getCasillas());
                return; // Salir de la recursión
            }
        } catch (Exception e) {
            // Manejar entradas inválidas (como coordenadas fuera de rango o formato incorrecto)
            vista.mostrarMensaje("Entrada inválida. Inténtalo de nuevo.");
        }

        jugar(); // Llamada recursiva para continuar el juego
    }

    /**
     * Guarda el estado actual del tablero en un archivo binario.
     */
    private void guardarPartida() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("partidaGuardada.dat"))) {
            oos.writeObject(tablero); // Serializar el objeto tablero
            vista.mostrarMensaje("Partida guardada con éxito.");
        } catch (IOException e) {
            // Manejo de errores durante el guardado
            vista.mostrarMensaje("Error al guardar la partida: " + e.getMessage());
        }
    }

    /**
     * Carga el estado del tablero desde un archivo binario.
     * Si no se puede cargar, crea un nuevo tablero.
     */
    private void cargarPartida() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("partidaGuardada.dat"))) {
            tablero = (Tablero) ois.readObject(); // Deserializar el objeto tablero
            vista.mostrarMensaje("Partida cargada con éxito.");
        } catch (IOException | ClassNotFoundException e) {
            // Manejo de errores durante la carga
            vista.mostrarMensaje("No se pudo cargar la partida: " + e.getMessage());
            tablero = new Tablero(); // Crear un nuevo tablero si no se puede cargar
        }
    }
}