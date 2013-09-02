public class MultiplyArrayInteger2
{
    public static void main(String[] args)
    {
        int[] array = {2, 3, 4};
        int[] arr1 = multiplyArray(array);
        for(int i=0; i<arr1.length; i++)
        {
            System.out.println("["+arr1[i]+"]");
        }
    }
    public static int[] multiplyArray(int[] array)
    {
        if(array != null && array.length > 1)
        {
            int len = array.length;
            int[] A = new int[len];
            int[] B = new int[len];
            A[0] = 1;
            A[1] = array[0];
            B[0] = 1;
            B[1] = array[len-1];
            for(int i=1; i<len-1; i++)
            {
                A[i+1] = A[i]*array[i];
                B[i+1] = B[i]*array[len-1-i];
            }
            for(int i=0; i<len; i++)
            {
                array[i] = A[i]*B[len-1-i];
            }
        }
        return array;
    }
}
