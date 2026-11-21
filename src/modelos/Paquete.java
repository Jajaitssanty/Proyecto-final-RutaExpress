package modelos;

import estructuras.List;

public class Paquete {
    private String numeroDeGuia;
    private List historialDeRastreo;

    public Paquete(String numeroDeGuia) {
        this.numeroDeGuia = numeroDeGuia;
    }

    public String getNumeroDeGuia() {
        return numeroDeGuia;
    }

    public void setNumeroDeGuia(String numeroDeGuia) {
        this.numeroDeGuia = numeroDeGuia;
    }

    public List getHistorialDeRastreo() {
        return historialDeRastreo;
    }

    public void setHistorialDeRastreo(List historialDeRastreo) {
        this.historialDeRastreo = historialDeRastreo;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "numeroDeGuia='" + numeroDeGuia + '\'' +
                ", historialDeRastreo=" + historialDeRastreo +
                '}';
    }
}
