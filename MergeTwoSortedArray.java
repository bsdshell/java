public class MergeTwoSortedArray 
{
    public static void main(String[] args)
    {
        System.out.println("Merge Sort Array");
        test1();
        System.out.println(); 
        test2();
        System.out.println(); 
        test3();
    }

    public static void test1()
    {
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("{"+name + "}");
        int[] arr1 = {1};
        int[] arr2 = {2, 5, 11, 24};
        int[] array = merge(arr1, arr2);

        for(int i=0; i<array.length; i++)
            System.out.println("[" + i + "]=" + array[i]);

    }
    public static void test2()
    {
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("{"+name + "}"); 

        int[] arr1 = {1, 4, 9};
        int[] arr2 = {2, 5, 11, 24};
        int[] array = merge(arr1, arr2);

        for(int i=0; i<array.length; i++)
            System.out.println("[" + i + "]=" + array[i]);
    }

    public static void test3()
    { 
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("{"+name + "}"); 

        int[] arr1 = {1};
        int[] arr2 = {2};
        int[] array = merge(arr1, arr2);

        for(int i=0; i<array.length; i++)
            System.out.println("[" + i + "]=" + array[i]);
    }


    // merge two sorted array
    public static int[] merge(int[] arr1, int[] arr2)
    {
        int[] array = null;
        if( arr1 != null && arr2 != null)
        {
            int i=0;
            int j=0;
            int k=0;
            int len1 = arr1.length;
            int len2 = arr2.length;
            array = new int[len1+len2];
            while(k < len1 + len2) 
            {
                if( i >= len1) 
                {
                    array[k] = arr2[j];
                    j++;
                }
                else if( j >= len2)
                {
                    array[k] = arr1[i];
                    i++;
                }
                else
                {
                    if(arr1[i] < arr2[j])
                    {
                        array[k] = arr1[i];
                        i++;
                    }
                    else 
                    {
                        array[k] = arr2[j];
                        j++;
                    }
                }
                k++;
            }
        }
        return array;
    }
}
