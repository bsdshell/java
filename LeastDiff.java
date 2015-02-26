public class LeastDiff 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] arr = {1, 2, 3, 20, 30};
        int lo = 0;
        int hi = arr.length-1;
        int key = 5;
        int[] m = new int[1];
        m[0] = Integer.MAX_VALUE;
        LeastDiff(arr, lo, hi, key, m);
        System.out.println("m="+m[0]);
    }
    public static boolean LeastDiff(int[] arr, int lo, int hi, int key, int[] m)
    {
        if(lo <= hi)
        {
            int mid = (lo+hi)/2;
            if(key < arr[mid])
            {
                m[0] = Math.min(m[0], Math.abs(key - arr[mid]));
                return LeastDiff(arr, lo, mid-1, key, m);
            }
            else if(key > arr[mid])
            {
                m[0] = Math.min(m[0], Math.abs(key - arr[mid]));
                return LeastDiff(arr, mid+1, hi, key, m);
            }
            else
            {
                m[0] = 0;
                return true;  
            }
        }
        return false;
    }
}
