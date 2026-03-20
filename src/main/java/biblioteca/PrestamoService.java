package biblioteca;

import java.time.LocalDate;

public class PrestamoService {

    public void prestar(Prestable libro, String dni) {
        if (libro.estaPrestado()) {
            throw new IllegalStateException("Ya estaba prestado");
        }
        libro.prestarA(dni, LocalDate.now().plusDays(14));
        System.out.println("Prestado: " + ((Libro) libro).getTitulo() + " a " + dni);
    }

    public boolean devolver(Prestable libro) {
        libro.devolver();
        return !libro.estaPrestado();
    }
}
