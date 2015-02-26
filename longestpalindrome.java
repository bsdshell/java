import java.io.*;
import java.lang.String;
import java.util.*;
class LongestPalindrome 
{
	public static void main(String args[])
	{
        String palindrome = longest2("a");
		System.out.println("Palindrome="+palindrome);
        test1();
	}
	
    //complexity O(N^2)
    public static String longest2(String str)
    {
        String palindrome = "";
        if(str != null)
        {
            String newStr = "#";
            for(int i=0; i<str.length(); i++)
            {
                newStr += str.charAt(i) + "#";
            }

            int len = newStr.length();
            int maxoffset = 0;
            for(int i=0; i<len; i++)
            {
                for(int offset=0; offset<len; offset++)
                {
                    if(i-offset >= 0 && i+offset<len && newStr.charAt(i-offset) == newStr.charAt(i+offset))
                    {
                        if(offset > maxoffset)
                        {
                            maxoffset = offset;
                            palindrome = newStr.substring(i-offset, i+offset+1);
                        }
                    }
                }
            }
            String tmpStr = "";
            for(int i=0; i<palindrome.length(); i++)
            {
                if(palindrome.charAt(i) != '#')
                    tmpStr += palindrome.charAt(i) + ""; 
            }
            palindrome = tmpStr;
        }
        return palindrome;
    }
    //complexity O(n)
    public static void logestPalindrome(String str)
    {
        if( str != null)
        {
            String newStr = "#";
            for(int i=0; i<str.length(); i++)
            {
                newStr += str.charAt(i) + "#"; 
            }
            int len = newStr.length();
            int[] p = new int[len];
            int c=1;
            int rightEdge = 0;
            for(int i=1; i<len; i++)
            {
                int j = c-(i-c);
                if(p[j] < rightEdge-c)
                   p[i] = p[j];
                else 
                   p[i] = rightEdge-c ;
                while(i-p[i] >= 0 && p[i-p[i]] == p[i+p[i]])
                {
                    p[i]++;
                }
                if(i+p[i] > rightEdge)
                {
                    rightEdge = i+p[i];
                    c = i;
                }
            }
        }
    }

    public static void test1()
    {
        String s = "abccb";
        int d = 0;
        int offset = 0;
        String[] maxArr = new String[1];
        longestPalindromeRecursion(s, d, offset, maxArr);
        System.out.println("s="+s);
        System.out.println(maxArr[0]);
    }

    public static void longestPalindromeRecursion(String s, int d, int offset, String[] maxArr)
    {
        if(offset < s.length())
        {
            substring(s, d, offset, maxArr);
            longestPalindromeRecursion(s, d, offset+1, maxArr);
        }
    }
    public static void substring(String s, int d, int offset, String[] maxArr)
    {
        if(offset + d + 1 <= s.length())
        {
            String str = s.substring(offset, offset + d+1);
            if(isPalindrome(str, d))
            {
                if(maxArr[0] != null) 
                {
                    if(str.length() > maxArr[0].length())
                        maxArr[0] = str;
                }
                else
                    maxArr[0] = str;
                    
            }
            substring(s, d+1, offset, maxArr);
        }
    }
    public static boolean isPalindrome(String s, int i)
    {
        if(s.length() <= 1)
            return true;
        else if(s.charAt(i) != s.charAt(s.length()-1-i))
            return false;
        else
        {
            if(i+1 <s.length() && s.length() > 2)
                return isPalindrome(s.substring(i+1, s.length()-2), i+1);
            return true;
        }
    }
}
