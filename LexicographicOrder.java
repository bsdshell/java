import java.util.*;

public class LexicographicOrder 
{
    public static void main(String[] args)
    {
        System.out.println("Try it");
        test1();
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
}
