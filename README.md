# Proyecto-final-RutaExpress
Este repo es creado con el fin de realizar el proyecto de curso correspondiente a la materia estructura de datos semestre 2026-2 de la institucion universitaria de Envigado.

Reglas para los asistentes de codigo

1. El objetivo final de este proyecto es que sea explicado muy minuciosamente por mi y sin ninguna ayuda externa. Asi que si se va a agregar algun cambio como una funcion o algo, lo debo de entender; osea que este escrito de tal manera que yo lo pueda entender. Para que te hagas una idea de como es mi logica, puedes basarte en la clase List.java para que sepas como es mi logica.

2. No importar librerias como java.util, ni ninguna estructura para hacer mas corto el codigo sin mi previa aprobacion.

3. Este es el caso que debo de resolver "RutaExpress es una empresa antioqueña de mensajería y paquetería que opera desde una sede principal en Medellín y una red de sedes satélite en municipios como Envigado, Rionegro, Santa Fe de Antioquia, Caucasia, Apartadó, Turbo, La Ceja, Marinilla, Puerto Berrío y Yarumal. Cada día recibe cientos de paquetes de personas y empresas que deben llegar a otros municipios del departamento por carreteras que, con frecuencia, se cierran por derrumbes o trabajos en la vía.
Hoy la empresa lleva el control en hojas de cálculo y cuadernos. Esto provoca paquetes extraviados, vehículos que salen con poca carga o con sobrepeso, rutas que no son las más cortas y clientes que nunca se enteran de dónde está su envío. Por eso la gerencia contrata al equipo de estudiantes para construir en Java un sistema que administre la red de sedes, los clientes, los paquetes, la flota de vehículos y las peticiones, quejas y reclamos (PQR).
El sistema debe funcionar por consola o con interfaz gráfica, leer la red inicial desde un archivo de texto y notificar por correo electrónico a clientes, destinatarios, conductores y coordinadores de sede cuando ocurran los eventos importantes de la operación.
Para organizar la operación, el sistema guarda la información en estructuras de datos propias, varias de ellas dentro de otras. La red de sedes y vías es un grafo ponderado: cada vía tiene distancia, tiempo, peajes y estado, y cada sede guarda en su nodo una cola con los paquetes que esperan despacho. Los clientes se registran en una lista simple, y cada uno lleva dentro una lista con las guías de sus envíos. Sus nombres también se guardan en un árbol ternario para buscarlos por las primeras letras. Todos los paquetes están en un árbol binario de búsqueda ordenado por número de guía, y cada paquete tiene en su nodo una lista simple con su historial de rastreo. La flota de vehículos es una lista doblemente enlazada ordenada por placa; cada vehículo guarda los datos de su conductor y una pila con los paquetes cargados, de modo que el último en subir es el primero en bajar. Las peticiones, quejas y reclamos se atienden desde una cola en orden de llegada, y cada una lleva una lista con sus anotaciones de seguimiento. La red inicial se carga desde un archivo de texto, el informe de la operación se guarda en un archivo de texto y el sistema envía correos cuando ocurren los eventos importantes.
Todas las estructuras deben ser implementadas por los estudiantes; no se permite usar las colecciones de Java (ArrayList, LinkedList, HashMap, Stack, Queue, TreeMap y similares).
El programa Java envía los correos por sí mismo, desde una cuenta creada por el equipo para el proyecto, sin abrir un cliente de correo externo. Los datos de la cuenta se leen de un archivo de texto de configuración y nunca se escriben dentro del código fuente. Si un correo no se puede enviar, la operación del sistema no se detiene: se informa el error al usuario y la operación queda registrada"

4. Cabe resaltar que el codigo exige 21 requerimientos, dentro de los cuales debo de enviar correos sin ningun motor de correos, leer y registrar informacion en archivos .txt. Si crees quee la mejor manera de resolver un problema es que te comparta la pregunta o informacion de la pregunta, me la pides directamente.

