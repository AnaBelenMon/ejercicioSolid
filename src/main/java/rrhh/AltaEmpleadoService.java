package rrhh;

public class AltaEmpleadoService {
    private final RepositorioEmpleados repositorio;
    private final GenerarPassword generadorPassword;

    public AltaEmpleadoService(RepositorioEmpleados repositorio, GenerarPassword generadorPassword) {
        this.repositorio = repositorio;
        this.generadorPassword = generadorPassword;
    }

    public Empleado alta(String dni, String nombre) {
        if (dni == null || dni.isBlank()) throw new IllegalArgumentException("DNI requerido");


        if (repositorio.existe(dni)) throw new IllegalStateException("Ya existe empleado");

        String passwordTemporal = generadorPassword.generar();
        Empleado e = new Empleado(dni, nombre, passwordTemporal);

        repositorio.guardar(e);

        System.out.println("Creado usuario para " + nombre + " con password temporal: " + passwordTemporal);
        return e;
    }
}
