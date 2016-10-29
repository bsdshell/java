import Lib.*;

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
        test8();
        test9();
    }

    public static void test8()
    {
        System.out.println("test8"); 
        String str = "abcde";
        int k=0;
        int p=0;
        Integer num = new Integer(0);
        dump(str, k, p, num);
    } 
    public static void test9()
    {
		BST b1 = new BST();
		b1.Insert(15);
		b1.Insert(12);
        Node prev = null;
        boolean isbst = isBST(b1.root, prev);
        System.out.println("isbst=" + isbst);

    } 
    public static void dump(String str, int k, int p, Integer num){
        if(k < str.length()){
            dump(str, k+1, p, num);
        }
        else if(k == str.length()){
            num = new Integer(3); 
            p = 10;
        }
        if(k < str.length())
            System.out.println("charAt [" + k + "]=" + str.charAt(k));
        System.out.println("p=" + p + "  num=" + num);
    }

    public static boolean isBST(Node root, Node prev)
    {
        if( root != null)
        {
            if(!isBST(root.left, prev))
                return false;
            if(prev != null && prev.data >= root.data)
                return false;
            if(!isBST(root.right, root))
                return false;
        }
        return true;
    }

    public static void kdistance(Node r, int k){
        
        if(r != null){
            if(k == 0)
                System.out.println(r.data);
            else{
                kdistance(r.left, k-1);
                kdistance(r.right, k-1);
            }
        }
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
