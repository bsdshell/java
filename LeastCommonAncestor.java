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
class LeastCommonAncestor 
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
		Node lca = LCABinTree(r, 12, 15);
		System.out.println("lca.data=" + lca.data);

	}
	public static Node LCA(Node r, int value1, int value2)
	{
		Node ret=null;
		if(r != null)
		{
			if((r.left != null && (value1 == r.left.data || value2 == r.left.data)) ||
				 (r.right != null && (value1 == r.right.data || value2 == r.right.data)))
				ret = r;
			else if(value1 < r.data && value2 < r.data)
				ret=LCA(r.left, value1, value2);
			else if(value1 > r.data && value2 > r.data)
				ret=LCA(r.right, value1, value2);
			else 
				ret = r;
		}
		return ret;
	}
	public static Node LCA2(Node r, Node n1, Node n2)
	{
		Node ret=null;
		if(r != null && n1 != null && n2 != null)
		{
			if( r.left != null && (r.left.data == n1.data || r.left.data == n2.data) ||
					r.right != null && (r.right.data == n1.data || r.right.data == n2.data))
				ret = r;	
			else if(n1.data < r.data && n2.data < r.data)
				ret=LCA2(r.left, n1, n2);
			else if(n1.data > r.data && n2.data > r.data)
				ret=LCA2(r.right, n1, n2);
			else 
				ret=r;
		}
		return ret;
	}
	public static Node LCA3(Node r, int value1, int value2)
	{
		Node ret = null;
		Node par = null;
		while(r != null && ret == null)
		{
			if(value1 < r.data && value2 < r.data)
			{ par = r; r = r.left;}
			else if(value1 > r.data && value2 > r.data)
			{ par = r; r = r.right; }
			else 
			{
				if(value1 == r.data || value2 == r.data)
						ret = par;
				else
						ret = r;
			}
		}
		return ret;
	}
	//LCA for Binary Tree
	public static Node LCABinTree(Node r, int value1, int value2)
	{
		if( r != null)
		{
			if( r.data == value1 || r.data == value2)
				return r;
			Node nl = LCABinTree(r.left, value1, value2);
			Node nr = LCABinTree(r.right, value1, value2);
			if( nl != null && nr != null)
				return r;
			else if( nl != null)
					return nl;
			else if( nr != null)
					return nr;
						
		}
		return null;
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
}
