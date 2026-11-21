package arbolternario;

public class NodoTernario {
   private NodoTernario izquierda;
   private Object data;
   private NodoTernario centro;
   private NodoTernario derecha;

    public NodoTernario(Object data) {
        this.data = data;
    }

    public NodoTernario getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoTernario izquierda) {
        this.izquierda = izquierda;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public NodoTernario getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoTernario derecha) {
        this.derecha = derecha;
    }

    public NodoTernario getCentro() {
        return centro;
    }
   
    public void setCentro(NodoTernario centro) {
        this.centro = centro;
    }
}
