package rrhh;
import java.util.UUID;

public class GeneradorPasswordSimple implements GenerarPassword {
    @Override
    public String generar() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
