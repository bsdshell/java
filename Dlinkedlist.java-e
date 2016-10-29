import java.io.*;
import java.lang.String;

class Node 
{
	Node prev;
	Node next;
	int data;
	public Node(int n)
	{ prev = next = null; data = n;}
}

class DLL
{
	Node head;
	Node tail;
	public DLL()
	{ head = tail = null;}
	public void append(Node no)
	{
		if(head == null)
		{ head = no; tail = head; }
		else
		{
			tail.next = no;
			no.prev = tail;;
			tail = tail.next;
		}
	}
	public void addfront(Node no)
	{
		if(head == null)
		{ head = no; tail = head;}
		else
		{
			head.prev = no;
			no.next = head;
			head = no;
		}
	}
	public void addNext(Node front, Node no)
	{
		if(front != null)
		{
			if(front.next == null)
			{ append(no);}
			else
			{
				Node cur = no;	
				Node prev = front;
				Node next = front.next;
					
				cur.prev = prev;
				cur.next = next;
				prev.next = cur;
				next.prev = cur;
			}
		}
	}
	public void Remove(Node no)
	{
		if(no != null)
		{
			Node cur = head;
			while(cur != no) cur=cur.next;

			if(cur != null)
			{
				if(cur.prev == null)
				{
					System.out.println ("here1");
					if(cur.next != null)
					{
						Node prev = cur;
						cur = cur.next;
						head = cur;
						cur.prev = null;
						prev.next = null;
					}
					else
					{
						head = tail = null;
					}
				}
				else
				{
					System.out.println ("here2");
					if(cur.next != null)
					{
						Node prev = cur.prev;
						Node next = cur.next;
						prev.next = next;
						next.prev = prev;
						cur.next = null;
						cur.prev = null;
					}
					else
					{
						tail = cur.prev;
						tail.next = null;
						cur.prev = null;
					}
				}
			}
			else
				System.out.println("error");
		}
	}
	public void show()
	{
		Node cur = head;
		while(cur != null)
		{
			System.out.println ("cur=" + cur.data);
			cur = cur.next;
		}
	}
	public void show1()
	{
		Node cur = tail; 
		while(cur != null)
		{
			System.out.println ("rev cur=" + cur.data);
			cur = cur.prev;
		}
	}

}

class Dlinkedlist 
{
	public static void main(String args[])
	{
		DLL dll = new DLL();
		Node p1 = new Node(3);
		dll.append(p1);
		Node p2 = new Node(4);
		dll.append(p2);
		Node p3 = new Node(5);
		dll.append(p3);

		dll.addNext(p3, new Node(7));

		Node p4 = new Node(10);
		dll.append(p4);
		dll.show();
		dll.show1();

		dll.Remove(p4);
		System.out.println ("====");
		dll.show();
	}
}
