public class Sede {
    private String nombre;
    private String tipoDeSede;
    private List paquetesParaDespachar;

    public Sede(String nombre, String tipoDeSede) {
        this.nombre = nombre;
        this.tipoDeSede = tipoDeSede;
        paquetesParaDespachar = new List();
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

    public List getPaquetesParaDespachar() {
        return paquetesParaDespachar;
    }

    public void setPaquetesParaDespachar(List paquetesParaDespachar) {
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
