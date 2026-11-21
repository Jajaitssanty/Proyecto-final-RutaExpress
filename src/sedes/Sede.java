package sedes;

import estructuras.Queue;

public class Sede {
    private String nombre;
    private String tipoDeSede;
    private Queue paquetesParaDespachar;

    public Sede(String nombre, String tipoDeSede) {
        this.nombre = nombre;
        this.tipoDeSede = tipoDeSede;
        paquetesParaDespachar = new Queue();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeSede() {
        return tipoDeSede;
    }

    public void setTipoDeSede(String tipoDeSede) {
        this.tipoDeSede = tipoDeSede;
    }

    public Queue getPaquetesParaDespachar() {
        return paquetesParaDespachar;
    }

    public void setPaquetesParaDespachar(Queue paquetesParaDespachar) {
        this.paquetesParaDespachar = paquetesParaDespachar;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "nombre='" + nombre + '\'' +
                ", tipoDeSede='" + tipoDeSede + '\'' +
                ", paquetesParaDespachar=" + paquetesParaDespachar +
                '}';
    }
}
