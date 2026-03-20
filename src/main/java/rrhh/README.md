# Análisis y corrección SOLID — Paquete: rrhh

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**
En este paquete se vulnera el principio DIP -> Dependency Inversion Principle

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- AltaEmpleadoService.java
- El uso de la palabra reservada new en la declaración de los atributos
- RepositorioEmpleadosEnMemoria y GeneradorPasswordSimple.

**Síntomas que lo delatan (marca y explica brevemente):**
- El servicio de alta de empleados está obligado a usar un repositorio en memoria 
- y un generador simple porque él mismo los fabrica con la instrucción new. 
- No puede usar otros aunque quiera.

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
- Difícil de testear.
- No se pueden realizar pruebas unitarias del servicio de alta.
- Si el cliente pide que las contraseñas ahora sigan un estándar de seguridad complejo o se guarden en un archivo XML, 
- el programador debe abrir y modificar una clase de lógica de negocio que ya funcionaba.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
- Eliminaría los new de AltaEmpleadoService y los haría atributos para poder pedir los parametros 
- en el constructor
- Crearía la interfaz GenerarPassword
- Crearía la interfaz RepositorioEmpleados
