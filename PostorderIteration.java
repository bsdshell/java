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
class PostorderIteration 
{

	public static Node prev = null;
	public static void main(String args[])
	{
		BST b1 = new BST();


		b1.Insert(14);
		b1.Insert(15);
		b1.Insert(12);
		b1.Insert(17);
		b1.Insert(19);
        
		b1.Insert(130);
		b1.Insert(16);
		b1.Insert(10);
        
        PostOrder(b1.getRoot());
        System.out.println();
        Node cloneRoot = CloneTree(b1.getRoot());
		PostorderIteration(b1.getRoot());
        System.out.println();

		//PostorderDFS(cloneRoot);
		PostorderTwoStacks(cloneRoot);
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
				{ 
                    Node no = st.pop();
					System.out.println("no.data=" + no.data);
					cur = no.right;
				}
			}
		}
	}

    public static void preorderIteration(Node r)
    {
		Stack<Node> st = new Stack<Node>();
        Node curr = r;
        if( curr != null)
        {
            while(curr != null || !st.empty())
            {
                if(curr != null)
                {
					System.out.println("["+curr.data+"]");
                    st.push(curr);
                    curr = curr.left;
                }
                else
                {
                    Node node = st.pop();
                    curr = node.right;
                }
            }
        }
        curr = r;
    }

    //postorder recursion
    public static void PostOrder(Node r)
    {
        if( r != null)
        {
            PostOrder(r.left);
            PostOrder(r.right);
            System.out.println("[" + r.data + "]");
        }
    }

    //postorder with iteration 
    //postorder with loop
	public static void PostorderIteration(Node r)
	{
		Stack<Node> st = new Stack<Node>();
        Node tmp = r;
		Node cur = r;
		
		while(!st.empty() || cur != null) 
		{
			if( cur != null)
			{ 
                st.push(cur);
				cur = cur.left;
			}
			else
			{
				Node pop = st.pop();
				if(pop.left == null && pop.right == null)
					System.out.println("p="+pop.data);
				else if(pop.right != null && pop.visited == false)
				{
					cur = pop.right;
					pop.visited = true;
					st.push(pop);
				}
				else if(pop.right != null && pop.visited == true)
					System.out.println("p="+pop.data);
			}
		}
	}

    //Postorder with two stacks
    public static void PostorderTwoStacks(Node curr)
    {
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();
        if(curr != null)
        {
            st1.push(curr);
            while(!st1.empty())
            {
                Node node = st1.pop();
                st2.push(node);
                if(node.left != null)
                    st1.push(node.left);
                if(node.right != null)
                    st1.push(node.right);
            }
            while(!st2.empty())
            {
                Node node = st2.pop();
                System.out.println("Two Stacks Iteration["+node.data+"]");    
            }
        }
    }
    //clone a binary tree
    public static Node CloneTree(Node root)
    {
        if(root != null)
        {
            Node left = CloneTree(root.left);
            Node right = CloneTree(root.right);
            Node parent = new Node(root.data); 
            parent.left = left;
            parent.right = right;
            return parent;
        }
        return null;
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
    
    public static void PostorderDFS(Node r)
    {
        if( r != null)
        {
            Stack<Node> st= new Stack<Node>();    
            Map<Node, List<Node>> map = new HashMap<Node, List<Node>>();
            st.push(r);
            while(!st.empty())
            {
                Node top = st.peek();
                if((top.left == null && top.right == null) || top.visited)
                {
                    Node node = st.pop();
                    System.out.println("Iteration["+node.data+"]");    
                }
                else if((top.left != null || top.right != null) && !top.visited) 
                {
                    List<Node> list = new LinkedList<Node>();
                    if(!map.containsKey(top))
                    {
                        if(top.left != null)
                            list.add(top.left);
                        if(top.right != null)
                            list.add(top.right); 
                        map.put(top, list);
                    }
                    else
                    {
                        list = map.get(top);
                    }
                    if(list.size() > 0)
                    {
                        Node node = list.get(0);
                        st.push(node);
                        list.remove(0);
                        if(list.size() == 0)
                        {
                            top.visited = true;
                            map.remove(top);
                        }
                    }
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
