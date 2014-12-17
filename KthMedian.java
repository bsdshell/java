public class KthMedian 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] array = {1, 4, 2, 5, 6};
        int lo = 0, hi = array.length-1;
        int k=5;
        int median = modifiedQuickSort(array, lo, hi, k);
        System.out.println("median=["+median+"]");
    }
    //Find the kth median element in a unsorted array

    //Return index for the median element
    //Otherwise return -1 if k is invalid  
    public static int modifiedQuickSort(int[] array, int lo, int hi, int k)
    {
        //invalid kth
        if(k > (hi-lo + 1))
            return -1;

        if(lo == hi)
        {
            //only one element
            //base case for recursion
            if((hi-lo+1) == k)
                return lo;
            else 
                return -1;
        }
        else if(lo < hi)
        {
            int pindex = partition(array, lo, hi);
            int leftLen = pindex - lo;
            int rightLen = hi - pindex;
            if(k < leftLen + 1) 
                return modifiedQuickSort(array, lo, pindex-1, k);
            else if(k > leftLen + 1)
                return modifiedQuickSort(array, pindex+1, hi, k - (leftLen+1));
            else 
                return pindex;
        }
        return -1;
    }

    //use modified quicksort algorithm to find the kth median element
    //partition an array to two parts: left_array < pivot < right_array
    public static int partition(int[] array, int lo, int hi)
    {
        int big = lo;
        if(array != null)
        {
            int len = hi - lo + 1;
            int pivot = array[hi];
            for(int i=lo; i<len; i++)
            {
                if(array[i] < pivot)
                {
                    swap(array, i, big);
                    big++;
                }
            }
            swap(array, big, hi); 
        }
        return big;
    } 
    public static void swap(int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
