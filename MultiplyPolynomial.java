import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Node
{
    int coeff;
    int power;
    String data;
    Node next;
    public Node(int coeff, int power, String data)
    {
        this.coeff = coeff;
        this.power = power;
        this.data = data;
        this.next = null;
    }
}

class SLinkedList
{
    Node head;
    public SLinkedList()
    {
        this.head = null;
    }
    public void add(Node node)
    {
        if(this.head == null)
        {
            this.head = node;
        }
        else
        {
            Node curr = this.head;
            while(curr.next != null)
            {
                curr = curr.next;
            }
            curr.next = node; 
        }
    }
    public void show()
    {
        Node curr = this.head;
        while(curr != null)
        {
            System.out.println("["+curr.coeff+"]["+curr.power+"]");
            curr = curr.next;
        }
    }
}

public class MultiplyPolynomial 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        SLinkedList poly1 = new SLinkedList();
        SLinkedList poly2 = new SLinkedList();
        poly1.add(new Node(1, 2, "x"));
        poly1.add(new Node(2, 3, "x"));
        poly2.add(new Node(4, 5, "x"));
        poly2.add(new Node(6, 7, "x"));
        poly1.show();
        System.out.println("================");
        poly2.show();
        System.out.println("================");
        multiply(poly1, poly2);
        System.out.println("================");
        add(poly1, poly2);
    }
    public static SLinkedList add(SLinkedList poly1, SLinkedList poly2)
    {
        Map map = new HashMap<Integer, Integer>();
        SLinkedList poly = new SLinkedList();
        if(poly1 != null && poly2 != null && poly1.head != null && poly2.head != null)
        {
            Node curr1 = poly1.head; 
            while(curr1 != null)
            {
                Integer coeff = (Integer)map.get(curr1.power);
                if(coeff != null)
                {
                    map.put(new Integer(curr1.coeff + coeff), new Integer(curr1.power));  
                }
                else
                {
                    map.put(new Integer(curr1.coeff), new Integer(curr1.power));
                }
                curr1 = curr1.next;
            }

            Node curr2 = poly2.head; 
            while(curr2 != null)
            {
                Integer coeff = (Integer)map.get(curr2.power);
                if(coeff != null)
                {
                    map.put(new Integer(curr2.coeff + coeff), new Integer(curr2.power));  
                }
                else
                {
                    map.put(new Integer(curr2.coeff), new Integer(curr2.power));
                }
                curr2 = curr2.next;
            }
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            for(Map.Entry<Integer, Integer> entry : set)
            {
                Integer coeff = entry.getKey();
                Integer power = entry.getValue();
                poly.add(new Node(coeff, power, "x"));
            }
            poly.show();
        }
        return poly;
    }
    public static SLinkedList multiply(SLinkedList poly1, SLinkedList poly2)
    {
        Map map = new HashMap<Integer, Integer>();
        SLinkedList poly = new SLinkedList();
        if(poly1 != null && poly2 != null && poly1.head != null && poly2.head != null)
        {
            Node curr1 = poly1.head; 
            Node curr2 = poly2.head;
            while(curr1 != null)
            {
                curr2 = poly2.head;
                while(curr2 != null)
                {
                    Node node = new Node(curr2.coeff*curr1.coeff, curr2.power+curr1.power, "x"); 
                    Integer coeff = (Integer)map.get(new Integer(node.power));
                    if(coeff != null)
                    {
                        map.put(new Integer(node.coeff + coeff), new Integer(node.power));  
                    }
                    else
                    {
                        map.put(new Integer(node.coeff), new Integer(node.power));
                    }
                    curr2 = curr2.next;
                }
                curr1 = curr1.next;
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : set)
        {
            Integer coeff = entry.getKey();
            Integer power = entry.getValue();
            poly.add(new Node(coeff, power, "x"));
        }
        poly.show();
        return poly;
    }
}
