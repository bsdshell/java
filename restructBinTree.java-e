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

class  restructBinTree
{

	public static Node prev = null;
	public static void main(String args[])
	{
		BST b1 = new BST();

		b1.Insert(10);
		b1.Insert(5);
		
		b1.Insert(1);
		b1.Insert(7);
		b1.Insert(15);
		b1.Insert(12);
		b1.Insert(20);
		int[] Arr = new int[100];
		try
		{
			FileWriter fstream = new FileWriter("bin1.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			writeBinTree(b1.getRoot(), out);
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("error" + e.getMessage());
		}

		String[] strArr=null;
		int[] inx=null;
		try
		{
		  BufferedReader in = new BufferedReader(new FileReader("/home/aron/try/bin1.txt"));	
			if(in == null)
			{
				System.out.println("in="+in);
			}
			else
			{
				System.out.println("out?");
			}
			String str = in.readLine();
			in.close();
			System.out.println("str="+str);

			strArr = str.split(" ");
			for(int i=0; i<strArr.length; i++)
				System.out.println(strArr[i]);
			inx = new int[1];
			inx[0] = 0;
			
			
		}
		catch(Exception e)
		{
			System.err.println("Error" + e.getMessage());
		}

		Node myroot = readBinTree(strArr, inx);
		if(myroot == null)
		{
			System.out.println("myroot="+myroot);
		}
		Inorder(myroot);

		//b.Inorder(r);

		/*			
		System.out.println();
		b.LevelOrder();
		System.out.println();

		System.out.println(equalBinaryTree(b.getRoot(), b1.getRoot()));
		System.out.println(isBST(b1.getRoot()));
		*/
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
	
	public static void Inorder(Node root)
	{
		if(root != null)
		{
			Inorder(root.left);
			System.out.println("data=" + root.data);
			Inorder(root.right);
		}
	}
	public static void writeBinTree(Node r, BufferedWriter out)
	{
		try
		{
			if( r != null)
			{ 
				out.write(r.data+" ");		
				writeBinTree(r.left, out);
				writeBinTree(r.right, out);
			}
			else 
				out.write("#"+" ");		
		}
		catch(Exception e)
		{
		}
	}
	public static Node readBinTree(String[] Arr, int[] i)
	{
		Node root = null;

		if(Arr != null)
		{ int len = Arr.length;	
			if(i[0]<len)
			{
				if(!Arr[i[0]].equals("#"))
				{
					root = new Node(Integer.parseInt(Arr[i[0]]));
					i[0]++;
					root.left = readBinTree(Arr, i);							
					i[0]++;
					root.right= readBinTree(Arr, i);							
				}
			}
		}
		return root;
	}
}
