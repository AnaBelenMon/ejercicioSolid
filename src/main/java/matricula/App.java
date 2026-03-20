package matricula;

public class App {
    public static void main(String[] args) {

        MatriculaService servicio = new MatriculaService(
                new validarDni(),
                new calcularPrecioMatricula(),
                new repositorioMatriculasEnMemoria(),
                new notificadorConsola(),
                new exportadorMatriculaTexto()
        );

        servicio.crearMatricula("12345678A", "DAM1", 300, true);
        servicio.crearMatricula("87654321B", "SMR2", 200, false);

        System.out.println(servicio.exportarResumen());
    }
}
