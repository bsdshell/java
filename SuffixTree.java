import java.util.*;

class Node
{
    Map<Character, Node> map = new HashMap<Character, Node>();
    boolean isWord = false;
    public Node(){}
}

class Tries
{
    Node root;
    public Tries()
    {
        root = new Node();
    }
    public void print(Node curr, List<Character> list)
    {
        if(curr != null)
        {   
            if(curr.isWord)
            {
                for(Character chara:list)
                {
                    System.out.print("["+chara+"]");
                }
                System.out.println();
            }
            for(Character ch: curr.map.keySet())
            {
                list.add(ch);
                print(curr.map.get(ch), list);
                list.remove(ch);
            }
        }
    }
}

public class SuffixTree 
{
    public static void main(String[] args)
    {
        test1();
        test2();
    }
    public static void test1()
    {
        System.out.println("test1()");
        Tries tri = new Tries();
        int depth = 0;
        List<Character> list = new LinkedList<Character>();
        Node myroot = tri.root;
        insert(tri.root, "dog", depth);
        insert(tri.root, "cat", depth);
        insert(tri.root, "human", depth);
        insert(tri.root, "animal", depth);
        insert(tri.root, "mono", depth);
        insert(tri.root, "momo", depth);
        insert(tri.root, "mo", depth);
        insert(tri.root, "mom", depth);
        tri.print(myroot, list);
        String pattern = "m";
        boolean ret = search(myroot, pattern);
        System.out.println("Find pattern=["+pattern+"]=["+ret+"]");
    }
    public static void test2()
    {
        System.out.println("test2()");
        Tries tri = new Tries();
        int depth = 0;
        List<Character> list = new LinkedList<Character>();
        Node myroot = tri.root;
        insert(tri.root, "dog", depth);
        insert(tri.root, "cat", depth);
        insert(tri.root, "human", depth);
        insert(tri.root, "animal", depth);
        insert(tri.root, "mono", depth);
        insert(tri.root, "momo", depth);
        insert(tri.root, "mo", depth);
        insert(tri.root, "mom", depth);
        tri.print(myroot, list);
        String pattern = "mom";
        boolean ret = search(myroot, pattern);
        System.out.println("Find pattern=["+pattern+"]=["+ret+"]");
    }
    public static void insert(Node root, String s, int depth)
    {
        if(depth == s.length())
        {
            if(root != null)
                root.isWord = true;
        } 
        else if(depth < s.length()) 
        {
            if(root == null)
            {
                root = new Node();
                Node subNode = new Node();
                root.map.put(s.charAt(depth), subNode); 
                insert(subNode, s, depth+1);
            }
            else
            {
                Character key = new Character(s.charAt(depth));
                Node child= root.map.get(key);
                if(child == null)
                    child = new Node();
                root.map.put(key, child);
                insert(child, s, depth+1);
            }
        }
    }
    public static boolean search(Node root, String pattern)
    {
        boolean ret = true;
        Node curr = root;
        if(curr != null && pattern != null)
        {
            for(int i=0; i<pattern.length() && ret; i++)
            {
                Character key = new Character(pattern.charAt(i));
                Node child = curr.map.get(key);        
                if(child != null)
                    curr = child;    
                else
                    ret = false;        
            }
            if(!curr.isWord)
               ret = false; 
        }
        return ret;
    }
}
