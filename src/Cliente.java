public class Cliente {
    private int documento;
    private String tipoDeCliente;
    private String nombre;
    private int telefono;
    private int correo;
    private String direccion;
    private String fechaDeRegistro;
    private List guiaDePedidos;

    public Cliente(int documento, String tipoDeCliente, String nombre, int telefono, int correo,
                   String direccion, String fechaDeRegistro) {
        this.documento = documento;
        this.tipoDeCliente = tipoDeCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaDeRegistro = fechaDeRegistro;
        guiaDePedidos = new List();
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(String tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCorreo() {
        return correo;
    }

    public void setCorreo(int correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public List getGuiaDePedidos() {
        return guiaDePedidos;
    }

    public void setGuiaDePedidos(List guiaDePedidos) {
        this.guiaDePedidos = guiaDePedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento=" + documento +
                ", tipoDeCliente='" + tipoDeCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", correo=" + correo +
                ", direccion='" + direccion + '\'' +
                ", fechaDeRegistro='" + fechaDeRegistro + '\'' +
                ", guiaDePedidos=" + guiaDePedidos +
                '}';
    }
}
