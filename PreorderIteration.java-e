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
class PreorderIteration
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
		
		
		PreorderIteration(b1.getRoot());
		System.out.println();
		Inorder(b1.getRoot());
	}
	//in order traversal using iteration
	public static void InorderIteration(Node r)
	{
		Stack<Node> st = new Stack<Node>();
		Node cur = r;

		if( cur != null)
		{ 
			while(!st.empty() || cur != null)
			{
				if(cur != null)
				{
					st.push(cur);
					cur = cur.left;
				}
				else 
				{ Node no = st.pop();
					System.out.println("no.data=" + no.data);
					cur = no.right;
				}
			}
		}
	}

	public static void PreorderIteration(Node r)
	{
		Stack<Node> st = new Stack<Node>();
		Node cur = r;

		if( cur != null)
		{ 
			while(!st.empty() || cur != null)
			{
				if(cur != null)
				{
					System.out.println("cur.data=" + cur.data);
					st.push(cur);
					cur = cur.left;
				}
				else 
				{ Node no = st.pop();
					cur = no.right;
				}
			}
		}
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