5. . Requerimientos funcionales
El sistema debe ofrecer las siguientes funcionalidades.
Clientes
R1. Registrar clientes. De cada uno de los clientes se registra documento, tipo de cliente, nombre, teléfono, correo, dirección, municipio, fecha de registro y las guías (lista simple de textos). En esta funcionalidad, se registra un cliente validando que su documento no exista; su nombre queda disponible para la búsqueda por prefijo y se le envía un correo de bienvenida.
R2. Buscar clientes por las primeras letras del nombre. Al escribir el inicio de un nombre, por ejemplo «mar», el sistema lista todos los clientes cuyo nombre empieza así, en orden alfabético. Para optimizar la búsqueda, lleve la información del cliente a un árbol ternario de búsqueda.
R3. Consultar el historial de un cliente. Se muestran los datos del cliente, todos sus envíos con su estado y el total que ha pagado a la empresa.
Paquetes
R4. Admitir un paquete. De los paquetes se desea tener la siguiente información: número de guía, documento del remitente, nombre del destinatario, teléfono del destinatario, correo del destinatario, dirección de entrega, sede de origen, sede de destino, peso en kilogramos, largo, ancho y alto en centímetros, valor declarado, tipo de servicio, frágil, fecha de admisión, estado, costo de envío e historial. El número de guía es un número de 9 dígitos generado al azar, sin repetirse. Cada evento del historial registra fecha y hora, código de la sede, descripción y responsable.
Cuando la empresa recibe un envío, el sistema genera su número de guía, calcula el costo y guarda el paquete en varias estructuras a la vez. Primero lo inserta en el árbol binario de búsqueda de paquetes, ordenado por número de guía. Después lo agrega al final de la cola de despacho de la sede de origen, que es un vértice del grafo, para que salga en orden de llegada. Además, anota el número de guía en la lista simple de guías del cliente remitente, que está dentro de su nodo en la lista de clientes. Por último, abre el historial de rastreo del paquete, una lista simple dentro de su propio nodo, con el evento «admitido en sede». El paquete es un solo objeto: el árbol y la cola apuntan a la misma instancia, no a copias. Si el remitente no existe o si las sedes de origen y destino no están unidas por vías habilitadas, el paquete no queda guardado en ninguna estructura. Si la bodega de origen no tiene capacidad, el paquete se rechaza, no queda guardado en ninguna estructura y se envía una alerta por correo al coordinador de la sede. Cuando el registro se completa, el remitente recibe por correo la guía, el costo detallado y la fecha máxima de entrega.
El costo de cada envío se calcula con el peso facturable, la distancia de la ruta más corta habilitada entre la sede de origen y la de destino, el seguro y los recargos.
pesoVolumétrico = (largo × ancho × alto) / 5000
El peso facturable es el mayor entre el peso real y el peso volumétrico.
costo = (tarifaBase + 1500 × pesoFacturable + 120 × distanciaKm + 0,01 × valorDeclarado) × (1 + recargoFrágil)
Concepto	Valor
Tarifa base estándar	$8.000
Tarifa base express	$15.000
Tarifa base contra entrega	$10.000 más el 2 % del valor declarado
Recargo por paquete frágil	10 % del subtotal
Precio del galón de combustible	$15.800 (debe poder modificarse)
Plazo de entrega estándar	3 días desde la admisión
Plazo de entrega express	1 día desde la admisión

Además, un paquete solo se admite si existe al menos un camino con vías habilitadas entre su sede de origen y su sede de destino. Las vías cerradas no se usan para calcular rutas ni costos.
R5. Rastrear un paquete. Con el número de guía se muestran los datos del paquete y todos sus eventos de rastreo en orden cronológico. Un paquete que supera su plazo de entrega sin estar entregado se considera vencido.
R6. Listar los paquetes ordenados por guía. Se muestran todos los paquetes de menor a mayor número de guía, con la opción de filtrar por estado.
R7. Mostrar estadísticas del árbol de paquetes. Se informa la cantidad de paquetes, la altura del árbol, la guía menor, la guía mayor y la cantidad de hojas.
R8. Ver la bodega de una sede. Se muestran los paquetes en espera de una sede en su orden de salida, el peso total almacenado, el porcentaje de ocupación de la bodega y una alerta si supera el 80 %.
Flota
R9. Registrar vehículos. De cada vehículo se registra placa, tipo de vehículo (moto, furgón o camión), capacidad en kilogramos, capacidad en metros cúbicos, rendimiento en kilómetros por galón, sede base, estado (disponible, en ruta o en mantenimiento), kilómetros recorridos y la carga (pila de paquetes). Del conductor se registra cédula, nombre, celular, correo y categoría de licencia. Se agrega un vehículo con su conductor, manteniendo la flota ordenada por placa y sin placas repetidas.
R10. Recorrer la flota. El usuario navega vehículo por vehículo hacia adelante y hacia atrás, y puede filtrar por sede base o por estado.
R11. Cargar un vehículo. Se toman paquetes de la bodega de la sede base del vehículo cuyo destino quede sobre una misma ruta, respetando capacidades, restricciones de motos y el orden de carga. Los paquetes que no caben permanecen en la cola en su posición original. Un vehículo no puede cargar más peso ni más volumen del que permite su capacidad, y solo se cargan vehículos disponibles. Una moto solo lleva paquetes de hasta 10 kg que no sean frágiles. Los paquetes se cargan en el orden inverso a como se van a entregar, de modo que el primero que se baja sea el de la primera sede de la ruta.
R12. Despachar un vehículo. El vehículo pasa a estado en ruta, cada paquete registra un evento, el conductor recibe por correo la hoja de ruta (sedes, distancias, paquetes y costo estimado de combustible) y cada destinatario recibe un correo avisando que su paquete va en camino. El costo del combustible se obtiene dividiendo los kilómetros de la ruta entre el rendimiento del vehículo y multiplicando el resultado por el precio del galón.
R13. Registrar entregas. Al llegar a cada sede de la ruta se bajan los paquetes que van para ella; si un paquete pedido no está en el tope, el sistema informa cuántos paquetes hay que bajar y volver a subir. Cada entrega actualiza el estado, el historial y envía un correo de confirmación al remitente y al destinatario. Un paquete que no se pudo entregar se marca como devuelto y regresa a la cola de su sede de origen, siempre que la bodega tenga capacidad; si no la tiene, se envía una alerta al coordinador de esa sede.
Red de sedes
R14. Cargar la red inicial. Al iniciar por primera vez, el sistema lee el archivo de sedes y vías (red.txt) y construye la red completa de la empresa. El archivo tiene dos bloques separados por una línea con la palabra VIAS. El primero trae una sede por línea y el segundo una vía por línea, con los campos separados por punto y coma, en el mismo orden de los atributos de R15. Por ejemplo:
SEDES
MED01; RutaExpress Medellín; Medellín; Cra 52 # 14-30; PRINCIPAL; 5000; 6044441234; coo rd.med@rutaexpress.co
ENV01; RutaExpress Envigado; Envigado; Cl 38 Sur # 43-20; SATELITE; 1200; 6043332211; coord.env@rutaexpress.co
RIO01; RutaExpress Rionegro; Rionegro; Cl 49 # 50-12; SATELITE; 1500; 6045312200; coord.rio@rutaexpress.co

