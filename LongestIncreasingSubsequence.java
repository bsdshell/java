public class LongestIncreasingSubsequence 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] array = {20,1, 30, 6, 40, 4, 0, 9, 10, 12};
        m = LISDP(array);
        System.out.println("m2=["+m+"]");
    }

    //Dynamic programming algorithm solves Longest Increasing Subsequence
    //with complexity O(n^2)
    public static int LISDP(int[] array)
    {
        int len = array.length;
        int[] maxlist = new int[len];
        for(int i=0; i<len; i++)
            maxlist[i] = 1;

        for(int i=1; i<len; i++)
        {
            for(int j=0; j<=i-1; j++)
            {
                if(array[j] < array[i] && maxlist[i] < 1 + maxlist[j])            
                    maxlist[i] = 1 + maxlist[j];
            }            
        } 
        
        int m = Integer.MIN_VALUE;
        for(int i=0; i<len; i++)
        {
            if(maxlist[i] > m)
                m = maxlist[i];
        }
        return m;
    }
}
