import java.io.*;
import java.lang.String;
import java.util.*;

class Node
{
	public Node left;
	public Node right;
	public int data;
	boolean visited;
	public Node(int n)
	{ data = n; left = null; right = null; visited=false;}
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
class BoundryBinaryTree 
{

	public static Node prev = null;
	public static void main(String args[])
	{
		BST b1 = new BST();
		b1.Insert(50);
        
		b1.Insert(39);
		b1.Insert(18);
		b1.Insert(35);
		b1.Insert(36);
		b1.Insert(41);
		b1.Insert(43);
        
        b1.Insert(51);
		b1.Insert(91);
		b1.Insert(76);
		b1.Insert(60);
		b1.Insert(99);
		b1.Insert(59);
		b1.Insert(58);

		
        
        System.out.println();
        PrintBoundry(b1.getRoot());
        System.out.println();
        Node right = null;
        //InorderLeftLeafNode(b1.getRoot(), right); 
        System.out.println();
        PrintBoundryWithInorder(b1.getRoot());
	}
	
    //Initialize right = null
    static boolean leaf = false;
    public static void InorderLeftLeafNode(Node curr)
    {
        if(curr != null)
        {
            if(!leaf)
                System.out.print("{" + curr.data + "}");
            if(curr.left == null && curr.right == null)
            {
                if(leaf)
                    System.out.print("[" + curr.data + "]");
                leaf = true;
            }
            InorderLeftLeafNode(curr.left);
            InorderLeftLeafNode(curr.right);
        }
    }
    public static void PrintBoundryWithInorder(Node curr)
    {
        InorderLeftLeafNode(curr);
        if(curr != null)
        {
            Node right = curr.right;
            Stack<Node> stack = new Stack<Node>();
            while(right != null)
            {
                if(right.left != null || right.right != null)
                {
                    stack.push(right);
                    //System.out.print("[" + right.data + "]");
                }
                right = right.right;
            }
            while(!stack.empty())
            {
                System.out.print("[" + stack.pop().data + "]");
            }
        }
            

    }
    public static void PrintBoundry(Node curr)
    {
        Stack<Node> st = new Stack<Node>();
        Set<Integer> hashset = new HashSet<Integer>();
        boolean first = false;
        Node root = curr;
        while(curr != null || !st.empty())
        {
            if(curr != null)
            {
                if(!first)
                {
                    System.out.println("[" + curr.data + "]");
                    hashset.add(curr.data);
                }
                st.push(curr);
                curr = curr.left;
            }
            else
            {
                if(!first)
                    first = true;
                Node node = st.pop();
                if(node.left == null && node.right == null)
                {
                    if(!hashset.contains(node.data))
                    {
                        System.out.println("[" + node.data + "]");
                        hashset.add(node.data);
                    }
                }
                curr = node.right;
            }
        }
        //Print out the nodes in the right side of the tree
        if(root != null)
        {
            Stack<Node> stack = new Stack<Node>();
            Node right = root.right;
            while(right != null)
            {
                if(!hashset.contains(right.data))
                {
                    hashset.add(right.data);
                    stack.push(right);
                }
                right = right.right;
            }
            while(!stack.empty())
            {
                System.out.println("[" + stack.pop().data + "]");
            }
        }
    }

    public static void PostOrder(Node r)
    {
        if( r != null)
        {
            PostOrder(r.left);
            PostOrder(r.right);
            System.out.println("normal[" + r.data + "]");
        }
    }

    public static void PostorderSimple(Node root)
    {
        if(root != null)
        {
            Stack<List<Node>> st = new Stack<List<Node>>();
            
            while(root != null || !st.empty())
            {
                if(root != null)
                {
                    List<Node> list = new LinkedList<Node>();
                    list.add(0, root);
                    if(root.left != null)
                        list.add(1, root.left);
                    if(root.right != null)
                        list.add(2, root.right);

                    root = root.left;
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
