public class MergeSortArray 
{
    public static void main(String[] args)
    {
        System.out.println("Merge Sort Array");
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1()
    {
        int[] A = {3, 2, 1};
        int len = A.length;
        int lo = 0;
        int hi = len-1;

        for(int i=0; i<A.length; i++)
            System.out.print("{"+A[i]+"}");

        System.out.println();

        mergeSort(A, lo, hi);
        for(int i=0; i<A.length; i++)
            System.out.print("["+A[i]+"]");

        System.out.println();
    }

    public static void test2()
    {
        int[] A = {2, 1};
        int len = A.length;
        int lo = 0;
        int hi = len-1;

        for(int i=0; i<A.length; i++)
            System.out.print("{"+A[i]+"}");

        System.out.println();

        mergeSort(A, lo, hi);
        for(int i=0; i<A.length; i++)
            System.out.print("["+A[i]+"]");

        System.out.println();
    }

    public static void test3()
    {
        int[] A = {1};
        int len = A.length;
        int lo = 0;
        int hi = len-1;

        for(int i=0; i<A.length; i++)
            System.out.print("{"+A[i]+"}");

        System.out.println();

        mergeSort(A, lo, hi);
        for(int i=0; i<A.length; i++)
            System.out.print("["+A[i]+"]");

        System.out.println();
    }

    public static void test4()
    {
        int[] A = {10, 1, 9, 100, 6, 3, 3, 5};
        int len = A.length;
        int lo = 0;
        int hi = len-1;

        for(int i=0; i<A.length; i++)
            System.out.print("{"+A[i]+"}");

        System.out.println();

        mergeSort(A, lo, hi);
        for(int i=0; i<A.length; i++)
            System.out.print("["+A[i]+"]");

        System.out.println();
    }
    public static void merge(int[] A, int lo, int mid, int hi)
    {
        if( A != null)
        {
            int[] B = new int[hi-lo+1];

            int index1 = lo;
            int index2 = mid+1;
            int k=0;
            while(k < (hi-lo+1))
            {
                if(index1 > mid)
                {
                    B[k] = A[index2];
                    index2++;
                }
                else if(index2 > hi)
                {
                    B[k] = A[index1];
                    index1++;
                }
                else
                {
                    if(A[index1] < A[index2])
                    {
                        B[k] = A[index1]; index1++;
                    }
                    else
                    {
                        B[k] = A[index2]; index2++;
                    }
                }
                k++;
            }
            for(int i=0; i<B.length; i++)
                A[lo+i] = B[i];
        }
    }
    public static void mergeSort(int[] A, int lo, int hi)
    {
        if(lo<hi)
        {
            int mid = (lo+hi)/2;
            mergeSort(A, lo, mid);
            mergeSort(A, mid+1, hi);
            merge(A, lo, mid, hi);
        }
    }
}
