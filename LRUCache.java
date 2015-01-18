import java.util.*;

class Node<T>
{
    Node next;
    Node prev;
    String key;
    T data;
    public Node(String key, T data)
    {
        next = prev = null;
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
                most.next = null;
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
            Node<String> node = new Node<String>(key, data);
            least = most = node; 
            map.put(key, node); 
            count++;
        }
        else
        {
            if(count < maxSize)
            {
                Node<String> node = new Node<String>(key, data);
                most.next = node; 
                node.prev = most;
                most = node;
                count++;
                map.put(key, node); 
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
            System.out.println("<"+curr.key+","+curr.data+">");
            curr = curr.next;
        }
    }
}

public class LRUCache 
{
    public static void main(String[] args)
    {
        System.out.println("Least Recent Used Cache");
        LRU  lru = new LRU(4);
        
        lru.insert("key", "mydata");
        lru.insert("key1", "mydata1");
        lru.insert("key2", "mydata2");
        lru.insert("key3", "mydata3");
        lru.insert("key4", "mydata4");
        lru.insert("key5", "mydata5");
        lru.get("key2");
        lru.insert("key3", "mydatakey3");
        lru.print();
    }
}
