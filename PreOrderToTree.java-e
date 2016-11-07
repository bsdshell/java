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
class PreOrderToTree 
{
	public static Node prev = null;
	public static void main(String args[])
	{
		BST b1 = new BST();
		
		b1.Insert(15);
		b1.Insert(12);
		b1.Insert(14);
		b1.Insert(17);
		/*
		b1.Insert(19);
		b1.Insert(130);
		b1.Insert(16);
		b1.Insert(10);
		*/

		Node r = b1.getRoot();
		//PreOrder(r);

		int[] Arr = {10, 1, 12};
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();

		//splitInOrder(Arr, leftArr, rightArr);

		Node myroot= PreOrderToTree(Arr);
		PreOrder(myroot);
	}
	
	public static Node PreOrderToTree(int[] Arr)
	{
		ArrayList<Integer> leftList = new ArrayList<Integer>();
		ArrayList<Integer> rightList = new ArrayList<Integer>();
		Node root=null;
		if(Arr != null && Arr.length > 0)
		{
			root = new Node(splitInOrder(Arr, leftList, rightList));

			int[] leftArr = new int[leftList.size()];
			int[] rightArr = new int[rightList.size()];
			for(int i=0; i<leftList.size(); i++)
				leftArr[i] = leftList.get(i);

			for(int i=0; i<rightList.size(); i++)
				rightArr[i] = rightList.get(rightList.size()-1 - i); //keep the order: [root] [ left subtree] [ right subtree]

			root.left = PreOrderToTree(leftArr);	
			root.right = PreOrderToTree(rightArr);
		}
		return root;
	}
	public static int splitInOrder(int[] Arr, ArrayList<Integer> leftList, ArrayList<Integer> rightList)
	{
		int rootNum=0;
		if( Arr != null && Arr.length > 0 && leftList != null && rightList != null)
		{
			int len = Arr.length;
			rootNum = Arr[0];

			if( len > 1)
			{
				int i=1;
				int j=len-1;

				int nl = 0, nr = 0;
				while(i <= j)
				{
					while(i < len && rootNum > Arr[i]) 
						leftList.add(Arr[i++]); 

					while(j > 0 && rootNum < Arr[j])
						rightList.add(Arr[j--]);
				}
				
				for(i=0; i<leftList.size(); i++)
				{ System.out.println(leftList.get(i)); }

				System.out.println(); 
				for(i=0; i<rightList.size(); i++)
				{ System.out.println(rightList.get(i)); }
			}
		}
		return rootNum;
	}
	public static void PreOrder(Node root)
	{
		if(root != null)
		{
			System.out.println("pre=" + root.data);
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}
}
