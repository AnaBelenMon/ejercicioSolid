package mensajes;

public abstract class Mensaje {


    private final String canal;

    private final String titulo;
    private final String cuerpo;


    public Mensaje(String canal, String titulo, String cuerpo) {
        this.canal = canal;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    protected String getCabecera() {
        return "[" + canal.toUpperCase() + "] ";
    }


    public abstract String texto();

    public String getCanal() { return canal; }
    public String getTitulo() { return titulo; }
    public String getCuerpo() { return cuerpo; }


}
