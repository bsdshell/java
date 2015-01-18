class Node
{
    Node next;
    int data;
    public Node(int data)
    {this.data = data;}
}

class InsertToList
{
    Node head;
    public InsertToList()
    {head = null; }
    public void insert(Integer data)
    {
        if(head == null)
            head = new Node(data);
        else
        {
            Node curr = head;
            Node next = curr.next;
            if(next == null) //One node only
            {
                Node node = new Node(data);
                if(data > curr.data)
                    curr.next = node;
                else
                {
                    node.next = curr;
                    head = node;
                }
            }
            else            //More than one node
            {
                //Insert node before the head
                if(data < curr.data)
                {
                    Node node = new Node(data);
                    node.next = curr;
                    head = node;
                }
                else 
                {
                    //Insert node between curr and next 
                    while(next != null)
                    {
                        if(curr.data < data && data < next.data)
                        {
                            curr.next = new Node(data);
                            curr.next.next = next;
                            break;
                        }
                        curr = next;
                        next = next.next;
                    }
                    if(next == null) //Insert to the last node
                    {
                        curr.next = new Node(data);
                    }
                }
            }
        }
    }
    public void printList()
    {
        Node curr = head;
        while(curr != null)
        {
            System.out.print("["+curr.data+"]");
            curr = curr.next;
        } 
    }
}

public class InsertToOrderList 
{
    public static void main(String[] args)
    {
        System.out.println("Insert an integer to order list");
        InsertToList orderList = new InsertToList();        
        orderList.insert(1);
        orderList.insert(0);
        orderList.printList();
    }
}
