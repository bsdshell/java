import java.io.*;
import java.lang.String;

class Node 
{
	Node prev;
	Node next;
	Node rand;
	int data;
	public Node()
	{ prev = next = rand = null; data=0;}
	public Node(int n)
	{ prev = next = rand = null; data = n;}
}

class DLL
{
	Node head;
	Node tail;
	public DLL()
	{ head = tail = null;}
	public Node gethead()
	{
		return head;
	}	
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
			System.out.println ("original cur.data=" + cur.data + "ran:"+cur.rand.data);
			cur = cur.next;
		}
	}
	
	public void show1()
	{
		Node cur = tail; 
		while(cur != null)
		{
			System.out.println ("rev cur=" + cur.data + "ran:"+cur.rand.data);
			cur = cur.prev;
		}
	}
}

class randomNode 
{
	public static void main(String args[])
	{
		DLL dll = new DLL();

		Node p1 = new Node(3);
		Node p2 = new Node(4);
		Node p3 = new Node(5);

		//dll.addNext(p3, new Node(7));

		p1.rand = p3;
		p2.rand = p2;
		p3.rand = p1;
		dll.append(p1);
		dll.append(p2);
		dll.append(p3);

		dll.show();

		Node head = copyRandom(dll.gethead());
		show2(head);
	}
	public static void show2(Node head)
	{
		Node cur = head; 
		while(cur != null)
		{
			System.out.println ("rev cur=" + cur.data + "ran:"+cur.rand.data);
			//System.out.println ("rev cur=" + cur.data);
			cur = cur.next;
		}
	}	
	public static Node copyRandom(Node head)
	{
		Node cur = head;
		Node next= null;
		Node copycur = null;
		Node copynext = null;
		Node copyhead = null;

		//make copy current node and add to next
		while(cur != null)
		{ Node copy = new Node();
			copy.data = cur.data;

			next = cur.next;
			if(next != null)
			{ cur.next = copy;
				copy.next = next;
				cur = next;
				next = cur.next;
			}
			else
			{
				cur.next = copy;
				cur = next;
			}
		}

		cur = head;
		copyhead = copycur = cur.next;
		while(cur != null)
		{
			copycur.rand = cur.rand.next; //wire the random node 
			cur = cur.next;
			if(cur != null)
				cur = cur.next;

			copycur = copycur.next;
			if(copycur != null)
				copycur = copycur.next;
		}
		
		cur = head;
		copyhead = copycur = cur.next;
		while(cur != null)
		{
			next = copycur.next;
			if( next != null)
			{
				copynext = next.next;
				cur.next = next;
				copycur.next = copynext;
				copynext.prev = copycur;
				cur = next;
				copycur = copynext;
			}
			else
			{
				cur.next=null;
				cur = next;
			}
		}
		return copyhead;
	}
}
