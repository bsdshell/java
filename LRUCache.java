import java.util.*;

class Node<T>
{
    Node next;
    Node prev;
    String key;
    T data;
    public Node(String key, T data)
    {
        this.key = key;
        this.data = data;
    }
}

class LRU
{
    Node least;
    Node most;
    int maxSize;
    int count;
    Map<String, Node<String>> map = new HashMap<String, Node<String>>();
    public LRU(int size)
    {
        least = most = null;
        maxSize = size;
        count = 0;
    }
    
    Node get(String key)
    {
        Node<String> node = map.get(key);
        if( node != null)
        {
            if(node != most)
            {
                remove(node.key);    
                append(key, node.data);
            }
        }
        return node;
    }
    void insert(String key, String data)
    {
        if(!map.containsKey(key))
        {
            append(key, data);
        }
        else
        {
            Node node = map.get(key);
            remove(key);
            append(key, data);
        }
    }
    void remove(String key)
    {
        Node curr = map.get(key);
        if( curr != null)
        {
            Node prev = curr.prev;
            Node next = curr.next;
            if(prev == null && next == null)
            {
                least = most = null;
                curr.next = curr.prev = null; 
            }
            else if(prev != null && next == null)
            {
                most = prev;
                prev.next = null;
                curr.next = curr.prev = null; 
            }
            else if(prev == null && next != null)
            {
                least = next;
                next.prev = null;
                curr.next = curr.prev = null; 
            }
            else
            {
                prev.next = next;
                next.prev = prev;
                curr.next = curr.prev = null; 
            }
            map.remove(key);
            count--;
        } 
    }
    void append(String key, String data)
    {
        if(least == null)
        {
            least = most = new Node<String>(key, data);
            count++;
        }
        else
        {
            if(count < maxSize)
            {
                Node n = new Node<String>(key, data);
                most.next = n; 
                n.prev = most;
                most = n;
                count++;
            }
            else
            {
                Node next = least.next;
                least.next = null;
                if(next != null)
                    next.prev = null;
                else
                    least = most = null;
                least = next;
                count--;
                append(key, data);
            }
        }
    }
    void print()
    {
        Node curr = least;
        while(curr != null)
        {
            System.out.println("curr="+curr.data);
            curr = curr.next;
        }
    }
}

public class LRUCache 
{
    public static void main(String[] args)
    {
        //System.out.println("hashcode:" + c.hashCode());
        System.out.println("Hello World!");
        LRU  lru = new LRU(4);
        Node<String> node = new Node<String>("key", "data");
        lru.insert("key", "mydata");
        lru.insert("key1", "mydata1");
        lru.insert("key2", "mydata2");
        lru.insert("key3", "mydata3");
        lru.insert("key4", "mydata4");
        lru.insert("key5", "mydata5");
        lru.get("key3");
        lru.print();
    }
}
