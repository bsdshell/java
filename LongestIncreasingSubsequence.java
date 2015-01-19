public class LongestIncreasingSubsequence 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        //int[] array = {20, 1, 30, 6, 40, 4, 0, 9, 10, 12};
        int[] array = {1, 0, 7, 2, 6};
        //int[] array = {1, 2};
        //int[] array = {2, 6, 1, 4, 5};
        int m = LISDP(array);
        int len = array.length;
        for(int i=0; i<array.length; i++)
        {
           System.out.print("["+i+"]{"+array[i]+"} "); 
        }
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
    }


    //L[i] = 1 + Max(L[i-1]) where j < i && arr[j] < arr[i]
    public static int LISRecursion_debug(int[] array, int len)
    {
        if(len == 1)
            return 1;
        else
        {
            int max = 1;
            for(int i=1; i < len; i++)
            {
                int m = LISRecursion_debug(array, i);
                System.out.print("array["+(i-1)+"]="+array[i-1]+" array["+(len-1)+"]="+array[len-1]+"\n");
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
    public static int LISRecursion(int[] array, int len)
    {
        if(len == 1)
            return 1;
        else
        {
            int max = 1;
            for(int i=1; i < len; i++)
            {
                int m = LISRecursion(array, i);
                if(array[i-1] < array[len-1])
                    max = Math.max(max, m+1);
            }
            System.out.println();
            return max;
        }
    }

    public static void LISTree(int[] array, int len)
    {
        if(len == 1)
        {
            //System.out.println("["+array[len-1]+"]");
        }
        else
        {
            for(int i=1; i<len; i++)
            {
                LISTree(array, i);
                System.out.println("["+array[i-1]+"]->["+array[len-1]+"]");
            }
        }
    }
    public static int LISRecursion2(int[] array, int len)
    {
        int max = 1;
        if(len == 1)
            return max;
        else 
        {
            for(int i=1; i<len; i++)
            {
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
    public static int LISDP(int[] array)
    {
        int len = array.length;
        int[] maxlist = new int[len];
        for(int i=0; i<len; i++)
            maxlist[i] = 1;

        for(int i=1; i<len; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(array[j] < array[i])            
                    maxlist[i] = Math.max(1 + maxlist[j], maxlist[i]);
            }            
        } 
        
        int m = Integer.MIN_VALUE;
        for(int i=0; i<len; i++)
        {
            if(maxlist[i] > m)
                m = maxlist[i];
        }
        return m;
    }
}
