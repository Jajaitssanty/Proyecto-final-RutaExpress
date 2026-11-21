package grafo;

import estructuras.List;
import estructuras.Node;

public class Graph {
    private List vertexs;

    public Graph() {
        vertexs = new List();
    }
    
    public boolean isEmpty()
    {
        return vertexs.isEmpty();
    }
    
    public boolean AddVertex(Object obj)
    {
        Vertex v = vertexs.SearchV(obj);
        if(v==null)
        {
            vertexs.AddLast(new Vertex(obj));
            return true;
        }
        return false;
    }
    
    public boolean AddEdge(Object source, Object target)
    {
        Vertex vs = vertexs.SearchV(source);
        Vertex vt = vertexs.SearchV(target);
        if(vs!=null && vt!=null)
        {
            if(vs.getAdjacency().SearchV(target)==null && 
                    vt.getAdjacency().SearchV(source)==null)
            {
                vs.getAdjacency().AddLast(vt);
                vt.getAdjacency().AddLast(vs);
                return true;
            }                
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        String text="";
        Node aux = vertexs.getHead();
        while(aux!=null)
        {
            Vertex v = (Vertex)aux.getData();
            text = text + v.getData()+ "->" + v.getAdjacency().toString()+"\n";
            aux=aux.getLink();
        }
        return text;
    }
    
    public int SizeVertex()
    {
        return vertexs.Size();
    }
    
    public int SizeEdge()
    {
        int count = 0;
        Node aux = vertexs.getHead();
        while(aux!=null)
        {
            count += ((Vertex)aux.getData()).getAdjacency().Size();
            aux=aux.getLink();
        }
        return count/2;
    }
    
    public boolean DeleteEdge(Object source, Object target)
    {
        Vertex vs = vertexs.SearchV(source);
        Vertex vt = vertexs.SearchV(target);
        if(vs!=null && vt!=null)
        {
            if(vs.getAdjacency().SearchV(target)!=null &&
                    vt.getAdjacency().SearchV(source)!=null)
            {
                vs.getAdjacency().DeleteV(target);
                vt.getAdjacency().DeleteV(source);
                return true;
            }
        }        
        return false;
    }
    
    public boolean DeleteVertex(Object obj)
    {
        Vertex vd = vertexs.SearchV(obj);
        if(vd!=null)
        {
            Node aux = vd.getAdjacency().getHead();
            while(aux!=null)
            {
                Vertex v = (Vertex)aux.getData();
                v.getAdjacency().DeleteV(obj);
                aux=aux.getLink();                        
            }
            vertexs.DeleteV(obj);
            return true;
        }
        return false;
    }
    
    public List DFS(Object obj)
    {
        Vertex vi = vertexs.SearchV(obj);
        if(vi!=null)
        {
            List visited = new List();
            return DFS(vi,visited);
        }
        return null;
    }
    
    private List DFS(Vertex vcurrent, List visited)
    {
        if(vcurrent!=null)
        {
            visited.AddLast(vcurrent);
            Node aux = vcurrent.getAdjacency().getHead();
            while(aux!=null)
            {
                Vertex v=(Vertex)aux.getData();
                if(visited.SearchV(v.getData())==null)
                    return DFS(v,visited);
                aux=aux.getLink();
            }
        }
        return visited;
    }
}
