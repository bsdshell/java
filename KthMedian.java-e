public class KthMedian 
{
    public static void main(String[] args)
    {
       test1(); 
       test2(); 
       test3(); 
       test4(); 
    }
    public static void test1()
    {
        System.out.println("test1");
        int[] array = {1, 4, 2, 5, 6};
        int lo = 0, hi = array.length-1;
        int k=5;
        int median = modifiedQuickSort(array, lo, hi, k);
        System.out.println("median=["+median+"]");
        System.out.println(array[median] == 6);
    } 
    public static void test2()
    {
        System.out.println("test2");
        int[] array = {1, 4};
        int lo = 0, hi = array.length-1;
        int k=1;
        int median = modifiedQuickSort(array, lo, hi, k);
        System.out.println("median=["+median+"]");
        System.out.println(array[median] == 1);
    } 
    public static void test3()
    {
        System.out.println("test3");
        int[] array = {1};
        int lo = 0, hi = array.length-1;
        int k=1;
        int median = modifiedQuickSort(array, lo, hi, k);
        System.out.println("median=["+median+"]");
        System.out.println(array[median] == 1);
    } 
    public static void test4()
    {
        System.out.println("test4");
        int[] array = {2, 0, 1};
        int lo = 0, hi = array.length-1;
        int k=2;
        int median = modifiedQuickSort(array, lo, hi, k);
        System.out.println("median=["+median+"]");
        System.out.println(array[median] == 1);
    } 

    //Find the kth median element in a unsorted array
    //Return index for the kth smaller element
    //Otherwise return -1
    public static int modifiedQuickSort(int[] array, int lo, int hi, int k)
    {
        if(k <= hi - lo + 1) 
        {
            if(hi == lo && k == 1)
                return lo;
            else{
                int pindex = partition(array, lo, hi);
                int leftLen = pindex - lo;
                int rightLen = hi - pindex;
                if(pindex + 1 > k) 
                    return modifiedQuickSort(array, lo, pindex-1, k);
                else if(pindex + 1 < k)
                    return modifiedQuickSort(array, pindex+1, hi, k - (leftLen+1));
                else 
                    return pindex;
            }
        }
        return -1;
    }

    //use modified quicksort algorithm to find the kth median element
    //partition an array to two parts: left_array < pivot < right_array
    public static int partition(int[] array, int lo, int hi)
    {
        int top = lo;
        if(array != null)
        {
            int pivot = array[hi];
            for(int i=lo; i<=hi; i++)
            {
                if(array[i] < pivot)
                {
                    swap(array, i, top);
                    top++;
                }
            }
            swap(array, top, hi); 
        }
        return top;
    } 
    public static void swap(int[] array, int i, int j)
    {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
