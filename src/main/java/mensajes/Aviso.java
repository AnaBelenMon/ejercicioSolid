package mensajes;

public class Aviso extends Mensaje{
    private final String destinatario;
    private final String fecha;

    public Aviso(String canal, String titulo, String cuerpo, String destinatario, String fecha) {
        super(canal, titulo, cuerpo);
        this.destinatario = destinatario;
        this.fecha = fecha;
    }

    @Override
    public String texto() {
        return getCabecera() + "Aviso: " + getTitulo() + "\n" +
                "Hola " + destinatario + ",\n" + getCuerpo() + "\n" +
                "Fecha: " + fecha + "\n";
    }

}


