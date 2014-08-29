public class LongestContinuousSum 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] array =new int[]{-2, 8, -5, 20, 3, -2}; 
        int max = Sum(array);
        System.out.println("max=" + max);
    }
    public static int Sum(int[] array)
    {
        int max = 0;
        if(array != null)
        {
            int len = array.length;
            int[] result = new int[len];
            if(len > 0)
            {
                result[0] = array[0];
                for(int i=1; i<len; i++)
                {
                    result[i] = result[i-1] + array[i] > array[i] ? result[i-1] + array[i] : array[i];
                }
                for(int i=0; i<len; i++)
                {
                    if(max < result[i])      
                        max = result[i];
                }
            }
        }
        return max;
    }
}
