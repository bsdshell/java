public class MiniDiffSortedArray 
{
    public static void main(String[] args)
    {
        System.out.println("MiniDiffSortedArray");
        test1();
    }
    public static void test1()
    {
        int[] arr1 = {2, 4, 9, 20};
        int[] arr2 = {1, 14, 16, 80};
        int min = miniDiff(arr1, arr2);
        System.out.println("min=["+min+"]");
    }

    public static int miniDiff(int[] arr1, int[] arr2)
    {
        int diff = Integer.MAX_VALUE;
        if(arr1 != null && arr2 != null)
        {
            int inx1 = 0;
            int inx2 = 0;
            while(inx1 < arr1.length && inx2 < arr2.length)
            {
                diff = Math.min(diff, Math.abs(arr1[inx1] - arr2[inx2]));
                int min = Math.min(arr1[inx1], arr2[inx2]); 
                if(min == arr1[inx1]) inx1++;
                if(min == arr2[inx2]) inx2++;
            }
        }
        return diff;
    }
}
