import classfile.*;

public class MergeThreeSortList 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        test1();
        test2();
    }
    public static void test1()
    {
        int[] arr1 = {1};
        int[] arr2 = {2, 8, 10, 40};
        int[] arr3 = {5};
        int[] arr = mergeThreeList(arr1, arr2, arr3);
        Aron.printArray(arr1);
        Aron.printArray(arr2);
        Aron.printArray(arr3);
        Aron.printArray(arr);
    }

    public static void test2()
    {
        int[] arr1 = {1, 9, 20, 30};
        int[] arr2 = {2, 8, 10, 40};
        int[] arr3 = {5, 18, 21, 29};
        int[] arr = mergeThreeList(arr1, arr2, arr3);
        Aron.printArray(arr1);
        Aron.printArray(arr2);
        Aron.printArray(arr3);
        Aron.printArray(arr);
    }
    public static int[] mergeThreeList(int[] arr1, int[] arr2, int[] arr3)
    {
        int[] arr = null;
        if(arr1 != null && arr2 != null && arr3 != null)
        {
            int len1 = arr1.length;
            int len2 = arr2.length;
            int len3 = arr3.length;
            int inx = 0;
            int inx1=0, inx2=0, inx3=0;
            arr = new int[len1+len2+len3];
            while(inx1 < len1 || inx2 < len2 || inx3 < len3)
            {
                if(inx1 >= len1 && (inx2 < len2 && inx3 < len3))
                {
                    arr[inx] = Math.min(arr2[inx2], arr3[inx3]);
                    if( arr[inx] == arr2[inx2]) inx2++;
                    if( arr[inx] == arr3[inx3]) inx3++;
                }
                else if(inx2 >= len2 && (inx1 < len1 && inx3 < len3))
                {    
                    arr[inx] = Math.min(arr1[inx1], arr3[inx3]);
                    if( arr[inx] == arr1[inx1]) inx1++;
                    if( arr[inx] == arr3[inx3]) inx3++;
                }
                else if(inx3 >= len3 && (inx1 < len1 && inx2 < len2))
                {    
                    arr[inx] = Math.min(arr1[inx1], arr2[inx2]);
                    if( arr[inx] == arr1[inx1]) inx1++;
                    if( arr[inx] == arr2[inx2]) inx2++;
                }
                else if(inx1 >= len1 && inx2 >= len2 && inx3 < len3)
                {
                    arr[inx] = arr3[inx3]; inx3++;
                }
                else if(inx2 >= len2 && inx3 >= len3 && inx1 < len1)
                {
                    arr[inx] = arr1[inx1]; inx1++;
                }
                else if(inx1 >= len1 && inx3 >= len3 && inx2 < len2)
                {
                    arr[inx] = arr2[inx2]; inx2++;
                }
                else
                {
                    arr[inx] = Math.min(Math.min(arr1[inx1], arr2[inx2]), arr3[inx3]);
                    if( arr[inx] == arr1[inx1]) inx1++;
                    if( arr[inx] == arr2[inx2]) inx2++;
                    if( arr[inx] == arr3[inx3]) inx3++;
                }
                inx++;
            }
        }
        return arr;
    }
}
