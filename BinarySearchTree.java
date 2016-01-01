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
    public void OneQueue(Node curr){
        if(curr != null){
            Queue<Node> q = new LinkedList<Node>();       
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
class BinarySearchTree 
{

	public static Node prev = null;
	public static void main(String args[])
	{
		BST b1 = new BST();

		/*
		Random ran = new Random();
		int Num=10;
		int[] Arr = new int[10];
		for(int i=0; i<Num; i++)
			Arr[i] = 0;
		for(int i=0; i<Num; i++)
		{
			int r = ran.nextInt(Num);
			if(Arr[r] == 0)
			{
				System.out.print("[" + r + "]");
				b.Insert(r);
				Arr[r] = 1;
			}
			else
				i--;
		}
		*/

		

		b1.Insert(15);
		b1.Insert(12);
		
		b1.Insert(14);
		b1.Insert(17);
		b1.Insert(19);
		b1.Insert(130);
		b1.Insert(16);
		b1.Insert(10);
		
		
		

		int[] Arr = new int[100];
		int len=0;
		Node r = b1.getRoot();
		//printAllPath(r, Arr, len); 

		b1.LevelOrder();

		System.out.println(contain(r, 15));
		//b.Inorder(r);

		/*			
		System.out.println();
		b.LevelOrder();
		System.out.println();

		System.out.println(equalBinaryTree(b.getRoot(), b1.getRoot()));
		System.out.println(isBST(b1.getRoot()));
		*/
        test1();
        test2();
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
	public static void Inorder(Node root)
	{
		if(root != null)
		{
			Inorder(root.left);
			System.out.println("data=" + root.data);
			Inorder(root.right);
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
    // 10 5 1_ _ 6_ _ 14 11 _
    // 10 _ _
    // 10 5_ _ 12_ _
    // int[] k = new int[1];
	public static Node generateBinaryTree(Node r, String[] list, int[] k) {
        if(k[0] < list.length && list[k[0]] != "_"){
            if(r == null)
                r = new Node(Integer.parseInt(list[k[0]]));
            k[0]++;
            r.left = generateBinaryTree(r.left, list, k);
            k[0]++;
            r.right = generateBinaryTree(r.right, list, k);
            return r;
        }
        return null;
    }
    
    public static void test2()
    {
        System.out.println("test2"); 
        String[] list = {
            "10",
            "8",
            "_",
            "_",
            "12",
            "_",
            "19"
        };
        Node r = null;
        int[] k= new int[1];
        k[0] = 0;
        Node root = generateBinaryTree(r, list, k);
        Inorder(root);
    } 
    public static void test1()
    {
        System.out.println("test1"); 
        String[] list = {
            "10",
            "_",
            "_"
        };
        Node r = null;
        int[] k= new int[1];
        k[0] = 0;
        Node root = generateBinaryTree(r, list, k);
        Inorder(root);
    } 
}
