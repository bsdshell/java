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
class GeneBinaryTree
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
		b1.Insert(20);
		b1.Insert(18);

		Node r = b1.getRoot();

		System.out.println("digraph G{");
        int level = 0;
        Inorder(r, level);
		System.out.println("}");
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
}
