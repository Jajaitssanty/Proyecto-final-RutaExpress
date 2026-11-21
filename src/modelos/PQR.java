package modelos;

import estructuras.List;

public class PQR {
    private int numeroDePeticion;
    private List seguimiento;

    public PQR(int numeroDePeticion) {
        this.numeroDePeticion = numeroDePeticion;
        seguimiento = new List();
    }

    public int getNumeroDePeticion() {
        return numeroDePeticion;
    }

    public void setNumeroDePeticion(int numeroDePeticion) {
        this.numeroDePeticion = numeroDePeticion;
    }

    public List getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(List seguimiento) {
        this.seguimiento = seguimiento;
    }

    @Override
    public String toString() {
        return "PQR{" +
                "numeroDePeticion=" + numeroDePeticion +
                ", seguimiento=" + seguimiento +
                '}';
    }
}
