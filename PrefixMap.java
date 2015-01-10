import java.util.*;

class Node{
    Node next;
    String key;
    String word;
    public Node(String key, String word)
    {
        this.key = key;
        this.word = word;
    }
}

public class PrefixMap 
{
    public static void main(String[] args)
    {
        test1();
        test2();
    }
    public static void test1()
    {
        String s = "abc";
        for(int i=0; i<s.length(); i++)
        {
            String str = s.substring(0, i+1);
            System.out.println("str="+str);
        }
    }
    public static void test2()
    {
        String str = "My dog is god and done what the hell is going on yep this sucks what the hell is going on yep this sucks";
        String[] array = str.split(" ");
        List<String> list = Arrays.asList(array);
        Map<String, Node> map = buildMap(list);
        for(String key:map.keySet())
        {
            Node curr = map.get(key);
            System.out.print("{"+key+"}");
            while(curr != null)
            {
                System.out.print("->["+curr.word+"]");
                curr = curr.next;
            }
            System.out.println();
        }
    }
    public static Map<String, Node> buildMap(List<String> list)
    {
        Map<String, Node> map = new HashMap<String, Node>();
        for(String word:list)
        {
            prefixWord(word, map);
        }    
        return map;
    }
    public static void prefixWord(String word, Map<String, Node> map)
    {
        for(int i=0; i<word.length(); i++)
        {
            String key = word.substring(0, i+1);
            if(map.containsKey(key))
            {
                Node curr = map.get(key);
                Node prev = null;
                while(curr != null)
                {
                    if(curr.word.equals(word))
                        break;
                    else
                    {
                        prev = curr;
                        curr = curr.next;
                    }
                }
                if(curr == null)
                    prev.next = new Node(key, word);
            }
            else
            {
                map.put(key, new Node(key, word));
            }
        }
    }
}
