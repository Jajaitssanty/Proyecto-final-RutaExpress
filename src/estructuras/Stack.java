package estructuras;

public class Stack {
    private Node top;

    public Stack() {
    }
    
    public boolean isEmpty()
    {
        return top==null;
    }

    //Ingresar dato
    public void Push(Object data)
    {
        if(isEmpty())
            top = new Node(data);
        else
        {
            Node n = new Node(data);
            n.setLink(top);
            top = n;
        }
    }

    //Mostrar dato
    public Object Pop()
    {
        if(!isEmpty())
        {
            Object dato=top.getData();
            top=top.getLink();
            return dato;            
        }
        return null;
    }
}
