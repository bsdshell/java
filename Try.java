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
    public Node getTail()
    {
        Node curr = head;
        while(curr != null && curr.next != null)
        {
            curr = curr.next;
        }
        return curr;
    }
	public void show()
	{
		Node cur=head;
		while(cur != null)
	 	{ System.out.println("cur.data=" + cur.data); cur=cur.next;}
	}
}

public class Try 
{
    public static void main(String[] args)
    {
        System.out.println("Try it");
        SLL s1 = new SLL();
        SLL s2 = new SLL();
        SLL s3 = new SLL();
        s1.append(2);
        s1.append(20);
        s1.append(30);
        s1.append(40);
        s1.append(50);

        System.out.println("================");
        show(s1.getHead());
        System.out.println("================");
        Node mnode = partition(s1.getHead());
        show(s1.getHead());
        System.out.println("================");
        show(mnode);
        System.out.println("================");

        Node node = median(s1.getHead());
        System.out.println("median["+node.data+"]");

        s2.append(1);
        s2.append(7);
        s2.append(10);

        s3.append(3);
        s3.append(4);
        s3.append(20);

        Node s =  mergeList(mergeList(s1.getHead(), s2.getHead()), s3.getHead());
        show(s);
        test1();
        test2();
        test3();
        test4();
    }
    public static void show(Node curr)
    {
        while(curr != null)
        {
	 	    System.out.println("["+curr.data+"]");
            curr = curr.next;
        }
    }

    public static void test4()
    {
        System.out.println("begin test4==================");
        SLL s1 = new SLL();
        s1.append(2);
        s1.append(40);
        s1.append(100);
        
        /*
        s1.append(50);
        s1.append(30);
        s1.append(1);
        s1.append(6);
        s1.append(20);
        s1.append(2);
        */
        
        System.out.println("----------------------------");
        show(s1.getHead());
        System.out.println("----------------------------");

        Node[] prev = new Node[1];
        prev[0] = null;
        qsLinkedList(s1.getHead(), s1.getTail(), prev);
        show(s1.getHead());
        System.out.println("begin test4==================");
    }
    public static void test2()
    {
        System.out.println("begin test2()================");
        SLL s1 = new SLL();
        s1.append(4);
        s1.append(8);
        show(s1.getHead());

        Node[] prev = new Node[1];
        prev[0] = null;
        Node pivot = qsPartition(s1.getHead(), s1.getTail(), prev);
        System.out.println("pivot=["+pivot.data+"]");
        System.out.println("================");
        show(s1.getHead());
        System.out.println("end test1()================");
    }

    public static void test3()
    {
        System.out.println("begin test3()================");
        SLL s1 = new SLL();
        s1.append(4);
        show(s1.getHead());

        Node[] prev = new Node[1];
        prev[0] = null;
        Node pivot = qsPartition(s1.getHead(), s1.getTail(), prev);
        System.out.println("pivot=["+pivot.data+"]");
        System.out.println("================");
        show(s1.getHead());
        System.out.println("end test3()================");
    }
    public static void test1()
    {
        System.out.println("begin test2()================");
        SLL s1 = new SLL();
        s1.append(4);
        s1.append(8);
        s1.append(3);
        s1.append(6);
        s1.append(5);
        show(s1.getHead());

        Node[] prev = new Node[1];
        prev[0] = null;
        Node pivot = qsPartition(s1.getHead(), s1.getTail(), prev);
        System.out.println("pivot=["+pivot.data+"]");
        System.out.println("================");
        show(s1.getHead());
        System.out.println("end test1()================");
    }
    public static void swap(Node first, Node second)
    {
        int tmp = first.data;
        first.data = second.data;
        second.data = tmp;
    }
    public static void qsLinkedList(Node head, Node tail, Node[] prev)
    {
        Node h = head;
        Node t = tail;
        prev[0] = null;
        if(h == t)
            return;
        Node pivot = qsPartition(h, t, prev); 
        {
            if(pivot != null)
                System.out.println("pivot["+pivot.data+"]");
            if(prev[0] != null)
                System.out.println("prev["+prev[0].data+"]");
            if(h != null)
                System.out.println("h["+h.data+"]");
            if(t != null)
                System.out.println("t["+t.data+"]");
            System.out.println("-----------------------");
            
            if(h != null && prev[0] != null)
                qsLinkedList(h, prev[0], prev); 
            if(pivot.next != null && t != null)
                qsLinkedList(pivot.next, t, prev);
        }
    }
    public static Node qsPartition(Node head, Node tail, Node[] prev)
    {
        Node curr = head;
        Node big = curr;
        Node pivot = tail;
        prev[0] = null;
        if(head == tail)
            return pivot;    
        while(curr != null && curr != tail)
        {
            if(curr.data < pivot.data)
            {
                swap(curr, big);
                prev[0] = big;
                System.out.println("prev{"+prev[0].data+"}");
                big = big.next;
            }                
            curr = curr.next;
        }
        if(big != null)
            swap(pivot, big);
        return big;
    }
    public static Node partition(Node head)
    {
        Node mnode = median(head);
        if(mnode != null)
        {
            Node ret = mnode.next;
            mnode.next = null;
            return ret;
        }
        else
            return mnode;
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
    public static int[] merge(int[] arr1, int[] arr2)
    {
        int[] arr = null; 
        if(arr1 == null)
            return arr2;
        else if(arr2 == null)
            return arr1;
        else 
        {
            int len1 = arr1.length;
            int len2 = arr2.length;
            arr = new int[len1+len2];
            int inx1 = 0;
            int inx2 = 0;
            int k=0;

            while(inx1 < len1 || inx2 < len2)
            {
                if(inx1 >= len1)
                {
                    arr[k] = arr1[inx2];
                    inx2++;
                }
                else if(inx2 >= len2)
                {
                    arr[k] = arr2[inx1];
                    inx1++;
                }
                else
                {
                    if(arr1[inx1] < arr2[inx2])
                    {
                        arr[k] = arr1[inx1];
                        inx1++;
                    }
                    else
                    {
                        arr[k] = arr2[inx2];
                        inx2++;
                    }
                }
                k++;
            }
        }
        return arr;
    }
    public static Node mergeList(Node s1, Node s2)
    {
        Node curr = null;
        Node head = curr;
        while( s1 != null || s2 != null)
        {
            if(s1 == null)
            {
                if(curr == null)
                   head = curr = s2;
                else
                {
                    curr.next = s2;
                    curr = curr.next;
                }
                s2 = s2.next;
            }
            else if(s2 == null)
            {
                if(curr == null)
                    head = curr = s1;
                else
                {
                    curr.next = s1;
                    curr = curr.next;
                }
                s1 = s1.next;
            }
            else
            {
                if(s1.data < s2.data)
                {
                    if(curr == null)
                        head = curr = s1;
                    else
                    {
                        curr.next = s1;
                        curr = curr.next;
                    }
                    s1 = s1.next;
                }
                else
                {
                    if( curr == null)
                        head = curr = s2;
                    else
                    {
                        curr.next = s2;
                        curr = curr.next;
                    }
                    s2 = s2.next;
                }
            }
        }
        return head;
    }
}
