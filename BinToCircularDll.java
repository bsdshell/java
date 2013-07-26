import java.io.*;
import java.lang.String;
import java.util.*;

class Node
{
	public Node left;
	public Node right;
	public int data;
	public Node(int n)
	{ data = n; left = null; right = null; }
	public Node getLeft()
	{ return left; }
	public Node getRight()
	{ return right; }
	public void setLeft(Node l)
	{ left = l;}
	public void setRight(Node r)
	{ right = r;}
}

class BST
{
	Node root;
	public BST()
	{ root = null;};
	public void Insert(int n)
	{
		if(root == null)
		{ root = new Node(n); }
		else
		{ 
			Node cur = root;
			boolean end = false;
			while(cur != null && !end)
			{
				if(n < cur.data)
				{ 
					if(cur.left == null)
					{ cur.left = new Node(n); end = true; }
					else 
						cur = cur.left;
				}
				else 
				{
					if(cur.right == null)
					{ cur.right = new Node(n); end = true; }
					else
						cur = cur.right;
				}
			}
		}
	}
	public Node getRoot()
	{ return root;}
}
class BinToCircularDll 
{

	public static void main(String args[])
	{
		BST b1 = new BST();


		b1.Insert(15);
		b1.Insert(12);
		b1.Insert(14);
		b1.Insert(17);

		b1.Insert(19);
		b1.Insert(130);
		b1.Insert(16);
		b1.Insert(10);
        
		Node r = b1.getRoot();
		//Node t = BinToDLL(r);
        Inorder(r);
        System.out.println("");
        BinToCircularDll(r);
        int k=0;
        if(head != null)
        {
            Node curr = head;
            Node right = head.right;
            if(curr == right) //one node
                System.out.print(curr.data + " ");
            else
            {
                System.out.print(head.data + " ");
                while(head != right)
                {
                    System.out.print(right.data + " ");
                    right = right.right;
                }
            }
        }
	}
    static Node head = null;
    static Node prev = null;
    public static void BinToCircularDll(Node curr)
    {
        if(curr != null)
        {
            BinToCircularDll(curr.left);
            if(prev == null)
                head = curr;
            else
            {
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
            Node right = curr.right;
            if(head != null)
            {
                head.left = curr;
                curr.right = head;
            }
            BinToCircularDll(right);
        }
    }
    public static void Inorder(Node r)
    {
        if(r != null)
        {
            Inorder(r.left);
            System.out.print("["+r.data+"]");
            Inorder(r.right);
        }
    }
	public static Node BinToDLL(Node r)
	{
		Node h=null, t=null, cur=null;
		Queue<Node> queue = new LinkedList<Node>();
		if(r != null)
		{
			queue.offer(r);
			while(queue.peek() != null)
			{
				Node no = queue.remove();
				if(no != null && no.left != null)
				{queue.offer(no.left); no.left=null;}

				if(no != null && no.right!= null)
				{queue.offer(no.right); no.right=null;}

				if(h == null)
				{ h = cur = no; }
				else 
				{ no.left = cur;
					cur.right = no;
					cur = cur.right;
				}
			}
			t = cur;
		}
		return t;
	}
}
