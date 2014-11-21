import java.io.*;
import java.lang.String;

class Node 
{
	Node next;
	int data;
	public Node(int n)
	{ next = null; data = n;}
}

class SLL
{
	Node head;
	public SLL()
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

class ReverseSingleLinkedList 
{
	public static void main(String args[])
	{
		SLL s = new SLL();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);

		s.append(n1);
		s.append(n2);
		s.append(n3);
		s.show();

		//s.Reverse(s.getHead());

		//System.out.println ("Reverse");
		//s.show();
		System.out.println ("Reverse 2");
        Node h = Reverse2(s.getHead());
        show(h);
	}
    static Node head = null;
    public static Node Reverse(Node curr)
    {
        if(curr != null)
        {
            Node node = Reverse(curr.next);
            if(node != null)
            {
                node.next = curr;
                curr.next = null;
            }
            else
            {
                head = curr;
            }
        }
        return curr;
    }
    
    public static Node Reverse2(Node curr)
    {
        Node tmp = null;
        if(curr == null)
            return null;
        else if(curr.next == null)
            return curr;
        else
        {
            tmp = Reverse2(curr.next);
            curr.next.next = curr;
            curr.next = null;
        }
        return tmp;
    }
    public static void show(Node curr)
    {
        while(curr != null)
        {
            System.out.println("["+curr.data+"]");
            curr = curr.next;
        }
    }
}
