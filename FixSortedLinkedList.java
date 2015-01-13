import java.util.*;

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


public class FixSortedLinkedList 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    public static void test1()
    {
        SLL s1 = new SLL();
        s1.append(1);
        s1.append(2);
        s1.append(4);
        s1.append(3);
        s1.append(5);
        show(s1.getHead());
        System.out.println("-----------------------------");
        Fix(s1.getHead());
        show(s1.getHead());
        System.out.println("-----------------------------");
    }

    public static void test2()
    {
        SLL s1 = new SLL();
        s1.append(3);
        s1.append(2);
        s1.append(1);
        s1.append(4);
        s1.append(5);
        show(s1.getHead());
        System.out.println("-----------------------------");
        Fix(s1.getHead());
        show(s1.getHead());
        System.out.println("-----------------------------");
    }

    public static void test3()
    {
        SLL s1 = new SLL();
        s1.append(3);
        s1.append(2);
        show(s1.getHead());
        System.out.println("-----------------------------");
        Fix(s1.getHead());
        show(s1.getHead());
        System.out.println("-----------------------------");
    }
    public static void test4()
    {
        SLL s1 = new SLL();
        s1.append(3);
        show(s1.getHead());
        System.out.println("-----------------------------");
        Fix(s1.getHead());
        show(s1.getHead());
        System.out.println("-----------------------------");
    }

    public static void test5()
    {
        SLL s1 = new SLL();
        s1.append(Integer.MIN_VALUE);
        show(s1.getHead());
        System.out.println("-----------------------------");
        Fix(s1.getHead());
        show(s1.getHead());
        System.out.println("-----------------------------");
    }
    public static void test6()
    {
        SLL s1 = new SLL();
        s1.append(Integer.MAX_VALUE);
        show(s1.getHead());
        System.out.println("-----------------------------");
        Fix(s1.getHead());
        show(s1.getHead());
        System.out.println("-----------------------------");
    }
    public static void test7()
    {
        SLL s1 = new SLL();
        s1.append(Integer.MAX_VALUE);
        s1.append(Integer.MIN_VALUE);
        show(s1.getHead());
        System.out.println("-----------------------------");
        Fix(s1.getHead());
        show(s1.getHead());
        System.out.println("-----------------------------");
    }

    // Fix reversed sublist in a single linkedlist
    // Input: 1->2->3->5->4->6  (5->4) reverse
    // output:1->2->3->4->5->6
    public static void Fix(Node head)
    {
        Stack<Integer> stack = new Stack<Integer>();
        Node curr = head;

        Node minNode = new Node(Integer.MIN_VALUE);
        minNode.next = curr;
        curr = head = minNode;
        while(curr != null && curr.next != null)
        {
            curr = curr.next; 
        }
        Node prev = curr;
        curr.next = new Node(Integer.MAX_VALUE);
        Node start = null;
        curr = head;
        while(curr != null)
        {
            Node next = curr.next;
            if(next != null)
            {
                if(curr.data > next.data)
                {
                    stack.push(curr.data);
                    if(start == null)
                        start = curr;
                }
                else if(start != null)
                {
                    stack.push(curr.data);
                    break;
                }
            }
            curr = next;
        }
        while(start != null && !stack.empty())
        {
            start.data = stack.pop();
            System.out.println("start.data["+start.data+"]");
            start = start.next;
        }
        head = head.next;
        prev.next = null;

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

}
