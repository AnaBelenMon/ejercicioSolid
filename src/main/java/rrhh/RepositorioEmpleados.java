package rrhh;

public interface RepositorioEmpleados {
    boolean existe(String dni);
    void guardar(Empleado e);
}
