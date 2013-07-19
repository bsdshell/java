public class PalindromeSpace
{
    public static void main(String[] args)
    {
        System.out.println("Palindrome With Space");
        
        boolean ret0 = isPalindrome(null);
        boolean ret1 = isPalindrome("");
        boolean ret2 = isPalindrome(" ");
        boolean ret3 = isPalindrome(" a");
        boolean ret4 = isPalindrome("a ");
        boolean ret5 = isPalindrome("ab");
        boolean ret6 = isPalindrome("aa");
        boolean ret7 = isPalindrome("a a");
        boolean ret8 = isPalindrome("a b");
        boolean ret9 = isPalindrome("a b ba");
        System.out.println("[null]["+ret0+"] []["+ret1+"] [ ]["+ret2+"] [ a]["+ret3+"] [a ]["+ret4+"] [ab]["+ret5+"] [aa]["+ret6+"] [a a]["+ret7+"] [a b]["+ret8+"] [a b ba]["+ret9+"]");
    }
    public static boolean isPalindrome(String str)
    {
        boolean ret = true;
        boolean done = false;
        if(str != null && str.length() > 1)
        {
            int len = str.length();
            int i = 0; 
            int j = len - 1;
            while(!done && ret)
            {
                if(str.charAt(i) == str.charAt(j)) 
                {
                    if(i == j || i == j - 1)
                        done = true;
                    else
                    {
                        if(i < len - 1)
                            i++;
                        if(j > 0)
                            j--;
                    }
                }
                else
                {
                    if(str.charAt(i) == ' ')
                    {
                        if(i < len - 1)
                            i++;
                    }
                    else if(str.charAt(j) == ' ') 
                    {
                        if(j > 0)
                            j--;
                    }
                    else
                    {
                        ret = false;
                    }
                }
            }
        }
        return ret;
    }
}
