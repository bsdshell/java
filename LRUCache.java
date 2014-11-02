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
    Node head;
    Node tail;
    int max_size;
    int count;
    Map<String, Node> map = new HashMap<String, Node>();
    public LRU(int size)
    {
        head = tail = null;
        max_size = size;
        count = 0;
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
            append(key, node.data);
        }
    }
    void remove(String key)
    {
        Node node = map.get(key);
        if(head == null)
            return;
        else
        {
            if(node != null)
            {
                if(node == head)
                {
                    removeHead(key);
                }
                else if(node == tail)
                {
                    removeTail(key);
                }
                else
                {
                    removeMiddle(key);
                }
            }
        }
    }
    void removeHead()
    {
        if(head != null)
        {
            Node next = head.next;
            head.next = null;
            next.prev = null;
            head = next;
            count--;
        }
    }
    void removeTail(String key)
    {
    }
    void removeMiddle(String key)
    {
        Node curr = map.get(key);
        if(curr != null && head != tail)
        {
            Node prev = curr.prev;
            Node next = curr.next;
            prev.next = next;
            next.prev = prev;
            curr.next = null;
            curr.prev = null;
            count--;
        }
    }
    void append(String key, String data)
    {
        Node node = new Node<String>(key, data);
        if(head == null)
        {
            head = tail = node; 
            count++;
        }
        else
        {
            if(count >= max_size)
            {
                removeHead();
            }
            else
            {
                tail.next = node;
                node.prev = tail;
                tail = node;
                count++;
            }
        }
    }
    void deleteFront()
    {
        if(head != null)
        {
            Node next = head.next;
            if(next == null) //One node
            {
                head = tail = null;
            }
            else
            {
                head.next = null;
                next.prev = null;
                map.put(head.key, null);
                head = next;
            }
            count--;
        }
    }
    
    void moveToTail(String key)
    {
        if(head != null)
        {
           if(head.key == key) 
           {
               Node node = map.get(key);
               removeHead();
               append(key, node);
           }
        }
    }
}

public class LRUCache 
{
    public static void main(String[] args)
    {
        //System.out.println("hashcode:" + c.hashCode());
        System.out.println("Hello World!");
        LRU  lru = new LRU(10);
        Node<String> node = new Node<String>("key", "data");
    }
}
