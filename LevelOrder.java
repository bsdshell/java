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
	public void Inorder(Node cur)
	{
		if(cur != null)
		{
			Inorder(cur.left);
			System.out.print(cur.data + " ");
			Inorder(cur.right);
		}
	}
	public boolean Find(int n)
	{
		Node cur = root;
		boolean ret = false;
		if(cur != null)
		{
			if(n < cur.data)
				cur = cur.left;
			else if(n > cur.data)
				cur = cur.right;
			else
				ret = true;
		}
		return ret;
	}
	public boolean findSum(Node r, int n)
	{
		boolean ret = false;
		if(r == null)
		{ 
			if(n == 0)
				ret = true;
		}
		else if(r != null)
		{
			boolean bl = findSum(r.left, n - r.data);
			boolean br = findSum(r.right, n - r.data);
			ret = (bl || br);
		}
		return ret;
	}

    
    // leve order levelorder
	public void LevelOrder()
	{
		Node cur = root;
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		q1.offer(cur);
		while(q1.peek() != null || q2.peek() != null)
		{
			while(q1.peek() != null)
			{
				Node top = q1.poll();
				System.out.print(top.data + " ");
				if(top.left != null)
					q2.offer(top.left);
				if(top.right != null)
					q2.offer(top.right);
			}
			System.out.println();
			while(q2.peek() != null)
			{
				Node top = q2.poll();
				
				System.out.print(top.data + " ");
				if(top.left != null)
					q1.offer(top.left);
				if(top.right != null)
					q1.offer(top.right);
			}
			System.out.println();
		}
	}
	public Node getRoot()
	{ return root;}
}
class LevelOrder 
{

	public static Node prev = null;
	public static void main(String args[])
	{
		BST b1 = new BST();

		b1.Insert(15);
		b1.Insert(12);
		b1.Insert(7);
		b1.Insert(17);
		b1.Insert(19);
		b1.Insert(130);
		b1.Insert(16);
		b1.Insert(10);
		b1.Insert(1);
		b1.Insert(11);

		Node r = b1.getRoot();
        Queue<Node> q = new LinkedList<Node>();
        q.offer(b1.getRoot());
        LevelOrderRecursion(q);
		System.out.println("");
        LevelOrder(b1.getRoot());

	}

    //level order recursion levelorder recursion
    public static void LevelOrderRecursion(Queue<Node> q)
    {
        Queue<Node> q1 = new LinkedList<Node>();       
        while(q.peek() != null)
        {
            Node node = q.poll();
            System.out.print("["+node.data+"]");
            if(node.left != null)
                q1.offer(node.left);
            if(node.right != null)
                q1.offer(node.right);
        }
        System.out.println();
        if(q1.peek() != null)
            LevelOrderRecursion(q1);
    }

    //level order with two queues
    public static void LevelOrder(Node cur)
	{
		Queue<Node> Q1 = new LinkedList<Node>();
		Queue<Node> Q2 = new LinkedList<Node>();
		Q1.offer(cur);
		while(Q1.peek() != null || Q2.peek() != null)
		{
			while(Q1.peek() != null)
			{
				Node top = Q1.poll();
				System.out.print(top.data + " ");
				if(top.left != null)
					Q2.offer(top.left);
				if(top.right != null)
					Q2.offer(top.right);
			}
			System.out.println();
			while(Q2.peek() != null)
			{
				Node top = Q2.poll();
				
				System.out.print(top.data + " ");
				if(top.left != null)
					Q1.offer(top.left);
				if(top.right != null)
					Q1.offer(top.right);
			}
			System.out.println();
		}
	}

}
