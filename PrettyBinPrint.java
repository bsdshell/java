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
	

	public void LevelOrder()
	{
		Node cur = root;
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
	public Node getRoot()
	{ return root;}
}
class PrettyBinPrint 
{

	public static Node prev = null;
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
		b1.Insert(20);
		b1.Insert(18);

		int[] Arr = new int[100];
		int len=0;
		Node r = b1.getRoot();

		b1.LevelOrder();

		System.out.println(contain(r, 15));
		System.out.println();
        int indent=1;
        prettyPrint(r, indent);
		System.out.println();

		System.out.println("digraph G{");
        int level = 0;
        Inorder(r, level);
		System.out.println("}");
	}
    public static void prettyPrint(Node r, int indent)
    {
        if( r != null)
        {
            System.out.print("["+r.data+"]");
            if(r.right != null)
                System.out.print("[  ]");

            prettyPrint(r.right, indent+1);

            if(r.left != null)
            {
                System.out.println();
                for(int i=0; i<indent; i++)
                {
                    System.out.print("[  ][  ]");
                }
            }

            prettyPrint(r.left, indent+1);
        }
    }
	public static boolean isBST(Node r)
	{

		if(r == null)
			return true;
		else
		{
			if(!isBST(r.left))
				return false;
			if(prev != null && prev.data >= r.data)
				return false;
			prev = r;
			if(!isBST(r.right))
				return false;
		}
		return true;
	}
	//init len = 0
	public static void printAllPath(Node r, int[] Arr, int len)
	{
		if( r != null && Arr != null)
		{
			Arr[len] = r.data;
			if( r.left == null && r.right == null)
			{
				for(int i=0; i<len+1; i++)
					System.out.print(Arr[i]+" ");
				System.out.println();
			}
			else
			{
				printAllPath(r.left, Arr, len+1);
				printAllPath(r.right, Arr, len+1);
			}
		}
	}
	public static int MaxDepth(Node r)
	{
		if( r != null)
		{
			int nl = MaxDepth(r.left);
			int nr = MaxDepth(r.right);

			return (nl>nr?nl:nr)+1;
		}
		return 0;
	}
	public static boolean equalBinaryTree(Node r1, Node r2)
	{
		if(r1==null && r2==null)
			return true;
		else if(r1 != null && r2 != null)
		{
			if(r1.data != r2.data)
					return false;
			if(!equalBinaryTree(r1.left, r2.left)) 
					return false;
			if(!equalBinaryTree(r1.right, r2.right))
					return false;
		}
		else 
			return false;
		return true;
	}
	public static void Inorder(Node root, int level) {
		if(root != null) {
			//System.out.println("" + root.data + "[label=" + root.data +"];");
			System.out.println(root.data);
            if(root.left != null){
			    System.out.print("" + root.data + "->");
            }
			Inorder(root.left, level+1);

            if(root.right != null){
			    System.out.print("" + root.data + "->");
            }
			Inorder(root.right, level+1);
		}
	}
	public static boolean contain(Node r, int value)
	{
		if( r != null)
		{
			if(contain(r.left, value))
				return true;
			if(r.data == value)
				return true;
			if(contain(r.right, value))
				return true;
		}
		return false;
	}
}
