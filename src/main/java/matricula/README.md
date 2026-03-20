# Análisis y corrección SOLID — Paquete: matricula

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**
SRP - Single Responsibility Principle(Responsabilidad Única)

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:** 
- La clase en la que se concentra el problema es MatriculaService.

Ya que MatriculaService viola SRP porque:
- Si cambia la validación → hay que tocar la clase
- Si cambia el cálculo → hay que tocar la clase
- Si cambia la forma de guardar → hay que tocar la clase
- Si cambia la notificación → hay que tocar la clase
- Si cambia el formato del resumen → hay que tocar la clase
 Y justo eso es exactamente lo que SRP quiere evitar.
***
**Síntomas que lo delatan (marca y explica brevemente):**
1. Validación: private void validarDni(String dni)
2. Cálculo del precio: private double calcularPrecio(double precioBase, boolean bonificacion)
3. Persistencia en memoria:
   private final List<Matricula> matriculas = new ArrayList<>();
matriculas.add(m);
4. Notificación por consola: System.out.println("[AVISO] Matriculado " + dni + "...");
5. Exportación/formateo: public String exportarResumen() {
resultado += m.getDni() + " | " ... 
}

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
- Es más difícil de mantener, ya que cualquier cambio afecta a una clase enorme y frágil.
- Es más difícil de probar, ya que no puedes probar el cálculo sin que valide el DNi, imprima por consola, añada a la lista y genere un resumen.
- El servicio depende de detalles concretos como la consola, la estructura interna de almacenamiento y el formato del resumen.
- Tiene poca extensidad, ya que si el día de mañana quieres guardar en una base de datos, enviar un email en vez de consola, exportar a JSON o incluso cambiar la regla de bonificación se tendria que modificar la clase.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**

Se separa:

1. La validación:

public class ValidadorDni {

public void validar(String dni) { ... }

}
***
2. El cálculo del precio:

public class CalculadoraPrecioMatricula {

public double calcular(double base, boolean bonificacion) { ... }

}
***
Y se combierten en interfaz:

1. La persistencia:

public interface RepositorioMatriculas {

void guardar(Matricula m);

List<Matricula> obtenerTodas();

}
***
2. La notificación:

public interface Notificador {

void notificar(String mensaje);

}
***
3. La exportación del resumen:

public interface ExportadorMatricula {

String exportar(List<Matricula> matriculas);

}
***
Y se implementa:

public class RepositorioMatriculasEnMemoria implements RepositorioMatriculas { ... }

public class NotificadorConsola implements Notificador { ... }

public class ExportadorMatriculaTexto implements ExportadorMatricula { ... }
