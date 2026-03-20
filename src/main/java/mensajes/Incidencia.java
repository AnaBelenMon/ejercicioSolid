package mensajes;

public class Incidencia extends Mensaje{
    private final String alumno;
    private final String tutoria;
    private final String gravedad;

    public Incidencia(String canal, String titulo, String cuerpo, String alumno, String tutoria, String gravedad) {
        super(canal, titulo, cuerpo);
        this.alumno = alumno;
        this.tutoria = tutoria;
        this.gravedad = gravedad;
    }

    @Override
    public String texto() {
        return getCabecera() + "Incidencia (" + gravedad + "): " + getTitulo() + "\n" +
                "Alumno/a: " + alumno + "\n" +
                "Tutoría: " + tutoria + "\n" +
                "Detalle: " + getCuerpo() + "\n";
    }
}
