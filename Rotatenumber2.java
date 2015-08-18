public class Rotatenumber2 
{
    public static void main(String[] args)
    {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
    
    public static void test1()
    {
        System.out.println("test1() Rotate sorted integer array");
        int[] arr = {4, 3, 2, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex2(arr, lo, hi);
        if(index >= 0)
            System.out.println("arr["+index+"]="+arr[index]);
        else
        {
            System.out.println("Impossible cycle:");
            Aron.printArray(arr);
        }
    }

    public static void test2()
    {
        System.out.println("test2() Rotate sorted integer array");
        int[] arr = {1, 2};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex2(arr, lo, hi);
        if(index >= 0)
            System.out.println("arr["+index+"]="+arr[index]);
        else
            System.out.println("error");
    }
    public static void test3()
    {
        System.out.println("test3() Rotate sorted integer array");
        int[] arr = {3};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex2(arr, lo, hi);
        if(index >= 0)
            System.out.println("arr["+index+"]="+arr[index]);
        else
            System.out.println("error");
    }
    public static void test4()
    {
        System.out.println("test4() Rotate sorted integer array");
        int[] arr = {3, 4, 5, 1, 2};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex2(arr, lo, hi);
        if(index >= 0)
            System.out.println("arr["+index+"]="+arr[index]);
        else
            System.out.println("error");
    }
    public static void test5()
    {
        System.out.println("test5() Rotate sorted integer array");
        int[] arr = {3, 4, 5, 1, 2};
        int lo = 0;
        int hi = arr.length - 1;

        int index = findMinIndex(negative(arr), lo, hi);
        if(index >= 0)
            System.out.println("arr["+index+"]="+arr[index]);
        else
            System.out.println("error");
    }

    public static void test6()
    {
        System.out.println("test6() Rotate sorted integer array");
        int[] arr = {2, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex2(arr, lo, hi);
        if(index >= 0)
            System.out.println("arr["+index+"]="+arr[index]);
        else
            System.out.println("error");
    }


    // assume there is not duplicated number in the array
    public static int findMaxIndex2(int[] arr, int lo, int hi)
    {
        if(arr != null)
        {
            if(arr[lo] < arr[hi] || lo == hi)
                return hi;
            else
            {
                int mid = (lo + hi)/2;
                if(arr[lo] < arr[mid])
                    return findMaxIndex2(arr, mid, hi);
                else
                    return findMaxIndex2(arr, lo, mid);
            }
        }
        return -1;
    }

    public static int findMaxIndex(int[] arr, int lo, int hi)
    {
        if( arr != null)
        {
            if(arr[lo] < arr[hi])
                return hi;
            else 
            {
                if(lo == hi)
                    return hi;
                else if(lo < hi)    
                {
                    int mid = (lo + hi)/2;    
                    if(arr[lo] > arr[mid])
                        return findMaxIndex(arr, mid, hi);
                    else if(arr[lo] < arr[mid])
                        return findMaxIndex(arr, lo, mid);
                }
            }
        }
        return -1;
    }
    
    public static int[] negative(int[] arr)
    {
        int[] tmpArr = new int[arr.length];
        int c=0;
        for(int e: arr)
        {
            tmpArr[c] = -e; 
            c++;
        }
        return tmpArr;
    }
        public static int findMinIndex(int[] arr, int lo, int hi)
    {
        return findMaxIndex(arr, lo, hi);    
    }
}
