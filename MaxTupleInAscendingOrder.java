public class MaxTupleInAscendingOrder 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
    }
    public static int[] findMax(int[] arr)
    {
        if( arr != null)
        {
            int[] tuple = new int[3];
            int count = 0;
            tuple[0] = arr[0];
            for(int i=1; i<arr.length; i++)
            {
                for(int j=0; j<=count; j++)
                {
                    if(tuple[j] < arr[i])    
                }
            }
        }
    }
}
