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
	
	
	public Node getRoot()
	{ return root;}
}
class BinToDLLRecur 
{

	public static Node prev = null;
	public static void main(String args[])
	{
		BST b1 = new BST();
		b1.Insert(1);
		b1.Insert(2);
		b1.Insert(3);
		b1.Insert(4);
		b1.Insert(5);
		b1.Insert(6);
		b1.Insert(7);
		b1.Insert(8);
		b1.Inorder(b1.getRoot());

		Node r = BinToDLL(b1.getRoot());
		boolean bool = isCircularList(r);
		System.out.println("bool=" + bool);
		//Inorder(r);
		

	}
	public static boolean isCircularList(Node r)
	{
		boolean ret = false;
		if(r != null)
		{
			Node cur = r;
			Node next = cur.right;

			while(next != null && cur != next)
			{
				System.out.print("cur="+cur.data + " ");
				if(cur != null)
				cur = cur.right;
				
				next = next.right;
				if(next != null)
					next = next.right;
			}
			if(cur == next)
			{
				System.out.print("cur="+cur.data + " ");
				ret = true;
			}
		}
		return ret;
	}
	static Node pre=null;
	static Node head=null;
	static Node tail=null;
	public static Node BinToDLL(Node r)
	{
		if(r != null)
		{
			BinToDLL(r.left);
			
			r.left = pre;
			if(pre != null)
			{ pre.right= r;}
			else
				head = r;
			
			Node right = r.right;
			head.left = r;
			r.right = head;
			tail = r;
			pre = r;

			BinToDLL(right);
		}
		return head;
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
