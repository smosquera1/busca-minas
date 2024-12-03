package main.model;

// Clase que representa a un jugador del juego
public class Jugador {
    private String nombre; // Nombre del jugador

    // Constructor: inicializa al jugador con un nombre
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }
}
