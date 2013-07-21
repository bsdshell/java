public class BinarySearch2 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        //int[] array = {1, 2, 3, 7, 9, 10};
        int[] array = {-1};
        int left = 0; 
        int right = array.length - 1;
        int key = -1;
        boolean ret = BinSearch(array, k, left, right);
        System.out.println("ret=" + ret);
    }
    public static boolean BinSearch(int[] array, int key, int left, int right)
    {
        //if(array != null)
        {
            int middle = (left + right)/2;
            if(middle < right)
            {
                if(array[middle] < key)
                {
                    return BinSearch(array, key, middle+1, right);
                } 
                else if(array[middle] > key)
                {
                    return BinSearch(array, key, left, middle);
                }
                else
                    return true;
            }
            else
            {
                if(array[middle] == k)
                    return true;
                else 
                    return false;
            }
        }
    }
    
}
