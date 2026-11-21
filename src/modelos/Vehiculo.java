package modelos;

import estructuras.Stack;

public class Vehiculo {
    private String nombre;
    private int edad;
    private int documento;
    private Stack pilaDePaquetes;

    public Vehiculo(String nombre, int edad, int documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        pilaDePaquetes = new Stack();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public Stack getPilaDePaquetes() {
        return pilaDePaquetes;
    }

    public void setPilaDePaquetes(Stack pilaDePaquetes) {
        this.pilaDePaquetes = pilaDePaquetes;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", documento=" + documento +
                ", pilaDePaquetes=" + pilaDePaquetes +
                '}';
    }
}
