import java.io.*;
import java.lang.String;
import java.util.*;



//single linked list
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

class SingleLinkedList 
{
	public static void main(String args[])
	{
		SLL s = new SLL();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		s.append(n1);
		s.append(n2);
		s.append(n3);
		s.append(n4);
		s.append(n5);
		s.show();

        Node node = mergeHalf(s.getHead());
        show(node);
		//s.Reverse1(s.getHead());

		//s.show();


		System.out.println ("====");
	}
    // 1 2 3 4 5
    // 1 3 5
    // 2 4
    // 1 2
    // 3 4 5
    // 1->3
    // 2->4
    // 5->null
    // 1->3->2->4->5->null
    //
    // 1->3
    // 2->4
    // 1->3->2->4
    public static Node mergeHalf(Node head)
    {
        Node curr = head;
        Queue<Node> q0 = new LinkedList<Node>();
        Queue<Node> q1 = new LinkedList<Node>();
        int count = 0;
        while(curr != null)
        {
            System.out.println("curr[" + curr.data+"]"); 
            q1.add(new Node(curr.data));
            curr = curr.next;
        }

        int halfsize = q1.size()/2;
        int size = q1.size();
        System.out.println("q1size[" + q1.size()+"]"); 
        System.out.println("q1size/2[" + halfsize +"]"); 
        for(int i=0; i<= size/2; i++)
        {
            Node node = q1.remove();
            System.out.println("node[" + node.data+"] i=[" + i+"]"); 
            q0.add(new Node(node.data));
        } 
        
        System.out.println("q0.size[" + q0.size()+"]"); 
        Node prevPair = null;
        Node currPair = null;
        Node newHead = null;
        while(q0.peek() != null)
        {
            Node n0 = q0.remove();
            Node n1 = null;
            if(q1.peek() != null)
            {
                n1 = q1.remove();
                System.out.println("q1[" + n1.data+"]"); 
            }

            n0.next = n1;
            currPair = n0;

            if(prevPair!= null)
                prevPair.next.next = currPair;
            else
                newHead = currPair;
            prevPair = currPair;
        }
        return newHead;
    }
    public static void show(Node curr)
    {
        while(curr != null)
	 	{ 
            System.out.println("[" + curr.data+"]"); 
            curr=curr.next;
        }
    }
}
