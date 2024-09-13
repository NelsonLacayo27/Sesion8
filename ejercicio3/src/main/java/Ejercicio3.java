import java.util.Scanner;

// Clase Libro
class Libro {
    private String titulo;
    private boolean disponible;

    // Constructor
    public Libro(String titulo) {
        this.titulo = titulo;
        this.disponible = true;
    }

    // Método para obtener el título del libro
    public String getTitulo() {
        return titulo;
    }

    // Método para verificar la disponibilidad
    public boolean isDisponible() {
        return disponible;
    }

    // Método para prestar el libro
    public boolean prestar() {
        if (disponible) {
            disponible = false; // Si está disponible, lo prestamos (ya no disponible)
            return true;
        } else {
            return false; // No disponible para prestar
        }
    }

    // Método para devolver el libro
    public void devolver() {
        disponible = true; // El libro vuelve a estar disponible
    }
}



class SistemaBiblioteca {
    // Arreglo de libros (almacena el inventario)
    private Libro[] libros;

    // Constructor
    public SistemaBiblioteca(int cantidadLibros) {
        libros = new Libro[cantidadLibros];
    }

    // Método para agregar un libro al sistema
    public void agregarLibro(Libro libro, int index) {
        if (index >= 0 && index < libros.length) {
            libros[index] = libro;
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Método para prestar un libro
    public void prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro != null && libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.prestar()) {
                    System.out.println("El libro '" + titulo + "' ha sido prestado.");
                } else {
                    System.out.println("El libro '" + titulo + "' no está disponible.");
                }
                return;
            }
        }
        System.out.println("El libro '" + titulo + "' no se encuentra en el sistema.");
    }

    // Método para devolver un libro
    public void devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro != null && libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.devolver();
                System.out.println("El libro '" + titulo + "' ha sido devuelto.");
                return;
            }
        }
        System.out.println("El libro '" + titulo + "' no se encuentra en el sistema.");
    }

    // Método para mostrar el estado de los libros
    public void mostrarLibros() {
        for (Libro libro : libros) {
            if (libro != null) {
                System.out.println("Libro: " + libro.getTitulo() + " | Disponible: " + (libro.isDisponible() ? "Sí" : "No"));
            }
        }
    }

    // Método para ejecutar el sistema interactivo
    public void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Prestar un libro");
            System.out.println("2. Devolver un libro");
            System.out.println("3. Mostrar todos los libros");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el título del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    prestarLibro(tituloPrestar);
                    break;
                case 2:
                    System.out.print("Ingresa el título del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    devolverLibro(tituloDevolver);
                    break;
                case 3:
                    mostrarLibros();
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

        SistemaBiblioteca biblioteca = new SistemaBiblioteca(3);


        biblioteca.agregarLibro(new Libro("Cien Años de Soledad"), 0);
        biblioteca.agregarLibro(new Libro("Don Quijote de la Mancha"), 1);
        biblioteca.agregarLibro(new Libro("1984"), 2);


        biblioteca.iniciarSistema();
    }
}
