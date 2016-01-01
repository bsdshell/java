public class ManhattanProblem 
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
        test8();
        test9();
        test10();
        test11();
    }

    public static void test8()
    {
        System.out.println("test8");
        int[][] arr = { 
            {1,3,3},
            {0,3,9},
            {0,3,1}
        };

        int height = arr.length;
        int width = arr[0].length;

        int k = 3;
        boolean ret = false; 
        for(int h=0; h<height && !ret; h++){ 
            for(int w=0; w<width && !ret; w++){
                ret = manhattan(arr, h, w, k, arr[h][w]); 
                System.out.println("ret =" + ret);
            }
        }
        System.out.println("--ret =" + ret);
    }

    public static void test11()
    {
        System.out.println("test11");
        int[][] arr = { 
            {0,3,1},
            {0,1,4},
            {7,1,1}
        };

        int height = arr.length;
        int width = arr[0].length;

        int k = 4;
        boolean ret = false; 
        for(int h=0; h<height && !ret; h++){ 
            for(int w=0; w<width && !ret; w++){
                int num = arr[h][w];
                ret = manhattan(arr, w, h, k, num); 
                System.out.println("ret =" + ret);
            }
        }
        System.out.println("--ret =" + ret);
    }

    public static void test10()
    {
        System.out.println("test10");
        int[][] arr = { 
            {1,3,6},
            {0,4,4},
            {7,9,1}
        };

        int height = arr.length;
        int width = arr[0].length;

        int k = 4;
        boolean ret = false; 
        for(int h=0; h<height && !ret; h++){ 
            for(int w=0; w<width && !ret; w++){
                int num = arr[h][w];
                ret = manhattan(arr, w, h, k, num); 
                System.out.println("ret =" + ret);
            }
        }
        System.out.println("--ret =" + ret);
    }

    public static void test9()
    {
        System.out.println("test9");
        int[][] arr = { 
            {1,3,6},
            {0,4,4},
            {7,9,1}
        };

        int height = arr.length;
        int width = arr[0].length;

        int k = 1;
        boolean ret = false; 
        for(int h=0; h<height && !ret; h++){ 
            for(int w=0; w<width && !ret; w++){
                int num = arr[h][w];
                ret = manhattan(arr, w, h, k, num); 
                System.out.println("ret =" + ret);
            }
        }
        System.out.println("--ret =" + ret);
    } 

    public static boolean manhattan(int[][] arr, int h, int w, int k, int num){
        final int isVisited = -1000; 
        boolean ret0 = false;
        boolean ret1 = false;
        boolean ret2 = false;
        boolean ret3 = false;
        boolean ret4 = false;
        int height = arr.length;
        int width = arr[0].length;

        if( k == 0){
            ret0 = num == arr[h][w];
        }else if(arr[h][w] != isVisited){
            int tmp = arr[h][w];
            arr[h][w] =  isVisited;
            if(w + 1 < width){
                 arr[h][w] = isVisited;
                 ret1 = manhattan(arr, h, w+1,k-1, num);
                 arr[h][w] = tmp;
                 if(ret1)
                     return ret1;
             }

            if(w - 1 >= 0){
                 arr[h][w] = isVisited;
                 ret2 = manhattan(arr,  h, w-1,k-1, num);
                 arr[h][w] = tmp;
                 if(ret2)
                     return ret2;
             }

            if(h - 1 >= 0){
                 ret3 = manhattan(arr,  h-1, w, k-1, num);
                 arr[h][w] = tmp;
                 if(ret3)
                     return ret3;
             }

             if(h + 1 < height){
                 ret4 = manhattan(arr, h+1, w, k-1, num);
                 arr[h][w] = tmp;
                 if(ret4)
                     return ret4;
             }
        }
        return ret0 || ret1 || ret2 || ret3 || ret4;
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
