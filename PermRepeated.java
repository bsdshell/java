import java.util.*;
public class PermRepeated 
{
    public static void main(String[] args)
    {
        System.out.println("Print all permuation character with repeating character!");
        String s = "ABC";
        char[] array = new char[s.length()];
        int depth = 0;
        Set<Character> map = new LinkedHashSet<Character>();
        //permRepeated(s, array, depth);
        //perm(s, array, depth, map);

        int k=2;
        for(int i=1; i<=s.length(); i++)
            permRepeatedChooseK(s, array, depth, i);

        test1();
    }

    public static void ExcelSheetRowNumber(String s)
    {
        char[] array = new char[s.length()];
        int depth = 0;
        for(int i=1; i<=s.length(); i++)
            permRepeatedChooseK(s, array, depth, i);
    }


    //Given string character array and integer k,
    //print all permutation with repeatation string length k 
    public static void permRepeatedChooseK(String s, char[] array, int depth, int k)
    {
        if(depth == k)
        {
            for(int i=0; i<depth; i++)
            {
                System.out.print("["+array[i]+"]");
            }
            System.out.println();
        }
        else 
        {
            if(array != null && s != null)
            {
                for(int i=0; i<s.length(); i++)
                {
                    array[depth] = s.charAt(i);
                    permRepeatedChooseK(s, array, depth+1, k);
                }
            }
        }
    }

    public static void permRepeated(String s, char[] array, int depth)
    {
        if(s != null)
        {
            if(s.length() == depth)
            {
                for(int i=0; i<depth; i++)
                {
                    System.out.print("["+array[i]+"]");
                }
                System.out.println();
            }
            else
            {
                for(int i=0; i<s.length(); i++)
                {
                    array[depth] = s.charAt(i);
                    permRepeated(s, array, depth+1);
                }
            }
        }
    }
    public static void permRepeatingChar(Character[] array, int depth, Set<String> set)
    {
        if(depth == array.length)
        {
            String s="";
            for(Character ch:array)
                s += ch.toString();

            if(!set.contains(s))
                set.add(s);
        }
        else
        {
            for(int i=depth; i<array.length; i++)
            {
                Aron.swap(array, i, depth);
                permRepeatingChar(array, depth+1, set);
                Aron.swap(array, i, depth);
            }
        }
    }
    public static void perm(String s, char[] array, int depth, Set<Character> map)
    {
        if(s != null)
        {
            if(s.length() == depth)
            {
                for(Character ch: map)
                    System.out.print(ch);
                System.out.println();
            }
            else
            {
                for(int i=0; i<s.length(); i++)
                {
                    Character ch = new Character(s.charAt(i));
                    if(!map.contains(ch))
                    {        
                        map.add(ch);
                        perm(s, array, depth+1, map);
                        map.remove(ch);
                    }
                } 
            }
        }
    }
    public static void test1()
    {
        Character[] array = {'a', 'b', 'b'};
        int depth = 0;
        Set<String> set = new LinkedHashSet<String>();
        permRepeatingChar(array, depth, set);
        for(String item: set)
            System.out.println(item);
    }
}
