package biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        PrestamoService service = new PrestamoService();

        Libro libro1 = new Libro("Dune");
        LibroReferencia ref = new LibroReferencia("Diccionario RAE");

        // PRESTAR
        service.prestar(libro1, "12345678A");

        // Intento de prestar referencia → NO permitido
        System.out.println("\nIntentando prestar libro de referencia:");
        System.out.println(ref.getTitulo() + " NO se puede prestar.");

        System.out.println();

        // DEVOLVER
        System.out.println("Devuelto (" + libro1.getTitulo() + "): " + service.devolver(libro1));
    }
}
