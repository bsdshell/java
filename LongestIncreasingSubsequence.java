public class LongestIncreasingSubsequence 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] array = {20, 30, 40, 4, 0, 9, 10, 12};
        fun(array);
    }
    public static void fun(int[] array)
    {
        int m = 0;
        for(int j=0; j<array.length; j++)
        {
            int len = 1;
            int end = j;
            for(int i=j+1; i<array.length; i++)
            {
                if(array[end] < array[i])
                {
                    end = i;
                    len++;
                }
            }
            if(m < len)
                m = len;
        }
        System.out.println("m=["+m+"]");
    }
}
