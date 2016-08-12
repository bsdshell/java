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

class constructNLTreefromPre 
{
	public static void main(String args[])
	{
		char[] Arr = {'N', 'N','L','L','N','L','L'};
		int[] inx={0};
		Node myroot= constructTree(Arr, inx);
		Inorder(myroot);
	}
	
	public static Node constructTree(char[] Arr, int[] inx)
	{
		Node root= new Node(Arr[inx[0]]);
		if(Arr[inx[0]] == 'L')
			;
		else 
		{
			inx[0]++;
			root.left = constructTree(Arr, inx);	
			inx[0]++;
			root.right = constructTree(Arr, inx);
		}
		return root;
	}
	
	
	public static void Inorder(Node root)
	{
		if( root != null)
		{ Inorder(root.left);
			System.out.println((char)root.data);
			Inorder(root.right);
		}
	}
	public static void PreOrder(Node root)
	{
		if(root != null)
		{
			System.out.println("pre=" + (char)root.data);
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}
}
