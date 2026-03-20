# Análisis y corrección SOLID — Paquete: mensajes

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**
En este paquete se vulnera el principio OCP -> Open/Closed Principle

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- Clase GeneradorTextoMensajes.java
- Se encuentra el problema en el método generar() 

**Síntomas que lo delatan (marca y explica brevemente):**
- Un gran bloque con varios condicionales if
- Atributos como alumno o gravedad solo tienen sentido si el tipo es INCIDENCIA

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, 
errores fáciles de introducir si el proyecto crece...:**
- Si se quiere enviar otro tipo de mensaje habría que añadir otro tipo al Enum, 
- ir al GeneradorTextoMensajes y añadir otro if, modificando mucho código que ya funciona

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
- Hacer de Mensaje una clase abstracta
- Crear subclases Aviso, Incidencia y Felicitacion, para que cada una implemente su propia
- lógica. Así si queremos un mensaje nuevo solamente tendremos que crear una clase para ello.
