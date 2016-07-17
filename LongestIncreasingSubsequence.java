import classfile.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //test0();
        test1();
        test2();
        test3();
        test4();
    }

    static void test0() {
        Aron.beg();
        Integer[] array = {1, 0, 7, 2, 6};
        int len = array.length;
        Aron.printArray(array);
        int m = LISDP(array);

        System.out.println();
        int recm = LISRecursion(array, len);
        int len2 = array.length;
        System.out.println("==========================");
        int recm2 = LISRecursion2(array, len2);
        System.out.println("max LIS=["+m+"]");
        System.out.println("max LISRecursion=["+recm+"]");
        System.out.println("max LISRecursion2=["+recm2+"]");
        System.out.println("==========================");
        LISTree(array, len2);

        Aron.end();
    }

    static void test1() {
        Aron.beg();
        Integer[] array = {1, 0, 7, 2, 6};
        Aron.printArray(array);
        int len = array.length;
        int max = LISRecursion(array, len);

        System.out.println("LISRecursion=["+ max +"]");
        Aron.end();
    }
    static void test2() {
        Aron.beg();
        Integer[] array = {1, 0, 7, 2, 6};
        Aron.printArray(array);
        int len = array.length;
        int max = LISRecursion2(array, len);
        System.out.println("LISRecursion2=["+ max +"]");

        Aron.end();
    }

    static void test3() {
        Aron.beg();

        Integer[] array = {1, 0, 7, 2, 6};
        int len = array.length;
        Aron.printArray(array);
        LISTree(array, len);

        Aron.end();
    }

    static void test4() {
        Aron.beg();

        Integer[] array = {1, 0, 7, 2, 6};
        int len = array.length;
        Aron.printArray(array);
        LISRecursion_debug(array, len);

        Aron.end();
    }

    //L[i] = 1 + Max(L[i-1]) where j < i && arr[j] < arr[i]
    public static int LISRecursion_debug(Integer[] array, int len) {
        if(len == 1)
            return 1;
        else {
            int max = 1;
            for(int i=1; i < len; i++) {
                int m = LISRecursion_debug(array, i);
                //System.out.print("array["+(i-1)+"]="+array[i-1]+" array["+(len-1)+"]="+array[len-1]+"\n");
                System.out.print("("+ array[i-1] + " , "+ array[len-1] + ")");
                if(array[i-1] < array[len-1])
                    max = Math.max(max, m+1);
                //System.out.println("max=["+max+"]");
            }
            System.out.println();
            return max;
        }
    }


    //Find the longest increasing subsequence integers
    //{2, 4, 1, 5} => 2->4->5
    //{2, 4, 1, 2, 3} => 1->2->3
    //L[i] = 1 + Max(L[i-1]) where j < i && arr[j] < arr[i]
    public static int LISRecursion(Integer[] array, int len) {
        if(len == 1)
            return 1;
        else {
            int max = 1;
            for(int i=1; i < len; i++) {
                int m = LISRecursion(array, i);
                if(array[i-1] < array[len-1])
                    max = Math.max(max, m+1);
            }
            System.out.println();
            return max;
        }
    }

    public static void LISTree(Integer[] array, int len) {
        if(len == 1) {
            //System.out.println("["+array[len-1]+"]");
        } else {
            for(int i=1; i<len; i++) {
                LISTree(array, i);
                System.out.println("["+array[i-1]+"]->["+array[len-1]+"]");
            }
        }
    }
    public static int LISRecursion2(Integer[] array, int len) {
        int max = 1;
        if(len == 1)
            return max;
        else {
            for(int i=1; i<len; i++) {
                int m = LISRecursion2(array, len-1);
                System.out.print("array["+(i-1)+"]="+array[i-1]+" array["+(len-1)+"]="+array[len-1]+"\n");
                if(array[i-1] < array[len-1])
                    max = Math.max(max, m+1);
            }
            System.out.println("-----------------------");
        }
        return max;
    }

    //Dynamic programming algorithm solves Longest Increasing Subsequence
    //with complexity O(n^2)
    public static int LISDP(Integer[] array) {
        int len = array.length;
        int[] maxlist = new int[len];
        for(int i=0; i<len; i++)
            maxlist[i] = 1;

        for(int i=1; i<len; i++) {
            for(int j=0; j<i; j++) {
                if(array[j] < array[i])
                    maxlist[i] = Math.max(1 + maxlist[j], maxlist[i]);
            }
        }

        int m = Integer.MIN_VALUE;
        for(int i=0; i<len; i++) {
            if(maxlist[i] > m)
                m = maxlist[i];
        }
        return m;
    }
}
