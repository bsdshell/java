public class Hello
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[][] array2d = new int[3][2];

        System.out.println("array2.length="+array2d.length);
        System.out.println("array2[0].length="+array2d[0].length);

        for(int i=0; i<3; i++)
            array2d[i] = fun();

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<2; j++)
                System.out.print("["+array2d[i][j]+"]");
            System.out.println();
        }

        test1();
        testParition();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    public static boolean manhattan(int[][] arr, int w, int h, int k, int num){
        const int isVisited = -1000; 
        boolean ret1 = false;
        boolean ret2 = false;
        boolean ret3 = false;
        boolean ret4 = false;
        if(arr[w][h] != isVisited){
            arr[w][h] =  isVisited;
            if( k == 0){
                return num == arr[w][h]
            }else{
                if(w + 1 < width){
                     int tmp = arr[w][h];
                     arr[w][h] = isVisited;
                     ret1 = manhattan(arr, w+1, h, k-1))
                     if(ret1)
                         return true;
                     arr[w][h] = tmp;
                 }

                if(w - 1 >= 0){
                     int tmp = arr[w][h];
                     arr[w][h] = isVisited;
                     ret2 = manhattan(arr, w-1, h, k-1);
                     if(ret2)
                         return true;
                     arr[w][h] = tmp;
                 }

                if(h - 1 >= 0){
                     int tmp = arr[w][h];
                     ret3 = manhattan(arr, w, h-1, k-1);
                     if(ret3)
                         return ret3;
                     arr[w][h] = tmp;
                 }

                 if(h + 1 < height){
                     int tmp = arr[w][h];
                     ret4 = manhattan(arr, w, h+1, k-1);
                     if(ret4)
                         return ret4;
                     arr[w][h] = tmp;
                 }
            }
        }
        return ret1 || ret2 || ret3 || ret4;
    }

    public static void test7()
    {
        System.out.println("test7"); 
        int[] arr1 = {3, 1, 4, 6, 2};                

        int lo = 0;
        int hi = arr1.length-1;
        mergeSort(arr1, lo, hi);
        Aron.printArray(arr1);  

    } 
    public static void test6()
    {
        System.out.println("test6"); 
        int[] arr1 = {3};                

        int lo = 0;
        int hi = arr1.length-1;
        mergeSort(arr1, lo, hi);
        Aron.printArray(arr1);  

    } 
    public static void test5()
    {
        System.out.println("test5"); 
        int[] arr1 = {3, 2};                

        int lo = 0;
        int hi = arr1.length-1;
        mergeSort(arr1, lo, hi);
        Aron.printArray(arr1);  

    } 
    public static void test4()
    {
        System.out.println("test4"); 
        int[] arr1 = {2, 3, 2, 3};                

        int lo = 0;
        int hi = arr1.length-1;
        mergeSort(arr1, lo, hi);
        Aron.printArray(arr1);  

    } 
    //[file=mergesort1.html title=""
    public static void mergeSort(int[] arr, int lo, int hi){
        if(lo < hi){
            int mid = (lo + hi)/2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid+1, hi);
            merge(arr, lo, mid, hi);
        }
    }
    public static void merge(int[] arr1, int lo, int mid, int hi){
        int len = hi - lo + 1; 
        int[] array = new int[len];
        if(len > 1){
            int i = lo;
            int j = mid+1;
            int k = 0;
            while(i <= mid || j <= hi){
                if(i > mid){
                    array[k] = arr1[j];
                    j++;
                }
                else if (j > hi){
                    array[k] = arr1[i];
                    i++;
                }
                else{
                    if(arr1[i] < arr1[j]){
                        array[k] = arr1[i];
                        i++;
                    }else{
                        array[k] = arr1[j];
                        j++;
                    }
                }
                k++;
            }
            for(int x=0; x<len; x++){
                arr1[x+lo] = array[x];
            }
        }
    }
    //]
    public static void testParition()
    {
        System.out.println("testParition"); 
        int[] arr1 = {2, 3};                

        int lo = 0;
        int hi = arr1.length-1;
        quickSort(arr1, lo, hi);
        Aron.printArray(arr1);  

    } 
    public static void test2()
    {
        System.out.println("test2"); 
        int[] arr1 = {2, 3};                

        int lo = 0;
        int hi = arr1.length-1;
        quickSort(arr1, lo, hi);
        Aron.printArray(arr1);  
    }
    public static void test3()
    {
        System.out.println("test3"); 
        int[] arr1 = {3, 2, 1, 5, 2, 6};                

        int lo = 0;
        int hi = arr1.length-1;
        quickSort(arr1, lo, hi);
        Aron.printArray(arr1);  
    } 
    public static void test1()
    {
        System.out.println("test1"); 
        int[] arr1 = {2};                

        int lo = 0;
        int hi = arr1.length-1;
        quickSort(arr1, lo, hi);
        Aron.printArray(arr1);  
    } 
    public static void quickSort(int[] arr, int lo, int hi){
        if(lo < hi){
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p-1);
            quickSort(arr, p+1, hi);
        }
    }
    public static int partition(int[] arr, int lo, int hi){
        int len = hi - lo + 1;
        int bigger = lo;
        if(len > 1){
            int pivot = arr[hi];
            for(int i=lo; i<len; i++){
                if(arr[i] < pivot){  
                    swap(arr, bigger, i);
                    bigger++;
                } 
            }
            swap(arr, bigger, hi);
        }
        return bigger;
    }
    public static void swap(int[] arr, int i, int j){
        int tmp  = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static int[] fun()
    {
        int[] array = {1, 2};
        return array;
    }
}
