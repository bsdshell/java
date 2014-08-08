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
	public Node getRoot()
	{ return root;}
}

//Find the node from the Binary Tree and return the path from the current node
//to root
//The algorithm is similar to isBST() and use inorder traveral to walk through
//all the nodes, once the node is found, then recursion is terminated 
class PathToKBinarySearch 
{

	public static void main(String args[])
	{
		BST b1 = new BST();
		b1.Insert(10);
		b1.Insert(5);
		b1.Insert(15);
        
		b1.Insert(17);
		b1.Insert(199);
		b1.Insert(16);
        
        Node[] first = new Node[1];
        Node[] second = new Node[1];
        first[0] = null;
        second[0] = null;
        //swap(5, 15, b1.getRoot(), first, second);
        
        inorder(b1.getRoot());
		
        System.out.println("");
        PathToK(b1.getRoot(), 199);
	}
    public static void swap(int m, int n, Node root, Node[] first, Node[] second)
    {
        if(root != null)
        {
            swap(m, n, root.left, first, second);
            if(root.data == m)
            {
                first[0] = root;
            }
            else if(root.data == n)
            {
                second[0] = root;
            }
            if( first[0] != null && second[0] != null)
            {
                int tmp = first[0].data;
                first[0].data = second[0].data;
                second[0].data = tmp;
                first[0] = null;
                second[0] = null;
            }
            swap(m, n, root.right, first, second);
        }
    }

    public static void inorder(Node node)
    {
        if(node != null)
        {
            inorder(node.left);
		        System.out.println(node.data);
            inorder(node.right);
        }
    }

    public static boolean PathToK(Node node, int k)
    {
        if(node != null)
        {
            if(PathToK(node.left, k))
            {
		        System.out.println(node.data);
                return true;
            }
            if(node.data == k)
            {
		        System.out.println(node.data);
                return true;
            }
            if(PathToK(node.right, k))
            {
		        System.out.println(node.data);
                return true;
            }
        }
        return false;
    }
}
