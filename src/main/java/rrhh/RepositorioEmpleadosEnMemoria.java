package rrhh;
import java.util.HashMap;
import java.util.Map;

public class RepositorioEmpleadosEnMemoria implements RepositorioEmpleados {
    private final Map<String, Empleado> bd = new HashMap<>();

    @Override
    public boolean existe(String dni) {
        return bd.containsKey(dni);
    }

    @Override
    public void guardar(Empleado e) {
        bd.put(e.getDni(), e);
    }
}
