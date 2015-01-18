public class LongestPalindromeSubstringN2 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int maxlen = longestPalindromeSubstring("abkbc");
        System.out.println("maxlen="+maxlen);
    }
    public static int longestPalindromeSubstring(String str)
    {
        int maxlen = 0;
        if(str != null && str.length() > 1)
        {
            int len = str.length();
            maxlen = 1;
            for(int i=0; i<len; i++)
            {
                int currlen = 0;
                for(int j=0; j<len; j++)
                {
                    if(i+1 < len && str.charAt(i) == str.charAt(i+1))
                    {
                        if(i-j >=0 && i+1+j < len && str.charAt(i-j) == str.charAt(i+1+j))
                        {
                            if(j==0)
                                currlen +=1;
                            else 
                            {
                                if(currlen > maxlen)
                                    maxlen = currlen;
                            }
                        }
                    }
                    else 
                    {
                        if(i-j >= 0 && i+j < len && str.charAt(i-j) == str.charAt(i+j))
                        {
                            currlen += 2;
                            if(currlen > maxlen)
                                maxlen = currlen;
                        }
                    }
                }
            }
        }
        return maxlen;
    }
}
