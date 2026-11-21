package grafo;

import estructuras.List;

public class Vertex {
    private Object data;
    private List adjacency;

    public Vertex(Object data) {
        this.data = data;
        adjacency = new List();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List getAdjacency() {
        return adjacency;
    }

    public void setAdjacency(List adjacency) {
        this.adjacency = adjacency;
    }
}
