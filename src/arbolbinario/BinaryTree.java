package arbolbinario;

import estructuras.List;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree() {
    }
    
    public boolean isEmpty()
    {
        return root==null;
    }
    
    public void Add(Object data)
    {
        if(isEmpty())
            root = new BinaryNode(data);
        else
            Add(data, root);
    }
    
    private void Add(Object data, BinaryNode aux)
    {
        String mside[]={"Left", "Right"};
        String side;
        if(aux!=null)
        {
//            side = (String)JOptionPane.showInputDialog(null, "Selected side of: " + aux.getData(),
//                    "Side", 1, null, mside, mside[0]);
            if((int)aux.getData()>(int)data)
            {
                if(aux.getLeft()==null)
                    aux.setLeft(new BinaryNode(data));
                else
                    Add(data, aux.getLeft());
            }
            else
            {
                if(aux.getRight()==null)
                    aux.setRight(new BinaryNode(data));
                else
                    Add(data, aux.getRight());
            }
        }
    }
    
    public String PreOrder()
    {
        return PreOrder(root);
    }
    
    private String PreOrder(BinaryNode aux)
    {
        if(aux!=null)
            return aux.getData() +" " + PreOrder(aux.getLeft()) + PreOrder(aux.getRight());
        
        return "";
    }
    
    public String InOrder()
    {
        return InOrder(root);
    }
    
    private String InOrder(BinaryNode aux)
    {
        if(aux!=null)
            return  InOrder(aux.getLeft()) + aux.getData() +" " + InOrder(aux.getRight());
        
        return "";
    }
    
      public String PostOrder()
    {
        return PostOrder(root);
    }
    
    private String PostOrder(BinaryNode aux)
    {
        if(aux!=null)
            return  PostOrder(aux.getLeft()) + PostOrder(aux.getRight())+ aux.getData() +" ";
        
        return "";
    }
    
    public int Size()
    {
        return Size(root);
    }
    
    private int Size (BinaryNode aux)
    {
        if(aux!=null)
            return 1 + Size(aux.getLeft()) + Size(aux.getRight());
//        return  Size(aux.getLeft()) +1 + Size(aux.getRight()); -> InOrder
//        return  Size(aux.getLeft()) + Size(aux.getRight())+ 1 ; -> PostOrder
        
        return 0;
    }
    
     public int Height()
    {
        return Height(root);
    }
    
    private int Height (BinaryNode aux)
    {
        if(aux!=null)
            return 1 + Math.max(Height(aux.getLeft()), Height(aux.getRight()));

        return 0;
    }
    
    public boolean Search(int x)
    {
        return Search(root, x);
    }
    
    private boolean Search (BinaryNode aux, int x)
    {
        if(aux!=null)
        {
            if((int)(aux.getData())==x)
                return true;
            else
                return Search(aux.getLeft(),x) || Search(aux.getRight(),x);
        }
        return false;
    }
    
    public BinaryNode SearchNode(int x)
    {
        return SearchNode(x, root);
    }
 
    private BinaryNode SearchNode(int x, BinaryNode aux)
    {
        if(aux!=null)
        {
            if(x == ((int)(aux.getData())))
                return aux;
            
            BinaryNode res= SearchNode(x,aux.getLeft());
            if(res==null)
                res=SearchNode(x, aux.getRight());
            return res;
        }
        return null;
    }
    
    public BinaryNode getFather(int x)
    {
        if(!isEmpty())
        {
            if((int)root.getData()==x)
                return null;
            return getFather(x,root);
        }        
        return null;
    }
    
    private BinaryNode getFather(int x, BinaryNode aux)
    {
        BinaryNode father=null;
        if(aux!=null)
        {
            if((aux.getLeft()!=null && ((int)aux.getLeft().getData())==x)||
                    (aux.getRight()!=null && ((int)aux.getRight().getData()==x)))
                return aux;
            else
            {
                father = getFather(x, aux.getLeft());
                if(father==null)
                    father = getFather(x, aux.getRight());
            }            
        }
        return father;
    }
    
    public List Path(int x)
    {
        List list = new List();
        BinaryNode search = SearchNode(x);
        System.out.println("seatrx " + search.getData());
        if(search!=null)
            return Path(search, list);
        
        return null;
    }
    
    private List Path(BinaryNode aux, List list)
    {
        if(aux!=null)
        {
            System.out.println("aux " + aux.getData());
            list.AddFirst(aux.getData());
            return Path(getFather((int)(aux.getData())), list);
        }
        return list;
    }
    
    public List Success(int x)
    {
        BinaryNode search = SearchNode(x);
        List list = new List();
        if(search!=null)
        {
            Success(search.getLeft(), list);
            Success(search.getRight(),list);
        }
        return list;        
    }
    private List Success(BinaryNode aux, List list)
    {
        if(aux!=null)
        {
            list.AddLast(aux.getData());
            Success(aux.getLeft(), list);
            Success(aux.getRight(),list);
        }
        return list;
    }
    
    public boolean Delete(int x)
    {
        BinaryNode delete = SearchNode(x);
        if(delete!=null)
        {
            if(delete.getLeft()==null && delete.getRight()==null)
                Delete0(delete);
            else
            {
                if(delete.getLeft()==null || delete.getRight()==null)
                    Delete1(delete);
                else
                    Delete2(delete);
            }
            return true;
        }
        return false;
    }
    
    private void Delete0(BinaryNode delete)
    {
        BinaryNode father = getFather((int)delete.getData());
        if(father==null)
            root=null;
        else
        {
            if(delete.equals(father.getLeft()))
                father.setLeft(null);
            else
                father.setRight(null);
        }
    }
    
    private void Delete1(BinaryNode delete)
    {
         BinaryNode father = getFather((int)delete.getData());
         if(father==null)
         {
             if(delete.getLeft()!=null)
                 root=delete.getLeft();
             else
                 root=delete.getRight();
         }
         else
         {
             if(delete.equals(father.getLeft()))
             {
                 if(delete.getLeft()!=null)
                     father.setLeft(delete.getLeft());
                 else
                     father.setLeft(delete.getRight());
             }
             else
             {
                 if(delete.getLeft()!=null)
                     father.setRight(delete.getLeft());
                 else
                     father.setRight(delete.getRight());
             }
         }
    }
    
    public BinaryNode MoreLeft(BinaryNode aux)
    {
        if(aux!=null && aux.getLeft()!=null)
            return MoreLeft(aux.getLeft());
        
        return aux;
    }
    
    public void Delete2(BinaryNode delete)
    {
        BinaryNode moreizq=MoreLeft(delete);
        Delete((int)moreizq.getData());
        delete.setData((int)(moreizq.getData()));        
    }
}