VIAS
MED01; ENV01; 12.5; 30; 0; PAVIMENTADA; HABILITADA
MED01; RIO01; 45.0; 60; 13800; PAVIMENTADA; HABILITADA
R15. Registrar sedes y vías. De cada sede se registra código, nombre, municipio, dirección, tipo (principal o satélite), capacidad de bodega en kilogramos, teléfono, correo del coordinador y la cola de despacho. De cada vía se registra sede de origen, sede de destino, distancia en kilómetros, tiempo en minutos, valor de los peajes, tipo de vía (pavimentada o destapada) y estado (habilitada o cerrada). El usuario puede agregar una sede nueva o una vía entre dos sedes existentes, sin permitir códigos repetidos ni vías duplicadas.
R16. Cambiar el estado de una vía. Cuando una carretera se cierra o se reabre, el usuario actualiza su estado; el sistema informa qué sedes quedan aisladas del resto de la red y envía un correo de alerta a los coordinadores de esas sedes.
R17. Mostrar la red. Se muestran todas las sedes con sus vecinas directas, la distancia, el tiempo, los peajes y el estado de cada vía.
R18. Consultar la mejor ruta. Dadas dos sedes, el sistema muestra la ruta más corta en kilómetros usando solo vías habilitadas, con la secuencia de sedes, la distancia total, el tiempo total y el valor total de peajes.
PQR
R19. Radicar una PQR. De cada PQR se registra radicado, documento del cliente, número de guía relacionado (puede quedar vacío en una sugerencia), tipo (petición, queja, reclamo o sugerencia), descripción, fecha de radicación, estado (abierta, en trámite o cerrada) y los seguimientos (lista simple). Se registra la PQR de un cliente existente y se le envía un correo con el número de radicado.
R20. Atender PQR. Se atiende la PQR más antigua: el funcionario agrega anotaciones de seguimiento y, al cerrarla, el cliente recibe un correo con la respuesta y todo el historial del trámite. De cada seguimiento se registra fecha y hora, funcionario y anotación. Una PQR que no se cierra vuelve al final de la cola.
Reportes
R21. Generar el informe de la operación. El informe incluye: ingresos por sede y por tipo de servicio, paquete más pesado, peso promedio por paquete, cliente con más envíos, vehículo con más kilómetros, paquetes vencidos y cantidad de PQR abiertas por tipo. El informe se muestra en pantalla y se guarda en un archivo de texto con el nombre informe_AAAA-MM-DD.txt.

6. Soy la unica persona trabajando en el proyecto.

7. En un archivo llamado contexto.md vas a anotar toda la informacion que creas util para la realizacion del proyecto.

8. Condiciones de entrega
    1.	El equipo entrega el proyecto completo y lo sustenta funcionando ante el docente.
    2.	El código fuente en Java, con cada estructura de datos implementada en su propia clase.
    3.	El archivo red.txt con mínimo 12 sedes y 18 vías que correspondan a municipios reales de Antioquia.
    4.	Diagrama de clases que muestre qué estructura está contenida en el nodo de cuál.
    5.	Sustentación en vivo en la que se envíen correos reales y cada integrante explique al menos una estructura.

9. Vamos a ir requerimiento a requerimiento, no busco eficiencia, sino aprender y mucho mas ahora que estoy aprendiendo a implementar los archivos .md.