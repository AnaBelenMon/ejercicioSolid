package matricula;

import java.time.LocalDate;

public class Matricula {
    private final String dni;
    private final String curso;
    private final LocalDate fecha;
    private final double precioFinal;

    public Matricula(String dni, String curso, LocalDate fecha, double precioFinal) {
        this.dni = dni;
        this.curso = curso;
        this.fecha = fecha;
        this.precioFinal = precioFinal;
    }

    public String getDni() {
        return dni;
    }

    public String getCurso() {
        return curso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    @Override
    public String toString() {
        return dni + " | " + curso + " | " + fecha + " | " + precioFinal;
    }
}
