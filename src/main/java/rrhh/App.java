package rrhh;

public class App {
    public static void main(String[] args) {

        RepositorioEmpleados repo = new RepositorioEmpleadosEnMemoria();
        GenerarPassword generador = new GeneradorPasswordSimple();

        AltaEmpleadoService s = new AltaEmpleadoService(repo, generador);

        s.alta("11111111A", "Lucía");
        s.alta("22222222B", "Álvaro");
    }
}
