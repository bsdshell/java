public class MaxDistanceThreeSortIntegers
{
    public static void main(String[] args)
    {
        System.out.println("hello world!");
        int[] arr1 = {1, 4, 500, 600};
        int[] arr2 = {2, 5, 10, 500};
        int[] arr3 = {6, 20, 30, 500, 501};

        printArray(arr1);
        printArray(arr2);
        printArray(arr3);
        int min = findMaxAbsSum(arr1, arr2, arr3);
        System.out.println("min["+min+"]");
    }
    public static int findMaxAbsSum(int[] arr1, int[] arr2, int[] arr3)
    {
        int gmin = Integer.MAX_VALUE;
        if(arr1 != null && arr2 != null && arr3 != null)
        {
            int len1 = arr1.length;
            int len2 = arr2.length;
            int len3 = arr3.length;
            int inx1 =0, inx2 = 0, inx3 = 0;
            while(inx1 < len1  && inx2 < len2 && inx3 < len3)
            {
                int min = Math.min(Math.min(arr1[inx1], arr2[inx2]), arr3[inx3]);
                int max = Math.max(Math.max(arr1[inx1], arr2[inx2]), arr3[inx3]);
                int sum = 2*(max - min);
                if(sum == 0)
                    return 0;

                if(sum < gmin)
                    gmin = sum;

                if(min == arr1[inx1]) inx1++;
                if(min == arr2[inx2]) inx2++;
                if(min == arr3[inx3]) inx3++;
            }
        }    
        return gmin;
    }
    public static void printArray(int[] arr)
    {
        if(arr != null)
        {
            for(int i=0; i<arr.length; i++)
                System.out.println("arr["+i+"]["+arr[i]+"]");
        }
        System.out.println("===============");
    }
}
