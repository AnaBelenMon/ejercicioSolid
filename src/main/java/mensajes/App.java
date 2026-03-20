package mensajes;

public class App {

    public static void main(String[] args) {
        GeneradorTextoMensajes generador = new GeneradorTextoMensajes();

        Mensaje aviso = new Aviso(

                "intranet",
                "Grupo SMR1",
                "Cambio de aula",
                "Hoy la clase será en el aula 2.3 por mantenimiento.",
                "2026-02-26"

        );

        Mensaje incidencia = new Incidencia(
                "correo",
                "Retraso reiterado",
                "Se han detectado 3 retrasos esta semana.",
                "12345678A",
                "DAM1",
                "ALTA"
        );

        System.out.println(generador.generar(aviso));
        System.out.println(generador.generar(incidencia));
    }
}
