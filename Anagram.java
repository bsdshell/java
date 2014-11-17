import java.util.*;

class Node
{
    String s;
    public Node(String s)
    {this.s = s;}
}
public class Anagram 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        String[] array = {
            "dog",
            "cat"
        };
    }
    public static void printAnagram(String[] array)
    {
        if(array != null)
        {
            Map<Character, List<Node>> map = new HashMap<Character, List<Node>>();
            for(int i=0; i<array.length; i++)
            {
                String s = array[i];
                for(int j=0; j<s.length(); j++)
                {
                    Character ch = new Character(s.charAt(j));
                    List<Node> list = map.get(ch);
                    if(list != null)
                    {
                        list.add(new Node(s));  
                    }
                    else
                    {
                        map.put(ch, list.add(new Node(s)));    
                    }
                }
            }
        }
    }
}
