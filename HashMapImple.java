interface HashMapInterface
{
    Object put(Object key, Object value);
    Object get(Object key);
    Object remove(Object key);
}

class Node
{
    Object key;
    Object value;
    Node next;
    public Node(Object key, Object value)
    {
        this.next = null;
        this.key = key;
        this.value= value;
    }
}
class HashMapClass implements HashMapInterface
{
    Node[] nodeArray;
    int size;
    public HashMapClass(int size)
    {
        this.size = size;
        nodeArray = new Node[size];
    }
    public Object put(Object key, Object value)
    {
        boolean done = false;
        Object ret = null;
        Node curr = nodeArray[key.hashCode() % this.size];
        while(curr != null && !done)
        {
            if(key != curr.key)
            {
                curr = curr.next;
            }
            else
            {
                ret = curr.value;
                done = true;
            }
        }
        return ret;
    }
    public Object get(Object key)
    {
        Object ret = null;
        if(key != null)
        {
            boolean done = false;
            Node curr = nodeArray[key.hashCode() % this.size];
            while(curr != null && !done)
            {
                if(key != curr.key)
                {
                    curr = curr.next;
                }
                else
                {
                    ret = curr.value;
                    done = true;
                }
            }
        }
        return ret;
    }
    public Object remove(Object key)
    {
        Object ret = null;
        if(key != null)
        {
            boolean done = false;
            Node curr = nodeArray[key.hashCode() % this.size];
            Node prev = curr;
            while(curr != null && !done)
            {
                if(key != curr.key)
                {
                    prev = curr;
                    curr = curr.next;
                }
                else
                {
                    ret = curr.value;
                    if(prev == curr)
                    {
                        prev = curr = null;
                    }
                    else
                    {
                        prev.next = curr.next;
                        done = true;
                    }
                }
            }
        }
        return ret;
    }
}

public class HashMapImple 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
    }
}
