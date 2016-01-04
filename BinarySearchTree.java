import java.io.*;
import java.lang.String;
import java.util.*;
import Lib.*;

class BinarySearchTree 
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
		
		int[] Arr = new int[100];
		int len=0;
		Node r = b1.getRoot();

		b1.LevelOrder();

		System.out.println(contain(r, 15));

        test1();
        test2();
        test3();
        test4();
        test5();
	}

    public static void kdistance(Node r, int k){
        if(r != null){
            if(k == 0)
                System.out.println(r.data);
            else{
                kdistance(r.left, k-1);
                kdistance(r.right, k-1);
            }
        }
    }

	public static boolean isBST(Node r)
	{
		if(r == null)
			return true;
		else
		{
			if(!isBST(r.left))
				return false;
			if(prev != null && prev.data >= r.data)
				return false;
			prev = r;
			if(!isBST(r.right))
				return false;
		}
		return true;
	}
	//init len = 0
	public static void printAllPath(Node r, int[] Arr, int len)
	{
		if( r != null && Arr != null)
		{
			Arr[len] = r.data;
			if( r.left == null && r.right == null)
			{
				for(int i=0; i<len+1; i++)
					System.out.print(Arr[i]+" ");
				System.out.println();
			}
			else
			{
				printAllPath(r.left, Arr, len+1);
				printAllPath(r.right, Arr, len+1);
			}
		}
	}
	public static int MaxDepth(Node r)
	{
		if( r != null)
		{
			int nl = MaxDepth(r.left);
			int nr = MaxDepth(r.right);

			return (nl>nr?nl:nr)+1;
		}
		return 0;
	}
	public static boolean equalBinaryTree(Node r1, Node r2)
	{
		if(r1==null && r2==null)
			return true;
		else if(r1 != null && r2 != null)
		{
			if(r1.data != r2.data)
					return false;
			if(!equalBinaryTree(r1.left, r2.left)) 
					return false;
			if(!equalBinaryTree(r1.right, r2.right))
					return false;
		}
		else 
			return false;
		return true;
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
	public static boolean contain(Node r, int value)
	{
		if( r != null)
		{
			if(contain(r.left, value))
				return true;
			if(r.data == value)
				return true;
			if(contain(r.right, value))
				return true;
		}
		return false;
	}
    // 10 5 1_ _ 6_ _ 14 11 _
    // 10 _ _
    // 10 5_ _ 12_ _
    // int[] k = new int[1];
	public static Node generateBinaryTree(Node r, String[] list, int[] k) {
        if(k[0] < list.length && list[k[0]] != "_"){
            if(r == null)
                r = new Node(Integer.parseInt(list[k[0]]));
            k[0]++;
            r.left = generateBinaryTree(r.left, list, k);
            k[0]++;
            r.right = generateBinaryTree(r.right, list, k);
            return r;
        }
        return null;
    }

    public static void test5()
    {
        System.out.println("test5"); 
        BST b1 = new BST();
        int k = 2;
		b1.Insert(15);
		b1.Insert(5);
		b1.Insert(20);
		b1.Insert(30);
		Node r = b1.getRoot();
        kdistance(r, k);
    } 
    public static void test4()
    {
        System.out.println("test4"); 
        BST b1 = new BST();
        int k = 1;
		b1.Insert(15);
		b1.Insert(5);
		b1.Insert(20);
		Node r = b1.getRoot();
        kdistance(r, k);
    } 
    public static void test3()
    {
        System.out.println("test3"); 
        BST b1 = new BST();
        int k = 0;
		b1.Insert(15);
		Node r = b1.getRoot();
        kdistance(r, k);
    } 

    public static void test2()
    {
        System.out.println("test2"); 
        String[] list = {
            "10",
            "8",
            "_",
            "_",
            "12",
            "_",
            "19"
        };
        Node r = null;
        int[] k= new int[1];
        k[0] = 0;
        Node root = generateBinaryTree(r, list, k);
        Inorder(root);
    } 
    public static void test1()
    {
        System.out.println("test1"); 
        String[] list = {
            "10",
            "_",
            "_"
        };
        Node r = null;
        int[] k= new int[1];
        k[0] = 0;
        Node root = generateBinaryTree(r, list, k);
        Inorder(root);
    } 
}
