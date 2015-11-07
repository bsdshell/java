public class MaxContinuous 
{
    public static void main(String[] args)
    {
        int[] array = {2, 4, 7, 1, 5, 8, 10, 11, 12, 13, 11, 14, 15, 16, 0, 1, 2, 3, 5, 6, 7};
        maxContinuous(array);
    }
    public static void maxContinuous(int[] array)
    {
        if(array != null)
        {
            int len = array.length;
            int[] arr = new int[len];
            for(int i=0; i<len; i++)
                arr[i] = 1;

            int maxIndex = 0;
            int max = arr[0];
            for(int i=1; i<len; i++)
            {
                if(array[i] > array[i-1])
                    arr[i] = arr[i-1] + 1;

                if(arr[i] > max)
                {
                    max = arr[i];
                    maxIndex = i;
                }
            }
            System.out.println("beginIndex=" + (maxIndex - max + 1));
            System.out.println("maxIndex=" + maxIndex);
            System.out.println("max=" + max);
        }
    }
}
