# Buscaminas en Consola (Java)

## Descripción
Este proyecto es una implementación en consola del clásico juego de **Buscaminas** desarrollado en Java. El diseño sigue el patrón **Modelo-Vista-Controlador (MVC)**, utilizando conceptos de programación orientada a objetos como **encapsulamiento**, **herencia**, y **manejo de excepciones**.

El programa permite a los usuarios jugar una partida, guardar y cargar su progreso, y seguir un flujo lógico hasta ganar o perder el juego.

## Estructura del proyecto
        busca-minas/
        ├── src/
        │   ├── main/
        │   │   ├── controller/
        │   │   │   └── JuegoController.java
        │   │   ├── model/
        │   │   │   ├── Tablero.java
        │   │   │   ├── Casilla.java
        │   │   │   └── Jugador.java
        │   │   ├── view/
        │   │   │   └── VistaConsola.java
        │   │   └── Main.java
        ├── partidaGuardada.dat
        └── README.md


## Características Principales

### Patrón MVC
El programa organiza su lógica siguiendo el patrón MVC:
1. **Modelo**:
   - Representa las entidades principales del juego: `Tablero`, `Casilla`, y `Jugador`.
   - Gestiona el estado del tablero y la lógica del juego.
2. **Vista**:
   - Interactúa con el usuario a través de la consola para mostrar el tablero y los mensajes relevantes.
3. **Controlador**:
   - Maneja el flujo del juego conectando el modelo y la vista.
   - Contiene lógica recursiva para gestionar turnos y acciones.

### Manejo de Excepciones
Se utiliza `try-catch` para:
- Validar las entradas del usuario (coordenadas o comandos).
- Manejar errores durante la carga y el guardado de partidas.

### Programación Orientada a Objetos
- **Clases**: `Tablero`, `Casilla`, `Jugador`, etc., separan responsabilidades.
- **Encapsulamiento**: Los atributos están protegidos y accesibles mediante métodos.
- **Herencia y Polimorfismo**: El diseño modular facilita la escalabilidad y el mantenimiento.

---

## Cómo Funciona el Juego

### Inicio
1. Al ejecutar el programa, el usuario es recibido con un mensaje de bienvenida.
2. Se solicita al jugador su nombre.
3. El usuario puede elegir entre:
   - Cargar una partida guardada.
   - Comenzar una nueva partida.

### Flujo del Juego
- El tablero (10x10) contiene 20 minas colocadas aleatoriamente.
- Cada casilla puede estar cubierta (`-`), descubierta con un número (indica minas cercanas), o mostrar una mina (`X`).
- El jugador introduce coordenadas (ejemplo: `A5`) para descubrir una casilla.

### Guardar y Cargar Partidas
- **Guardar**: El jugador puede escribir `guardar` para almacenar el estado actual del juego en un archivo binario (`partidaGuardada.dat`).
- **Cargar**: Al inicio del programa, puede cargar una partida previamente guardada.

### Finalización del Juego
1. **Victoria**:
   - El jugador gana al descubrir 10 casillas que no contengan minas.
   - Al ganar, el programa revela todo el tablero.
2. **Derrota**:
   - El jugador pierde si descubre una mina.

---

## Ejecución del Programa

### Requisitos
- **Java 8** o superior instalado.

## Instrucciones para abrir y ejecutar el proyecto Busca-Minas en IntelliJ IDEA y Eclipse

### IntelliJ IDEA

1. **Descarga del proyecto**  
   Descarga el proyecto en tu máquina.

2. **Abre IntelliJ IDEA**  
   - Abre IntelliJ IDEA.  
   - Ve a **File > Open** y selecciona la carpeta donde descargaste el proyecto `busca-minas`.

3. **Configuración automática**  
   IntelliJ IDEA detectará automáticamente que es un proyecto de Java y configurará todo lo necesario.

4. **Sincronización**  
   Espera a que IntelliJ sincronice los archivos (este proceso puede tomar unos segundos).

5. **Ejecuta el programa**  
   - Navega a la clase `Main.java` ubicada en `src/main/`.
   - Haz clic derecho en el archivo y selecciona **Run 'Main.main()'**.

6. **Verifica la ejecución**  
   El programa se ejecutará en la consola de IntelliJ.


### Eclipse

1. **Descarga del proyecto**  
   Descarga el proyecto en tu máquina.

2. **Abre Eclipse**  
   - Inicia Eclipse.  
   - Ve a **File > Import**.

3. **Importar el proyecto**  
   - Selecciona la opción **Existing Projects into Workspace**.  
   - Haz clic en **Next**.  
   - Busca la carpeta donde descargaste el proyecto `busca-minas` y selecciónala.

4. **Configuración automática**  
   Eclipse detectará el proyecto como un proyecto de Java y configurará lo necesario.

5. **Ejecuta el programa**  
   - Navega al archivo `Main.java` ubicado en `src/main/`.  
   - Haz clic derecho en el archivo y selecciona **Run As > Java Application**.

6. **Verifica la ejecución**  
   El programa se ejecutará en la consola de Eclipse.



