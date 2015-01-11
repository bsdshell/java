import java.util.List;
import java.util.ArrayList;

//single linked list
class Node 
{
	Node next;
	int data;
	public Node(int n)
	{ next = null; data = n;}
}

class SingleLinkedList 
{
	Node head;
	public SingleLinkedList()
	{ head = null;}
	public void append(Node no)
	{
		Node cur = head;
		if(head == null)
			head = no;
		else
		{
			while(cur.next != null)
			{ cur = cur.next; }
			cur.next = no;
		}
	}
    public void append(int n)
    {
        Node cur = head;
		if(head == null)
			head = new Node(n);
		else
		{
			while(cur.next != null)
			{ 
                cur = cur.next; 
            }
			cur.next = new Node(n);
		}
    }

	//recursive 
	static Node next=null;
	public void Reverse(Node cur)
	{
		if(cur != null)
		{
			Reverse(cur.next);
			if(next != null)
				next.next = cur;	
			else 
				head = cur;
			next = cur;
			cur.next = null;
		}
	}
	//iteration
	public void Reverse1(Node cur)
	{
		if(head != null)
		{
			Node prev = null;
			Node next = cur.next;

			while(cur != null)
			{
				cur.next = prev;
				prev = cur;
				cur = next;
				if(next != null)
					next = next.next;
			}
			head = prev;
			
		}
	}
	public Node getHead()
	{ return head;}
	public void Remove(Node no)
	{
		if(no != null && head != null)
		{
			Node cur = head;	
			Node prev = null;
			while(cur != no)
			{
				prev = cur;
				cur = cur.next;
			}
			if(prev != null && no.next != null)
			{ prev.next = no.next; no.next = null; }
			else if(prev == null && no.next != null)
			{ head = no.next; no.next = null; }
			else if(prev != null && no.next == null)
			{ prev.next = null; }
			else 
			{ no = null; head = null;}
		}	
	}
	public void show()
	{
		Node cur=head;
		while(cur != null)
	 	{ System.out.println("cur.data=" + cur.data); cur=cur.next;}
	}
}


//simple sort linked list algorithm
public class SortLinkedList
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(4);
        sll.append(3);
        sll.append(2);
        sll.append(1);
        sll.show();
        sort(sll.getHead());
        show(sll.getHead());

    }
    public static void show(Node head)
    {
        Node curr = head;
        while(curr != null)
        {
	 	    System.out.println("["+curr.data+"]");
            curr = curr.next;
        }
    }
    public static void sort(Node head)
    {
        if(head != null && head.next != null)
        {
            Node curr = head;
            Node last = null;
            while(head != last)
            {
                Node next = curr.next;
                while(next != last)
                {
                    if(curr.data > next.data)    
                    {
                        int tmp = curr.data;
                        curr.data = next.data;
                        next.data = tmp;
                    }
                    curr = next;
                    next = next.next;
                }
                last = curr;
                curr = head;
            }
        }
    }
}
