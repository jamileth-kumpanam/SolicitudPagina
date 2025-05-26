# Proyecto de Gestión de Compras

## 📌 Información General

•⁠  ⁠*Título:* Interfaz de Gestión de compras
•⁠  ⁠*Asignatura:* Programación Orientada a Ojetos
•⁠  ⁠*Carrera:* Computación
•⁠  ⁠*Estudiante:* [Kelly Valeria Guaman Leon, Jamileth Estefanía Kumpanam Segarra]
•⁠  ⁠*Fecha:* [26/05/2025]
•⁠  ⁠*Profesor:* Ing. Gabriel León

---

## 🛠️ Descripción

Este proyecto consiste en el desarrollo de un módulo de compras automatizado para un sistema
ERP implementado en Java utilizando programación orientada a objetos. Su objetivo principal
es reemplazar procesos manuales de adquisición mediante la automatización del registro de proveedores,
productos y solicitudes de compra, el control de estados de aprobación/rechazo de solicitudes, 
y el cálculo automático de costos. El sistema aplica principios fundamentales de POO como herencia
(con una estructura jerárquica Persona → Empleado/Proveedor), polimorfismo (mediante interfaces como
Calculable y Estadoable), y encapsulamiento (atributos privados con métodos públicos de acceso). 
La arquitectura se basa en clases claramente definidas como Producto, SolicitudCompra y Departamento,
complementadas con enumeraciones como UnidadMedida y EstadoSolicitud. El módulo ofrece funcionalidades clave
a través de un menú interactivo que permite registrar y buscar elementos, aprobar o rechazar solicitudes, 
y calcular totales, creando así una solución integral para la gestión del ciclo completo de compras 
empresariales de forma eficiente y estructurada.

## 🧑‍💻 Ejemplo de Entrada

== SISTEMA DE GESTIÓN DE COMPRAS ERP ==
1. Registrar proveedor
2. Registrar producto
3. Registrar solicitud de compra
4. Listar proveedores
5. Listar productos
6. Listar solicitudes de compra
7. Buscar proveedor por ID
8. Buscar producto por nombre
9. Buscar solicitud por número
10. Aprobar / Rechazar solicitud de compra
11. Calcular total de una solicitud

Estructurar el código en capas lógicas (modelo, vista y controlador) para mejorar su mantenibilidad.
Adaptar las operaciones principales del sistema a una interfaz gráfica amigable
Se diseñó un menú principal funcional con navegación fluida entre vistas.
