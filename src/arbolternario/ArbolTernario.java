package arbolternario;

import estructuras.List;

public class ArbolTernario {
    private NodoTernario raiz;

    public ArbolTernario() {
    }

    public boolean isEmpty() {
        return estaVacio();
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void agregar(Object dato) {
        if (estaVacio()) {
            raiz = new NodoTernario(dato);
        } else {
            agregar(dato, raiz);
        }
    }

    private void agregar(Object dato, NodoTernario auxiliar) {
        if (auxiliar != null) {
            if ((int) auxiliar.getData() > (int) dato) {
                if (auxiliar.getIzquierda() == null) {
                    auxiliar.setIzquierda(new NodoTernario(dato));
                } else {
                    agregar(dato, auxiliar.getIzquierda());
                }
            } else if ((int) auxiliar.getData() < (int) dato) {
                if (auxiliar.getDerecha() == null) {
                    auxiliar.setDerecha(new NodoTernario(dato));
                } else {
                    agregar(dato, auxiliar.getDerecha());
                }
            } else {
                if (auxiliar.getCentro() == null) {
                    auxiliar.setCentro(new NodoTernario(dato));
                } else {
                    agregar(dato, auxiliar.getCentro());
                }
            }
        }
    }

    public String preOrden() {
        return preOrden(raiz);
    }

    private String preOrden(NodoTernario auxiliar) {
        if (auxiliar != null) {
            return auxiliar.getData() + " " + preOrden(auxiliar.getIzquierda())
                    + preOrden(auxiliar.getCentro()) + preOrden(auxiliar.getDerecha());
        }
        return "";
    }

    public String PreOrder() {
        return preOrden();
    }

    public String enOrden() {
        return enOrden(raiz);
    }

    private String enOrden(NodoTernario auxiliar) {
        if (auxiliar != null) {
            return enOrden(auxiliar.getIzquierda()) + auxiliar.getData() + " "
                    + enOrden(auxiliar.getCentro()) + enOrden(auxiliar.getDerecha());
        }
        return "";
    }

    public String InOrder() {
        return enOrden();
    }

    public String postOrden() {
        return postOrden(raiz);
    }

    private String postOrden(NodoTernario auxiliar) {
        if (auxiliar != null) {
            return postOrden(auxiliar.getIzquierda()) + postOrden(auxiliar.getCentro())
                    + postOrden(auxiliar.getDerecha()) + auxiliar.getData() + " ";
        }
        return "";
    }

    public String PostOrder() {
        return postOrden();
    }

    public int tamanio() {
        return tamanio(raiz);
    }

    private int tamanio(NodoTernario auxiliar) {
        if (auxiliar != null) {
            return 1 + tamanio(auxiliar.getIzquierda()) + tamanio(auxiliar.getCentro())
                    + tamanio(auxiliar.getDerecha());
        }
        return 0;
    }

    public int Size() {
        return tamanio();
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoTernario auxiliar) {
        if (auxiliar != null) {
            int alturaIzquierda = altura(auxiliar.getIzquierda());
            int alturaCentro = altura(auxiliar.getCentro());
            int alturaDerecha = altura(auxiliar.getDerecha());
            return 1 + Math.max(alturaIzquierda, Math.max(alturaCentro, alturaDerecha));
        }
        return 0;
    }

    public int Height() {
        return altura();
    }

    public boolean buscar(int dato) {
        return buscar(raiz, dato);
    }

    public boolean Search(int dato) {
        return buscar(dato);
    }

    private boolean buscar(NodoTernario auxiliar, int dato) {
        if (auxiliar != null) {
            if ((int) auxiliar.getData() == dato) {
                return true;
            }
            return buscar(auxiliar.getIzquierda(), dato)
                    || buscar(auxiliar.getCentro(), dato)
                    || buscar(auxiliar.getDerecha(), dato);
        }
        return false;
    }

    public NodoTernario buscarNodo(int dato) {
        return buscarNodo(dato, raiz);
    }

    public NodoTernario SearchNode(int dato) {
        return buscarNodo(dato);
    }

    private NodoTernario buscarNodo(int dato, NodoTernario auxiliar) {
        if (auxiliar != null) {
            if (dato == (int) auxiliar.getData()) {
                return auxiliar;
            }

            NodoTernario resultado = buscarNodo(dato, auxiliar.getIzquierda());
            if (resultado == null) {
                resultado = buscarNodo(dato, auxiliar.getCentro());
            }
            if (resultado == null) {
                resultado = buscarNodo(dato, auxiliar.getDerecha());
            }
            return resultado;
        }
        return null;
    }

    public NodoTernario obtenerPadre(int dato) {
        return raiz;
    }

    private NodoTernario obtenerPadre(int dato, NodoTernario auxiliar) {
        if (auxiliar != null) {
            if ((auxiliar.getIzquierda() != null
                    && (int) auxiliar.getIzquierda().getData() == dato)
                    || (auxiliar.getCentro() != null
                    && (int) auxiliar.getCentro().getData() == dato)
                    || (auxiliar.getDerecha() != null
                    && (int) auxiliar.getDerecha().getData() == dato)) {
                return auxiliar;
            }

            NodoTernario padre = obtenerPadre(dato, auxiliar.getIzquierda());
            if (padre == null) {
                padre = obtenerPadre(dato, auxiliar.getCentro());
            }
            if (padre == null) {
                padre = obtenerPadre(dato, auxiliar.getDerecha());
            }
            return padre;
        }
        return null;
    }

    public List camino(int dato) {
        NodoTernario encontrado = buscarNodo(dato);
        if (encontrado == null) {
            return null;
        }

        List lista = new List();
        return camino(encontrado, lista);
    }

    public List Path(int dato) {
        return camino(dato);
    }

    private List camino(NodoTernario auxiliar, List lista) {
        if (auxiliar != null) {
            lista.AddFirst(auxiliar.getData());
            return camino(obtenerPadre((int) auxiliar.getData()), lista);
        }
        return lista;
    }

    public List sucesores(int dato) {
        NodoTernario encontrado = buscarNodo(dato);
        List lista = new List();
        if (encontrado != null) {
            sucesores(encontrado.getIzquierda(), lista);
            sucesores(encontrado.getCentro(), lista);
            sucesores(encontrado.getDerecha(), lista);
        }
        return lista;
    }

    public List Success(int dato) {
        return sucesores(dato);
    }

    private void sucesores(NodoTernario auxiliar, List lista) {
        if (auxiliar != null) {
            lista.AddLast(auxiliar.getData());
            sucesores(auxiliar.getIzquierda(), lista);
            sucesores(auxiliar.getCentro(), lista);
            sucesores(auxiliar.getDerecha(), lista);
        }
    }

    public boolean eliminar(int dato) {
        NodoTernario eliminado = buscarNodo(dato);
        if (eliminado != null) {
            int cantidadHijos = contarHijos(eliminado);
            if (cantidadHijos == 0) {
                eliminarSinHijos(eliminado);
            } else if (cantidadHijos == 1) {
                eliminarConUnHijo(eliminado);
            } else {
                eliminarConDosOMasHijos(eliminado);
            }
            return true;
        }
        return false;
    }

    public boolean Delete(int dato) {
        return eliminar(dato);
    }

    private int contarHijos(NodoTernario nodo) {
        int cantidad = 0;
        if (nodo.getIzquierda() != null) {
            cantidad++;
        }
        if (nodo.getCentro() != null) {
            cantidad++;
        }
        if (nodo.getDerecha() != null) {
            cantidad++;
        }
        return cantidad;
    }

    private void eliminarSinHijos(NodoTernario eliminado) {
        NodoTernario padre = obtenerPadre((int) eliminado.getData());
        if (padre == null) {
            raiz = null;
        } else if (eliminado.equals(padre.getIzquierda())) {
            padre.setIzquierda(null);
        } else if (eliminado.equals(padre.getCentro())) {
            padre.setCentro(null);
        } else {
            padre.setDerecha(null);
        }
    }

    private void eliminarConUnHijo(NodoTernario eliminado) {
        NodoTernario hijo = eliminado.getIzquierda();
        if (hijo == null) {
            hijo = eliminado.getCentro();
        }
        if (hijo == null) {
            hijo = eliminado.getDerecha();
        }

        NodoTernario padre = obtenerPadre((int) eliminado.getData());
        if (padre == null) {
            raiz = hijo;
        } else if (eliminado.equals(padre.getIzquierda())) {
            padre.setIzquierda(hijo);
        } else if (eliminado.equals(padre.getCentro())) {
            padre.setCentro(hijo);
        } else {
            padre.setDerecha(hijo);
        }
    }

    public NodoTernario masIzquierda(NodoTernario auxiliar) {
        if (auxiliar != null && auxiliar.getIzquierda() != null) {
            return masIzquierda(auxiliar.getIzquierda());
        }
        return auxiliar;
    }

    public NodoTernario MoreLeft(NodoTernario auxiliar) {
        return masIzquierda(auxiliar);
    }

    private void eliminarConDosOMasHijos(NodoTernario eliminado) {
        NodoTernario reemplazo = masIzquierda(eliminado);
        if (reemplazo == eliminado) {
            reemplazo = eliminado.getCentro();
            if (reemplazo == null) {
                reemplazo = eliminado.getDerecha();
            }
        }
        eliminar((int) reemplazo.getData());
        eliminado.setData(reemplazo.getData());
    }

    public void Delete2(NodoTernario eliminado) {
        if (eliminado != null) {
            eliminarConDosOMasHijos(eliminado);
        }
    }
}
