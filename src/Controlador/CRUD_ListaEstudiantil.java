package Controlador;

import java.util.ArrayList;
import java.util.Scanner;


class Estudiante {

    String nombre;
    String apellido;
    int edad;
    double notaPromedio;

    public Estudiante(String nombre, String apellido, int edad, double notaPromedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.notaPromedio = notaPromedio;
    }

    @Override
    public String toString() {
        return "Estudiante: " + nombre + " " + apellido + ", Edad: " + edad + ", Nota Promedio: " + notaPromedio;
    }
}

class GestorEstudiantes {

    ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    // Método para crear un nuevo estudiante
    public void crearEstudiante() {
        System.out.println("Ingrese el nombre del estudiante:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del estudiante:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la edad del estudiante:");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt()

        System.out.println("Ingrese la nota promedio del estudiante:");
        double notaPromedio = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea después de nextDouble()

        Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, edad, notaPromedio);
        listaEstudiantes.add(nuevoEstudiante);

        System.out.println("Estudiante creado exitosamente:\n" + nuevoEstudiante);
    }

    // Método para mostrar la lista de estudiantes
    public void mostrarEstudiantes() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("La lista de estudiantes está vacía.");
        } else {
            System.out.println("Lista de estudiantes:");
            for (Estudiante estudiante : listaEstudiantes) {
                System.out.println(estudiante);
            }
        }
    }

    // Método para actualizar los datos de un estudiante existente por su número de identificación
    public void actualizarEstudiante() {
        System.out.println("Ingrese el número de identificación del estudiante a actualizar:");
        int idEstudiante = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt()

        boolean encontrado = false;
        for (Estudiante estudiante : listaEstudiantes) {
            // Supongamos que cada estudiante tiene un identificador único (puedes ajustar según necesites)
            // En este ejemplo, el identificador es la posición en la lista + 1
            if (listaEstudiantes.indexOf(estudiante) + 1 == idEstudiante) {
                encontrado = true;

                System.out.println("Ingrese el nuevo nombre del estudiante:");
                estudiante.nombre = scanner.nextLine();

                System.out.println("Ingrese el nuevo apellido del estudiante:");
                estudiante.apellido = scanner.nextLine();

                System.out.println("Ingrese la nueva edad del estudiante:");
                estudiante.edad = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después de nextInt()

                System.out.println("Ingrese la nueva nota promedio del estudiante:");
                estudiante.notaPromedio = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea después de nextDouble()

                System.out.println("Datos del estudiante actualizados exitosamente:\n" + estudiante);
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Estudiante no encontrado. Verifica el número de identificación.");
        }
    }

    // Método para eliminar un estudiante existente por su número de identificación
    public void eliminarEstudiante() {
        System.out.println("Ingrese el número de identificación del estudiante a eliminar:");
        int idEstudiante = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt()

        boolean eliminado = false;
        for (Estudiante estudiante : listaEstudiantes) {
            if (listaEstudiantes.indexOf(estudiante) + 1 == idEstudiante) {
                listaEstudiantes.remove(estudiante);
                eliminado = true;
                System.out.println("Estudiante eliminado exitosamente.");
                break;
            }
        }

        if (!eliminado) {
            System.out.println("Estudiante no encontrado. Verifica el número de identificación.");
        }
    }
}

public class CRUD_ListaEstudiantil {

    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear nuevo estudiante");
            System.out.println("2. Mostrar lista de estudiantes");
            System.out.println("3. Actualizar datos de un estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Salir");

            System.out.println("Ingrese su opción:");
            int opcion = gestor.scanner.nextInt();
            gestor.scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    gestor.crearEstudiante();
                    break;
                case 2:
                    gestor.mostrarEstudiantes();
                    break;
                case 3:
                    gestor.actualizarEstudiante();
                    break;
                case 4:
                    gestor.eliminarEstudiante();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
