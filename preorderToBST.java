import java.util.List;
import java.util.LinkedList;
class Node{
   int data;
    Node left;
    Node right;   
    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class preorderToBST 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        List<Integer> list = new LinkedList<Integer>();
        List<Integer> left = new LinkedList<Integer>();
        List<Integer> right = new LinkedList<Integer>();
        list.add(10);
        list.add(5);
        list.add(1);
        list.add(7);
        list.add(15);
        list.add(12);
        list.add(20);
        Node root = merge(list);
        inorder(root);
    }
    public static Node merge(List<Integer> list)
    {
        Node root = null;
        if(list != null && list.size() > 0)
        {
            List<Integer> left = new LinkedList<Integer>();
            List<Integer> right = new LinkedList<Integer>();
            root = new Node(list.get(0));
            split(list, left, right);
            root.left = merge(left);
            root.right = merge(right);
        }
        return root;
    }
    public static void split(List<Integer> list, List<Integer> left, List<Integer> right)
    {
        if(list != null && list.size() > 0)
        {
            int rootInt = list.get(0);
            for(int i=1; i<list.size(); i++)
            {
                if(list.get(i) < rootInt)
                {
                   left.add(list.get(i)); 
                }
                else 
                {
                    right.add(list.get(i));
                }
            }
        } 
    }
    public static void inorder(Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print("["+root.data+"]");
            inorder(root.right);
        }
    }
}
