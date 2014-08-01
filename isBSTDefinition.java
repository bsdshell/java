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
class isBST 
{

	public static void main(String args[])
	{
		BST b1 = new BST();

		b1.Insert(10);
		//b1.Insert(5);
		//b1.Insert(15);
        
        inorder(b1.getRoot());
        /*
		b1.Insert(17);
		b1.Insert(199);
		b1.Insert(16);
		b1.Insert(10);
        */

        Node[] first = new Node[1];
        Node[] second = new Node[1];
        first[0] = null;
        second[0] = null;
        swap(5, 15, b1.getRoot(), first, second);
        
        inorder(b1.getRoot());
		
		System.out.println(isBSTDef(b1.getRoot()));
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
            if(root.data == n)
            {
                second[0] = root;
            }
            if( first[0] != null && second[0] != null)
            {
                int tmp = first[0].data;
                first[0].data = second[0].data;
                second[0].data = tmp;
            }
            swap(m, n, root.right, first, second);
        }
    }

    //precondition node != null
    public static int max(Node node)
    {
        if(node.right != null)
            return max(node.right);
        else 
            return node.data;
    }

    //precondition node != null
    public static int min(Node node)
    {
        if(node.left != null)
            return min(node.left);
        else 
            return node.data;
    }

    //BST definition
    // 1) left subtree is BST
    // 2) right subtree is BST
    // 3) max(left substree) < parent.data && min(right subtree) > parent.data
    public static boolean isBSTDef(Node node)
    {
        if(node == null)
            return true;
        else
        {
            if(!isBSTDef(node.left))
                return false;
            if(!isBSTDef(node.right))
                return false;
            if( !((node.left == null || max(node.left) < node.data) &&
                    (node.right == null || min(node.right) > node.data)))
                return false;
            return true;
        }
    }
}
