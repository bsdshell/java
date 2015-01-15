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
    public Node getTail()
    {
        Node curr = head;
        while(curr != null && curr.next != null)
        {
            curr = curr.next;
        }
        return curr;
    } 
}

//Merge sort on single linkedlist
public class MergeSortLinkedList 
{
    public static void main(String[] args)
    {
        System.out.println("Merge Sort linkedlist");
        test1();
        test2();
        test3();
        test4();

    }

    public static void test1()
    {
        System.out.println("Test1()");
        SLL s3 = new SLL();

        s3.append(2);
        s3.append(1);

        show(s3.getHead());
        System.out.println("=======================");
        Node hi = s3.getHead();
        Node lo = s3.getTail();
        hi = mergeSortLinkedList(hi, lo);
        show(hi);
        System.out.println("end Test1()=======================");

    }

    public static void test2()
    {
        System.out.println("Test2()");
        SLL s3 = new SLL();

        s3.append(1);
        s3.append(2);
        s3.append(3);

        show(s3.getHead());

        System.out.println("=======================");
        Node hi = s3.getHead();
        Node lo = s3.getTail();
        hi = mergeSortLinkedList(hi, lo);
        show(hi);
        System.out.println("end Test2()=======================");
    }


    public static void test3()
    {
        System.out.println("Test3()");
        SLL s3 = new SLL();

        s3.append(6);

        show(s3.getHead());

        System.out.println("=======================");
        Node hi = s3.getHead();
        Node lo = s3.getTail();
        hi = mergeSortLinkedList(hi, lo);
        show(hi);
        System.out.println("end Test3()=======================");
    }

    public static void test4()
    {
        System.out.println("Test4()");
        SLL s3 = new SLL();

        s3.append(6);
        s3.append(5);
        s3.append(3);
        s3.append(100);
        s3.append(1);

        show(s3.getHead());

        System.out.println("=======================");
        Node hi = s3.getHead();
        Node lo = s3.getTail();
        hi = mergeSortLinkedList(hi, lo);
        show(hi);
        System.out.println("end Test4()=======================");
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
    public static Node getTail(Node head)
    {
        Node curr = head;
        while(curr != null && curr.next != null)
            curr = curr.next;
        return curr;
    }

    public static Node mergeSortLinkedList(Node lo, Node hi)
    {
        if(lo != null && lo != hi)
        {
            Node m = median(lo);
            Node m1 = m.next;
            m.next = null;

            Node left = mergeSortLinkedList(lo, m);
            Node right = mergeSortLinkedList(m1, hi);
            return mergeLinkedList(left, right);
        }
        else
            return lo;
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

    public static Node mergeLinkedList(Node s1, Node s2)
    {
        Node curr1 = s1;
        Node curr2 = s2;
        Node curr = null;
        Node head = curr;
        if(curr1 == curr2)
            head = s1;
        else
        {
            while(curr1 != null || curr2 != null)
            {
                if(curr1 == null)
                {
                    if(curr == null)
                        head = curr = new Node(curr2.data);
                    else
                    {
                        curr.next = new Node(curr2.data);
                        curr = curr.next;
                    }
                    curr2 = curr2.next;
                }
                else if(curr2 == null)
                {
                    if(curr == null)
                    {
                        head = curr = new Node(curr1.data);
                    }
                    else
                    {
                        curr.next = new Node(curr1.data);
                        curr = curr.next;
                    }
                    curr1 = curr1.next;
                }
                else 
                {
                    if(curr1.data < curr2.data)
                    {
                        if(curr == null)
                            head = curr = new Node(curr1.data);
                        else
                        {
                           curr.next = new Node(curr1.data); 
                           curr = curr.next;
                        }
                        curr1 = curr1.next;
                    }
                    else
                    {
                        if(curr == null)
                            head = curr = new Node(curr2.data);
                        else
                        {
                            curr.next = new Node(curr2.data);
                            curr = curr.next;
                        }
                        curr2 = curr2.next;
                    }
                }
            }
        }
        return head;
    }
}
