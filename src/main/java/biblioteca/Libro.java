package biblioteca;

import java.time.LocalDate;

public class Libro implements Prestable {

    protected final String titulo;
    protected String prestadoA;
    protected LocalDate fechaDevolucion;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void prestarA(String dni, LocalDate fechaDevolucion) {
        this.prestadoA = dni;
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public void devolver() {
        this.prestadoA = null;
        this.fechaDevolucion = null;
    }

    @Override
    public boolean estaPrestado() {
        return prestadoA != null;
    }

    public String getTitulo() {
        return titulo;
    }
}
