package vias;

public class Via {
    private String tiempo;
    private int peajes;
    private double distanciaEnKilometros;
    private String estado;

    public Via(String tiempo, int peajes, double distanciaEnKilometros, String estado)
    {
        this.tiempo = tiempo;
        this.peajes = peajes;
        this.distanciaEnKilometros = distanciaEnKilometros;
        this.estado = estado;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getPeajes() {
        return peajes;
    }

    public void setPeajes(int peajes) {
        this.peajes = peajes;
    }

    public double getDistanciaEnKilometros() {
        return distanciaEnKilometros;
    }

    public void setDistanciaEnKilometros(double distanciaEnKilometros) {
        this.distanciaEnKilometros = distanciaEnKilometros;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
