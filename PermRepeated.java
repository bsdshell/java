import java.util.*;
public class PermRepeated 
{
    public static void main(String[] args)
    {
        System.out.println("Print all permuation character with repeating character!");
        String s = "1234";
        char[] array = new char[s.length()];
        int depth = 0;
        Set<Character> map = new LinkedHashSet<Character>();
        //permRepeated(s, array, depth);
        perm(s, array, depth, map);
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
}
