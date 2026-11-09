public class List {
    private Node head;

    public List() {
        head=null;
    }

    public boolean isEmpty()
    {
        return head==null;
    }

    public Node Last()
    {
        Node last=null;
        Node aux=head;
        while(aux!=null)
        {
           last=aux;
            aux=aux.getLink();
        }
        return last;
    }

    public void AddFirst(Object data) {
        if (isEmpty()) {
            head = new Node(data);
        }
        else
        {
            Node n = new Node(data);
            n.setLink(head);
            head = n;
        }
    }

    //cantidad de elementos -> operacion de recorrido de la lista
    public int Size()
    {
        //declaraciones de objetos y variable
	    int count = 0;
        Node aux=head;
        while(aux!=null)
        {
           count++;
            aux=aux.getLink();
        }
        return count;
    }

    public void AddLast(Object data) {
        if (isEmpty()) {
            head = new Node(data);
        }
        else
        {
            Node n = new Node(data);
            Node last = Last();
            last.setLink(n);
        }
    }

    public void AddSecond(Object data) {
        if (isEmpty()) {
            head = new Node(data);
        } else {
            Node n = new Node(data);
            n.setLink(head.getLink());
            head.setLink(n);
        }
    }
    

    public Node BuscarCliente(int data) {
        Node cliente = null;
        Node aux=head;
        while(aux!=null) {
            if (((Cliente)aux.getData()).getDocumento() == data) {
                cliente = aux;
            }
            aux = aux.getLink();
        }
        return cliente;
    }

    @Override
    public String toString()
    {
        String text="";
        Node aux=head;
        // Se recorre la lista completa concatenando el dato de cada nodo, separado por un salto de linea.
        while(aux!=null)
        {
            text=text + aux.getData() + "\n";
            aux=aux.getLink();
        }
        return text;
    }
}