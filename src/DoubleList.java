public class DoubleList {
    private DoubleNode head;
    private DoubleNode last;

    public DoubleList() {
    }
    
    public boolean isEmpty()
    {
        return head==null && last==null;
    }
    
    public void AddFirst(Object data)
    {
        if(isEmpty())
        {
            head = new DoubleNode(data);
            last = head;
        }
        else
        {
            DoubleNode n = new DoubleNode(data);
            n.setNext(head);
            head.setPrevious(n);
            head = n;
        }
    }
    
    public void AddLast(Object data)
    {
        if(isEmpty())
            AddFirst(data);
        else
        {
            DoubleNode n = new DoubleNode(data);
            n.setPrevious(last);
            last.setNext(n);
            last = n;
        }
    }
    
    public void AddPos(Object data, int pos)
    {
        if(pos==1)
            AddFirst(data);
        else
        {
            if(pos==Size()+1)
                AddLast(data);
            else
            {
                int count=1;
                DoubleNode aux = head;
                while(aux!=null && count<pos)
                {
                    aux = aux.getNext();
                    count++;
                }
                
                DoubleNode n = new DoubleNode(data);
                n.setNext(aux);
                n.setPrevious(aux.getPrevious());
                aux.getPrevious().setNext(n);
                aux.setPrevious(n);                        
            }
        }
    }
    //recorro la lista de atras hacia adelante
     public int Size()
    {
        //declaraciones de objetos y variable
	    int count = 0;
        DoubleNode aux=last;
        while(aux!=null)
        {
           count++;
           aux=aux.getPrevious();
        }
        return count;
    }
     
    @Override
    public String toString()
    {
        String text="";
        DoubleNode aux=head;
        while(aux!=null)
        {
            text=text + aux.getData() + "\n";
            aux=aux.getNext();
        }
        return text;
    }
    
    public boolean DeleteFirst()
    {
        if(!isEmpty())
        {
            head=head.getNext();
            if(head==null)
                last=null;
            else
                head.setPrevious(null);
            return true;
       }
        return false;
    }
    public boolean DeleteLast()
    {
        if(!isEmpty())
        {
            last=last.getPrevious();
            if(last==null)
                head=null;
            else
                last.setNext(null);
            return true;
       }
        return false;
    }
    
    public boolean DeletePos(int pos)
    {
        if(pos==1)
            DeleteFirst();
        else
        {
            if(pos==Size())
                DeleteLast();
            else
            {
                int count=1;
                DoubleNode aux= head;
                while(aux!=null && count<pos)
                {
                    count++;
                    aux=aux.getNext();
                }
                aux.getPrevious().setNext(aux.getNext());
                aux.getNext().setPrevious(aux.getPrevious());
            }
            return true;
        }
        return false;
    }
    
    public boolean Search(int id)
    {
        DoubleNode aux = last;
        while(aux!=null)
        {
            if((int)aux.getData()==id)
                return true;
            
            aux = aux.getPrevious();
        }
        return false;
    }
    public void User(DoubleList dl)
    {
        DoubleNode aux = head;
        while(aux!=null)
        {
            int id = ((int)aux.getData());
            if(!dl.Search(id))
                dl.AddLast(id);
            
            aux=aux.getNext();
        }
    }
}
