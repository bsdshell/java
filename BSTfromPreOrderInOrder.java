import java.io.*;
import java.lang.String;
import java.util.*;

// preorder to inorder
// convert preorder to inorder
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
	public boolean Find(int n)
	{
		Node cur = root;
		boolean ret = false;
		if(cur != null)
		{
			if(n < cur.data)
				cur = cur.left;
			else if(n > cur.data)
				cur = cur.right;
			else
				ret = true;
		}
		return ret;
	}
	public boolean findSum(Node r, int n)
	{
		boolean ret = false;
		if(r == null)
		{ 
			if(n == 0)
				ret = true;
		}
		else if(r != null)
		{
			boolean bl = findSum(r.left, n - r.data);
			boolean br = findSum(r.right, n - r.data);
			ret = (bl || br);
		}
		return ret;
	}
	
	public void LevelOrder()
	{
		Node cur = root;
		Queue<Node> Q1 = new LinkedList<Node>();
		Queue<Node> Q2 = new LinkedList<Node>();
		Q1.offer(cur);
		while(Q1.peek() != null || Q2.peek() != null)
		{
			while(Q1.peek() != null)
			{
				Node top = Q1.poll();
				System.out.print(top.data + " ");
				if(top.left != null)
					Q2.offer(top.left);
				if(top.right != null)
					Q2.offer(top.right);
			}
			System.out.println();
			while(Q2.peek() != null)
			{
				Node top = Q2.poll();
				
				System.out.print(top.data + " ");
				if(top.left != null)
					Q1.offer(top.left);
				if(top.right != null)
					Q1.offer(top.right);
			}
			System.out.println();
		}
	}
	public Node getRoot()
	{ return root;}
}
class BSTfromPreOrderInOrder 
{
	public static void main(String args[])
	{
		int[] pArr = {10, 5, 1, 7, 15, 12, 20};
		int[] iArr = {1, 5, 7, 10, 12, 15, 20};
		
		ArrayList<Node> preArr = new ArrayList<Node>();
		ArrayList<Node> inArr = new ArrayList<Node>();
		for(int i=0; i<pArr.length; i++)
		{
			preArr.add(new Node(pArr[i]));
			inArr.add(new Node(iArr[i]));
		}
		Node root = buildBST(preArr, inArr);
		Inorder(root);

	}
	public static void split(ArrayList<Node> preArr, ArrayList<Node> inArr, ArrayList<Node> preL_tree,ArrayList<Node> preR_tree,ArrayList<Node> inL_tree, ArrayList<Node> inR_tree)
	{
	if(preArr != null && inArr != null && preL_tree != null && preR_tree != null && inL_tree != null && inR_tree != null)
		{
			int prelen = preArr.size(), inlen = inArr.size();	
			if(prelen > 0)
			{
				boolean L = true;
				Node root = preArr.get(0);
				for(int i=0; i<inlen; i++)
				{
					if(L == true && inArr.get(i).data != root.data)
						inL_tree.add(inArr.get(i));
					else if(inArr.get(i).data == root.data)
						L = false;
					else if(L == false && inArr.get(i).data != root.data)
					{
						inR_tree.add(inArr.get(i));
					}
				}
				for(int i=1; i<prelen; i++)
				{
					if(i < (inL_tree.size() + 1))
						preL_tree.add(preArr.get(i));	
					else
						preR_tree.add(preArr.get(i));	
				}
			}
		}
	}	
	public static Node buildBST(ArrayList<Node> preArr, ArrayList<Node> inArr)
	{
		Node parent = null;
		if( preArr != null && inArr != null)
		{
			int prelen = preArr.size(), inlen= inArr.size();
			if(prelen > 0)
			{
				parent = new Node(preArr.get(0).data);
				ArrayList<Node> preL_tree = new ArrayList<Node>();
				ArrayList<Node> preR_tree = new ArrayList<Node>();

				ArrayList<Node> inL_tree = new ArrayList<Node>();
				ArrayList<Node> inR_tree = new ArrayList<Node>();
				split(preArr, inArr, preL_tree, preR_tree, inL_tree, inR_tree);
				parent.left 	= buildBST(preL_tree, inL_tree);
				parent.right 	= buildBST(preR_tree, inR_tree);
				
			}
		}
		return parent;
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
