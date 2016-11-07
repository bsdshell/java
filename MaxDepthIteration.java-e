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
class MaxDepthIteration 
{

	public static Node prev = null;
	public static void main(String args[])
	{
		BST b1 = new BST();


		b1.Insert(10);
		
		b1.Insert(5);
		b1.Insert(1);
		b1.Insert(7);
		b1.Insert(9);
		
		
		
		
		int c = MaxDepthIteration(b1.getRoot());
		System.out.println("c=" + c);
	}
	//in order traversal using iteration
	public static int MaxDepthIteration(Node r)
	{
		Stack<Node> st = new Stack<Node>();
		Node cur = r;

		int max=0;
		int c=0;
		if( cur != null)
		{ 
			while(!st.empty() || cur != null)
			{
				if(cur != null)
				{
					st.push(cur);
					c++;
					if(c>max)
						max=c;
					cur = cur.left;
				}
				else 
				{ Node no = st.pop();
					if(no.right == null) //last traversal node has to be the right node observation from the recursive Inorder traversal 
						c--;
					System.out.println("no.data=" + no.data);
					cur = no.right;
				}
			}
		}
		return max;
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
