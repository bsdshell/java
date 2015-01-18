class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data = data;
        next = null;
    }
}
class CircularLinkedList
{
    Node first;
    public CircularLinkedList()
    {
        first = null;
    }
    public void print()
    {
        Node tmpFirst = first;
        if( tmpFirst != null)
        {
            Node curr = tmpFirst.next;
            System.out.println("["+tmpFirst.data+"]");
            while(tmpFirst != curr)
            {
                System.out.println("["+curr.data+"]");
                curr = curr.next;
            }
        }
    }
    public void print(Node first)
    {
        this.first = first;
        print();
    }
    public void setFirst(Node first)
    {
        this.first = first;
    }
    public void insert(Node node)
    {
        if(node != null)
        {
            if(first == null) //zero node
            {
                first = node;
                node.next = first;
            }
            else
            {
                Node curr = first;
                Node next = curr.next;
                if(next == null) //one node
                {
                    first.next = node;
                    node.next = first;
                }
                else //two or more nodes
                {
                    boolean done = false;
                    while(!done)
                    {
                        if(curr.data < next.data)
                        {
                           if(curr.data < node.data && node.data < next.data) 
                           {
                                curr.next = node;
                                node.next = next;
                                done = true;
                           }
                        }
                        else
                        {
                            if(node.data > curr.data || node.data < next.data)
                            {
                                curr.next = node;
                                node.next = next;
                                done = true;
                            }
                        }
                        curr = curr.next;
                        next = next.next;
                    }
                }
            }
        }
    }
}
public class InsertCircularLinkedList 
{
    public static void main(String[] args)
    {
        System.out.println("Insert node to sorted circular linked list!");
        CircularLinkedList cll = new CircularLinkedList();
        Node node1 = new Node(10);
        Node node2 = new Node(6);
        Node node3 = new Node(20);
        Node node4 = new Node(1);
        Node node5 = new Node(7);
        
        cll.insert(node1);
        cll.insert(node2);
        cll.insert(node3);
        cll.setFirst(node2);

        cll.insert(node4);
        cll.insert(node5);
        cll.print();
    }
}
