import java.io.*;
import java.lang.String;
import java.util.*;

class Node
{
	public Node left;
	public Node right;
    public Node parent;
	public int data;
    boolean isVisited;
	public Node(int n)
	{ data = n; left = right = parent = null; isVisited = false;}
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
					{ 
                        cur.left = new Node(n); end = true; 
                        cur.left.parent = cur;
                    }
					else 
						cur = cur.left;
				}
				else 
				{
					if(cur.right == null)
					{ 
                        cur.right = new Node(n); end = true; 
                        cur.right.parent = cur;
                    }
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
class FindKthNeighbour 
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

		Node r = b1.getRoot();
		Inorder(r);
        //
		int[] Arr = new int[100];
		int len=0;
        Node initNode = r;

        List<Node> list = new LinkedList<Node>();
        Node randNode = GetRandomNode(r, initNode, list); 
        System.out.println("randNode["+randNode.data+"]");
        PrintAllKthNeighbour(randNode, 3);
	}
	
    public static Node GetRandomNode(Node node, Node initNode, List<Node> list)
    {
        if(node != null)
        {
            GetRandomNode(node.left, initNode, list);
            list.add(node);
            GetRandomNode(node.right, initNode, list);
            Random rand = new Random();
            if(initNode == node)
            {
                int index = rand.nextInt(list.size()); 
		        System.out.println("rand=["+index+"] list=["+list.size()+"]");
                return list.get(index);
            }
        }
        return null;
    }
    public static void PrintAllKthNeighbour(Node node, int k)
    {
        if(node != null && !node.isVisited)
        {
            node.isVisited = true;
            if(k == 0)
            {
		        System.out.println("Neighbour["+node.data+"]");
            }
            else
            {
                k--;
                PrintAllKthNeighbour(node.left, k);
                PrintAllKthNeighbour(node.right, k);
                PrintAllKthNeighbour(node.parent, k);
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
