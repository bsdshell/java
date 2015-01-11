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

public class Try 
{
    public static void main(String[] args)
    {
        System.out.println("Try it");
        String s = "abc";
        int[] arr = {1, 2, 3};
        char[] array = new char[s.length()];
        int depth = 0;

        Set<Character> map = new LinkedHashSet<Character>();
        permutationTree(s, depth, map);
        System.out.println();
        depth=0;
        permutation2(arr, depth);
        System.out.println("==============================");
        int len1 = arr.length;
        LSITree(arr, len1); 
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
    public static void test3()
    {
        
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

    public static void permutationTree(String s, int depth, Set<Character> map)
    {
        if(depth == s.length())
        {
            for(Character ch: map)
                System.out.print("["+ch+"]");

            System.out.println();
        }
        else 
        {
            for(int i=0; i<s.length(); i++)
            {
                if(!map.contains(s.charAt(i)))
                {
                    map.add(s.charAt(i));
                    permutationTree(s, depth+1, map);
                    map.remove(s.charAt(i));
                }
            }
        }
    }
    public static void permutation2(int[] arr, int depth)
    {
        if(depth == arr.length)
        {
            for(int i=0; i<arr.length; i++)
                System.out.print("["+arr[i]+"]");

            System.out.println();
        }
        else
        {
            for(int i=depth; i<arr.length; i++)
            {
                swap(arr, i, depth);
                permutation2(arr, depth+1);    
                swap(arr, i, depth);
            }
        }
    }
    public static void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void LSITree(int[] arr, int len)
    {
        if(len == 1)
            System.out.println("["+arr[len-1]+"]");
        else 
        {
            for(int i=1; i<len; i++)
            {
                LSITree(arr, len-1); 
                System.out.println("["+arr[i]+"]");
            }
        }
    }
}
