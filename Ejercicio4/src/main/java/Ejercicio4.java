import java.util.ArrayList;
import java.util.Scanner;

// Clase Nota
class Nota {
    private String estudiante;
    private String materia;
    private double calificacion;

    // Constructor
    public Nota(String estudiante, String materia, double calificacion) {
        this.estudiante = estudiante;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    // Getters
    public String getEstudiante() {
        return estudiante;
    }

    public String getMateria() {
        return materia;
    }

    public double getCalificacion() {
        return calificacion;
    }
}

// Clase ControlDeNotas
class ControlDeNotas {
    private ArrayList<Nota> notas;  // Arreglo dinámico de notas

    // Constructor
    public ControlDeNotas() {
        this.notas = new ArrayList<>();
    }

    // Método para añadir una nota
    public void agregarNota(String estudiante, String materia, double calificacion) {
        Nota nuevaNota = new Nota(estudiante, materia, calificacion);
        notas.add(nuevaNota);
        System.out.println("Nota añadida: " + estudiante + " - " + materia + " - " + calificacion);
    }

    // Método para calcular el promedio de un estudiante
    public void calcularPromedio(String estudiante) {
        double suma = 0;
        int contador = 0;

        for (Nota nota : notas) {
            if (nota.getEstudiante().equalsIgnoreCase(estudiante)) {
                suma += nota.getCalificacion();
                contador++;
            }
        }

        if (contador > 0) {
            double promedio = suma / contador;
            System.out.println("El promedio de " + estudiante + " es: " + promedio);
        } else {
            System.out.println("No se encontraron notas para el estudiante " + estudiante);
        }
    }

    // Método para listar todas las notas de un estudiante
    public void listarNotas(String estudiante) {
        System.out.println("Notas de " + estudiante + ":");
        boolean tieneNotas = false;

        for (Nota nota : notas) {
            if (nota.getEstudiante().equalsIgnoreCase(estudiante)) {
                System.out.println("Materia: " + nota.getMateria() + " - Calificación: " + nota.getCalificacion());
                tieneNotas = true;
            }
        }

        if (!tieneNotas) {
            System.out.println("No se encontraron notas para el estudiante " + estudiante);
        }
    }

    // Método para interactuar con el sistema
    public void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Añadir una nota");
            System.out.println("2. Calcular promedio de un estudiante");
            System.out.println("3. Listar todas las notas de un estudiante");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    String estudiante = scanner.nextLine();
                    System.out.print("Materia: ");
                    String materia = scanner.nextLine();
                    System.out.print("Calificación: ");
                    double calificacion = scanner.nextDouble();
                    agregarNota(estudiante, materia, calificacion);
                    break;
                case 2:
                    System.out.print("Nombre del estudiante para calcular promedio: ");
                    String estudiantePromedio = scanner.nextLine();
                    calcularPromedio(estudiantePromedio);
                    break;
                case 3:
                    System.out.print("Nombre del estudiante para listar notas: ");
                    String estudianteNotas = scanner.nextLine();
                    listarNotas(estudianteNotas);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ControlDeNotas control = new ControlDeNotas();
        control.iniciarSistema();
    }
}

