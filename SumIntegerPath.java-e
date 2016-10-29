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
class SumIntegerPath 
{

	public static void main(String args[])
	{
        Test1();
	}
    public static void Test1()
    {
        BST b1 = new BST();
		b1.Insert(6);
        
		b1.Insert(3);
		b1.Insert(1);
        
		b1.Insert(7);
		b1.Insert(5);
		b1.Insert(2);
        
        int[] A = new int[10];
        int depth = 0;
        int sum = PathInteger(b1.getRoot(), depth, A);
        System.out.println("sum=["+sum+"]");
    }

    //Find the sum of all paths which form all the integer
    public static int PathInteger(Node curr, int depth, int[] A)
    {
        int sum = 0;
        if(curr != null)
        {
            A[depth]= curr.data;
            int lsub = PathInteger(curr.left, depth+1, A);
            int rsub = PathInteger(curr.right, depth+1, A);
            int s = 0;
            if(curr.left == null && curr.right == null)
            {
                for(int i=0; i<=depth; i++)
                {
                   s += A[i]*Math.pow(10, depth-i); 
                }
            }
            sum += lsub + rsub + s;
        }
        return sum;
    }
}
