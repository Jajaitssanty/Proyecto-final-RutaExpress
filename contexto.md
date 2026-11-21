# Contexto del proyecto

## Objetivo

RutaExpress necesita un sistema de consola o interfaz grafica para administrar sedes, vias, clientes, paquetes, vehiculos y PQR en el departamento de Antioquia.

El sistema debe permitir que la operacion continúe aunque un correo electronico no pueda enviarse. Un error de correo debe mostrarse al usuario y quedar registrado.

## Reglas del proyecto

- Los estudiantes deben implementar las estructuras de datos manualmente.
- No se pueden usar `java.util` ni estructuras de Java como `ArrayList`, `LinkedList`, `HashMap`, `Stack`, `Queue` o `TreeMap` sin aprobacion previa.
- El desarrollo se hará requerimiento por requerimiento. No se busca optimizar el número de cambios ni avanzar por bloques enormes.
- Cada cambio debe hacerse de forma clara y fácil de explicar.
- Los datos de correo deben leerse desde un archivo de configuracion y no escribirse dentro del codigo Java.
- La red inicial debe cargarse desde un archivo de texto.
- El informe de la operacion debe guardarse en un archivo de texto.
- Los cambios deben ser faciles de explicar por el estudiante y mantener una logica similar a `src/List.java`.
- Se trabaja con Java y una interfaz basada en `JOptionPane`, segun el estado actual.

## Estructuras necesarias

- Grafo ponderado para sedes y vias.
- Cola propia dentro de cada sede para los paquetes pendientes.
- Lista simple propia para clientes.
- Lista simple dentro de cada cliente para sus guias.
- Arbol ternario para buscar nombres de clientes por las primeras letras.
- Arbol binario de busqueda propio para paquetes ordenados por numero de guia.
- Lista simple dentro de cada paquete para el historial de rastreo.
- Lista doblemente enlazada propia y ordenada por placa para la flota.
- Pila propia dentro de cada vehiculo para los paquetes cargados.
- Cola propia para atender PQR en orden de llegada.
- Lista propia dentro de cada PQR para las anotaciones de seguimiento.

## Clases principales actuales

- `src/app/Main.java`: punto de inicio y primer menu grafico.
- `src/estructuras/List.java` y `src/estructuras/Node.java`: lista simple y nodo enlazado.
- `src/estructuras/DoubleList.java` y `src/estructuras/DoubleNode.java`: lista doblemente enlazada.
- `src/estructuras/Queue.java`: cola FIFO implementada manualmente.
- `src/estructuras/Stack.java`: pila LIFO implementada manualmente.
- `src/grafo/Graph.java` y `src/grafo/Vertex.java`: grafo y vertices.
- `src/vias/Via.java`: datos de una via.
- `src/sedes/Sede.java`: datos de sede y cola de paquetes.
- `src/modelos/Cliente.java`: datos del cliente y lista de guias.
- `src/modelos/Paquete.java`: guia e historial de rastreo.
- `src/modelos/Vehiculo.java`: datos del conductor y pila de paquetes.
- `src/modelos/PQR.java`: peticion y lista de seguimiento.
- `src/arbolbinario/BinaryTree.java` y `src/arbolbinario/BinaryNode.java`: arbol binario de busqueda.
- `src/arbolternario/ArbolTernario.java` y `src/arbolternario/NodoTernario.java`: arbol ternario.

## Estado de implementacion

Existe una base manual de estructuras y modelos. `Main` ya permite crear sedes y mostrarlas en una ventana de dialogo.

La implementacion pendiente se divide en 21 requerimientos funcionales:

- R1-R3: registro, busqueda por prefijo e historial de clientes.
- R4-R8: admision, rastreo, listado, estadisticas y ocupacion de paquetes.
- R9-R13: flota, carga, despacho y entregas.
- R14-R18: carga de la red, sedes, vias, estados y rutas.
- R19-R20: radicacion y atencion FIFO de PQR.
- R21: informe de operacion e ingresos por sede y tipo de servicio.

La entrega exige tambien:

- proyecto completo sustentado funcionando;
- codigo fuente con cada estructura propia en su propia clase;
- `red.txt` con minimo 12 sedes y 18 vias entre municipios reales de Antioquia;
- diagrama de clases que muestre estructuras contenidas en sus nodos;
- sustentacion con envio de correos reales.

## Reglas clave detectadas

- El grafo debe conservar el objeto completo de cada sede en sus vertices.
- Los vertices se comunican con las vias y usan solo vias habilitadas para calcular rutas.
- Un paquete admitido debe ser el mismo objeto en el arbol de paquetes y en la cola de despacho.
- El arbol ternario debe guardar nombres de clientes y permitir busqueda por prefijo en orden alfabetico.
- El arbol binario debe usar el numero de guia como clave de 9 digitos.
- La lista doble de vehiculos debe recorrer hacia adelante y hacia atras y ordenarse por placa.
- La pila de paquetes de un vehiculo debe usar el ultimo cargado como primero bajado.
- La cola de PQR atiende la mas antigua y devuelve al final las PQR que no se cierran.

## Costos y configuracion

- Tarifa base estandar: $8.000.
- Tarifa base express: $15.000.
- Tarifa base contra entrega: $10.000 mas el 2 % del valor declarado.
- Recargo fragil: 10 % del subtotal.
- Precio inicial del galon: $15.800.
- Plazo estandar: 3 dias.
- Plazo express: 1 dia.
- Peso volumetrico: largo x ancho x alto / 5000.
- Peso facturable: mayor entre peso real y peso volumetrico.
- Contra entrega conserva el costo base de $10.000 y agrega el 2 % del valor declarado.
- Costo combustible: kilometros de ruta / rendimiento del vehiculo x precio del galon.

## Archivos requeridos

- `red.txt`: red inicial y sedes/vias.
- Archivo de configuracion de correo: cuenta, servidor y contrasena fuera del codigo fuente.
- `informe_AAAA-MM-DD.txt`: informe generado por R21.
- Si existe un archivo no encontrado al iniciar, debe informarse al usuario y permitirse la carga posterior.

## Decisiones pendientes

No se han definido por el enunciado:

- nombre final de los campos adicionales de interfaz;
- formato exacto de persistencia de clientes, paquetes y PQR aparte de `red.txt`;
- proveedor SMTP y puerto que usara el equipo;
- capacidad fija de las sedes de la red inicial;
- asignacion inicial de vehiculos y conductores.
