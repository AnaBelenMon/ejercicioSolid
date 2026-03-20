# Análisis y corrección SOLID — Paquete: biblioteca

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**  
LSP:Liskov Substitution Priciple

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
Las clases en las que se concentra el problema son estas:
- LibroReferencia
- PrestamoService
- Herencia entre Libro y LibroReferencia

**Síntomas que lo delatan (marca y explica brevemente):**
1. LibroReferencia hereda de Libro aunque no debería poder prestarse ya que un libro de referencia no es un libro prestable, pero la herencia obliga a tratarlo como tal.
2. Se sobreescribe incorrectamente el método prestarA() en la clase LibroReferencia ya que finge un préstamo que realmente no debería existir.
3. PrestamoService cree que todos los Libro pueden prestarse. Esto provoca comportamientos incoherentes cuando recibe un LibroReferencia.


## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
- Comportamiento inesperado y engañoso: un libro de referencia aparece como "prestado", aunque no debería prestarse nunca.
- Fragilidad del sistema: PrestamoService no distingue entre los objetos que se pueden prestar y no se pueden prestar, lo que puede generar errores.
- Violación conceptual: la herencia fuerza a LibroReferencia a tener métodos que no debería tener.
- Mayor riesgo de errores futuros: cualquier cambio de lógica de préstamo afectaría también a LibroReferencia, aunque no debería.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
- Se crea una interfaz Prestable que define el comportamiento de préstamo (prestarA, devolver, estaPrestado). Solo los unicos objetos que realmente pueden prestarse deben implementarla.
- La clase Libro implementa Prestable, ya que los libros sí pueden prestarse.
- La clase LibroReferencia deja de heredar de Libro y pasa a ser independiente, sin métodos de préstamo. De esta forma, ya no se ve obligada a comportarse como un libro prestable.
- La clase PrestamoService se modifica para aceptar únicamente objetos prestables, evitando que materiales no prestables puedan ser prestados por error.
- La clase BibliotecaApp se actualiza para reflejar el nuevo diseño: se presta solo los libros normales y se informa de que el libro de referencia no puede prestarse.

