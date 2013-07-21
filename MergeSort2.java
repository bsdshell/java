public class MergeSort2 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] arrayLeft = {1, 20, 30, 50};
        int[] arrayRight= {11, 21, 22, 51};
        int[] array = merge(arrayLeft, arrayRight);

        int[] array2 = {3, 3, 2};
        int left = 0; int right = array2.length-1;
        int[] arr = mergeSort(array2, left, right);

        for(int i=0; i<arr.length; i++)
        {
            System.out.println("["+arr[i]+"]");
        }
    }
    public static int[] merge(int[] arrayLeft, int[] arrayRight)
    {
        int[] array = null;
        if(arrayLeft != null && arrayRight != null)
        {
            int i=0; int j=0; int k=0;
            array = new int[arrayLeft.length+arrayRight.length];
            while(i < arrayLeft.length || j < arrayRight.length)
            {
                if(i == arrayLeft.length)
                {
                    array[k] = arrayRight[j];
                    j++;
                }
                else if(j == arrayRight.length)
                {
                    array[k] = arrayLeft[i];
                    i++;
                }
                else
                {
                    if(arrayLeft[i] < arrayRight[j])
                    {
                        array[k] = arrayLeft[i];
                        i++;
                    }
                    else 
                    {
                        array[k] = arrayRight[j];
                        j++;
                    }
                }
               k++; 
            }
        }
        return array;
    }
    public static int[] mergeSort(int[] array, int left, int right)
    {
        int middle = (left + right)/2;
        if(middle < right) //more than one element
        {
            int[] arrayLeft = mergeSort(array, left, middle);
            int[] arrayRight = mergeSort(array, middle+1, right);
            return merge(arrayLeft, arrayRight);
        }
        else{
            int[] arrayOne = {array[middle]};
            return arrayOne; 
        }
    }
}
