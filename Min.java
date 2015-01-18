public class Min 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] str = {4};  
        int m  = min(str);
        System.out.println("m="+m);
    }
    public static int min(int[] array)
    {
        int min = Integer.MAX_VALUE;
        if(array != null)
        {
            int len = array.length;
            if(len > 0)
            {
                min = array[0];
                for(int i = 1; i<len; i++)
                {
                    if(min > array[i])
                        min = array[i];
                }
            }
        }
        return min;
    }
}
