import java.util.*;

public class LexicographicOrder 
{
    public static void main(String[] args)
    {
        System.out.println("Try it");
        test1();
        System.out.println("===========");
        printLexico(5);
        System.out.println("===========");
        printLexico(10);
        System.out.println("===========");
        printLexico(100);
        System.out.println("===========");
        printLexico(105);
        System.out.println("===========");
        printLexico(1234);
        System.out.println("===========");
    }
    public static void printLexico(int n)
    {
        System.out.println("n=["+n+"]");
        for(int down = 1; down <10; down++)
        {
            int base = down;
            while(base <= n)
            {
                System.out.print("["+base+"] ");
                base *= 10;
            }

            base /=10;
            while(base >=10 && base <= n)
            {
                int sum = base;
                for(int i=1; i<10 && base+i <=n; i++)
                {
                    sum = base + i;
                    System.out.print("["+sum+"] ");
                }
                base = sum/10 + 1;
                if(base*10 <= n)
                    base *=10;
            }
        }
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
