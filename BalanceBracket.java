import java.util.*;

public class BalanceBracket 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        String s = "[12(3)4[5)]";
        char prev = 'a';
        int[] arr = new int[1];
        arr[0] = 0;
        boolean ret = balanceBracket(s);
        System.out.println("ret="+ret);
    }
    public static boolean balanceBracket(String s)
    {
        boolean ret = true;
        Stack<Character> stack = new Stack<Character>();        
        if(s != null)
        {
            for(int i=0; i<s.length(); i++)
            {
                char ch = s.charAt(i);
                if(ch == '[' || ch == '(')
                {
                    stack.push(ch);
                }
                else if(ch == ']' || ch == ')')
                {
                    Character left = stack.pop();
                    if(!(left == '[' && ch == ']' || left == '(' && ch == ')'))
                        ret = false;
                }
                else if(!('0' <= ch && ch <= '9'))
                {
                    ret = false;
                }

            }
            if(!stack.empty())
                ret = false;
        }
        return ret;
    }
}
