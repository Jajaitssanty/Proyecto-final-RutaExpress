# Estructura actual del proyecto

```text
src/
  app/
    Main
  modelos/
    Cliente
    Paquete
    Vehiculo
    PQR
  sedes/
    Sede
  vias/
    Via
  estructuras/
    List
    Node
    Queue
    Stack
    DoubleList
    DoubleNode
  grafo/
    Graph
    Vertex
  arbolbinario/
    BinaryTree
    BinaryNode
  arbolternario/
    ArbolTernario
    NodoTernario

Main
  |
  +--> List
          |
          +--> Node --> Object data
          +--> Node --> siguiente (link)
          |
          `--> metodos: agregar, recorrer, buscar, eliminar y mostrar

Sede
  |--> nombre
  |--> tipoDeSede
  `--> Queue paquetesParaDespachar
           |
           `--> Node first --> Node last

Cliente
  |--> datos personales
  `--> List guiaDePedidos

Paquete
  |--> numeroDeGuia
  `--> List historialDeRastreo

PQR
  |--> numeroDePeticion
  `--> List seguimiento

Vehiculo
  |--> nombre, edad y documento
  `--> Stack pilaDePaquetes

Grafo
  |
  +--> List vertexs
          |
          `--> Vertex
                 |--> data
                 `--> List adjacency
                        |
                        `--> Vertex vecinos

Via
  |--> tiempo
  |--> peajes
  |--> distanciaEnKilometros
  `--> estado

BinaryTree
  `--> BinaryNode
         |--> left
         |--> data
         `--> right

ArbolTernario
  `--> NodoTernario
         |--> izquierda
         |--> data
         |--> centro
         `--> derecha

DoubleList
  `--> DoubleNode
         |--> previous
         |--> data
         `--> next
```

## Estado actual

- `src/Main.java` muestra un menu con ventanas y permite crear sedes en una lista simple.
- `List`, `DoubleList`, `Queue`, `Stack`, `Graph`, `BinaryTree` y `ArbolTernario` son estructuras implementadas manualmente.
- `Sede`, `Cliente`, `Paquete`, `Vehiculo` y `PQR` contienen estructuras internas relacionadas con la operacion.
- `Via` representa la informacion de una conexion o carretera.
- `bin/` contiene las clases compiladas.
- `.vscode/settings.json` indica que el codigo fuente esta en `src/` y las clases compiladas deben salir a `bin/`.

## Conexiones que faltan completar

- R1-R3: cliente, guias e indice por prefijo.
- R4-R8: paquete, cola de sede, rastreo, estadisticas y bodega.
- R9-R13: vehiculo, conductor, flota doble, carga, despacho y entregas.
- R14-R18: carga inicial, vias, estados, red y rutas.
- R19-R20: PQR, seguimiento y cola de atencion.
- R21: informe de operacion y archivo textual.
