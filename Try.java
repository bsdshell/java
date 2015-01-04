import java.util.*;

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
