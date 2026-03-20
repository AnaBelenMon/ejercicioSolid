package matricula;

import java.time.LocalDate;

public class MatriculaService {

    private final validarDni validador;
    private final calcularPrecioMatricula calculadora;
    private final repositorioMatriculas repo;
    private final notificador notificador;
    private final exportarMatricula exportador;

    public MatriculaService(validarDni validador, calcularPrecioMatricula calculadora, repositorioMatriculas repo, notificador notificador, exportarMatricula exportador) {
        this.validador = validador;
        this.calculadora = calculadora;
        this.repo = repo;
        this.notificador = notificador;
        this.exportador = exportador;
    }

    public Matricula crearMatricula(String dni, String curso, double precioBase, boolean bonificacion) {
        validador.validarDni(dni);
        double precioFinal = calculadora.calcularPrecio(precioBase, bonificacion);

        Matricula m = new Matricula(dni, curso, LocalDate.now(), precioFinal);
        repo.guardarMatricula(m);

        notificador.notificar("Matriculado " + dni + " en " + curso + " por " + precioFinal + "€");

        return m;
    }
    public String exportarResumen() {
        return exportador.exportarMatricula(repo.listarMatriculas());
    }
}
