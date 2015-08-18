import java.util.*;

class Node
{
    Map<String, Node> map = null;
    public Node()
    { 
        map = new HashMap<String, Node>();
    }
}

class Tries
{
    Node root;
    public Tries()
    {
        root = new Node();
        root.map.put("$", null);
    }
    public void insert(String str)
    {
        str = str + "$";
        Node curr = root;
        for(int i=0; i<str.length(); i++)
        {
            String key = str.charAt(i) + "";
            if(key.equals("$"))
                curr.map.put("$", null);
            else
            {
                if(!curr.map.containsKey(key))
                    curr.map.put(key, new Node());
                curr = curr.map.get(key);
            }
        }    
    }
    public boolean check(String str)
    {
        Node curr = root;
        str = str + "$";
        for(int i=0; i<str.length(); i++)
        {
            String s = str.charAt(i) + "";

            if(s.equals("$")) 
                return curr.map.containsKey("$");
            else 
            {
                if(curr.map.containsKey(s))
                    curr = curr.map.get(s);
                else
                    return false;
            }
        }
        return false;
    }
}

public class Try 
{
    public static void main(String[] args)
    {
        test1();
    }
    public static void test1()
    {
        Tries suffixTree = new Tries();
        suffixTree.insert("1");
        suffixTree.insert("12");
        suffixTree.insert("12312322");
        suffixTree.insert("13344");
        suffixTree.insert("1210033");
        suffixTree.insert("123334");
        suffixTree.insert("23");

        boolean isValid = suffixTree.check("1");
        System.out.println("isValid="+isValid);

        isValid = suffixTree.check("23");
        System.out.println("isValid="+isValid);

        isValid = suffixTree.check("123");
        System.out.println("isValid="+isValid);

        isValid = suffixTree.check("1210033");
        System.out.println("isValid="+isValid);

        isValid = suffixTree.check("");
        System.out.println("isValid="+isValid);

    }
}
