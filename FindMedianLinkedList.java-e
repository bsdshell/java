import java.util.*;

public class FindMedianLinkedList 
{
    public static void main(String[] args)
    {
        System.out.println("Find the median of linkedlist");
        SLL s1 = new SLL();
        s1.append(2);
        s1.append(20);
        s1.append(30);
        s1.append(40);
        s1.append(50);

        Node node = median(s1.getHead());
        System.out.println("median["+node.data+"]");
    }

    public static void show(Node curr)
    {
        while(curr != null)
        {
	 	    System.out.println("["+curr.data+"]");
            curr = curr.next;
        }
    }
    
    public static Node median(Node head)
    {
        Node curr = head;
        Node mcurr = curr;
        if(curr != null)
        {
            while(curr.next != null)
            {
                curr = curr.next.next;
                if(curr == null)
                    break;
                mcurr = mcurr.next;
            }
        }
        return mcurr;
    }
}
