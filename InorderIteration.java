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
			Node curr = root;
			boolean end = false;
			while(curr != null && !end)
			{
				if(n < curr.data)
				{ 
					if(curr.left == null)
					{ curr.left = new Node(n); end = true; }
					else 
						curr = curr.left;
				}
				else 
				{
					if(curr.right == null)
					{ curr.right = new Node(n); end = true; }
					else
						curr = curr.right;
				}
			}
		}
	}
	public void Inorder(Node curr)
	{
		if(curr != null)
		{
			Inorder(curr.left);
			System.out.print(curr.data + " ");
			Inorder(curr.right);
		}
	}
	public Node getRoot()
	{ return root;}
}
class InorderIteration
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
		
		PostorderIteration(b1.getRoot());
		System.out.println();
		Postorder(b1.getRoot());
        //Inorder(b1.getRoot());
	}
	//in order traversal using iteration
	public static void InorderIteration(Node curr)
	{
		Stack<Node> st = new Stack<Node>();
        while(curr != null || !st.isEmpty())
        {
            if(curr != null)
            {
                st.push(curr);
                curr = curr.left;
            }
            else 
            { 
                Node no = st.pop();
                System.out.println("no.data=" + no.data);
                curr = no.right;
            }
        }
	}
	
    public static void PostorderIteration(Node curr)
    {
        /*
        Stack<Node> st = new Stack<Node>();
        Node prev = null;
        while(curr != null || !st.isEmpty())
        {
            if(curr != null)
            {
                st.push(curr);
                prev = curr.left;
                curr = curr.left;
            }
            else
            {
                curr = st.pop();
                if(prev == curr.right)
                    System.out.println("curr.data=" + curr.data);
                prev = curr.right;
                curr = curr.right;
            }
        }
        */
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
    public static void Postorder(Node myroot)
	{
		if(myroot != null)
		{
			System.out.println("post=" + myroot.data);
			Postorder(myroot.left);
			Postorder(myroot.right);
		}
	}
}
