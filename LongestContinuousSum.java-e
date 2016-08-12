public class LongestContinuousSum 
{
    public static void main(String[] args)
    {
        test0(); 
        test1(); 
        test2(); 
        test3(); 
        test4(); 
        test5(); 
        test6(); 
        test7(); 
        test8(); 
    }
    public static int Sum(int[] array)
    {
        int max = 0;
        if(array != null)
        {
            int len = array.length;
            int[] result = new int[len];
            if(len > 0)
            {
                result[0] = array[0];
                for(int i=1; i<len; i++)
                {
                    result[i] = result[i-1] + array[i] > array[i] ? result[i-1] + array[i] : array[i];
                }
                for(int i=0; i<len; i++)
                {
                    if(max < result[i])      
                        max = result[i];
                }
            }
        }
        return max;
    }

    public static void test0()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{-2, 8, -5, 20, 3, -2}; 
        int max = Sum(array);
        System.out.println("max=" + max);
    }

    public static void test1()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{1, -5, 8, -2}; 
        Aron.printArray(array);
        maxSumWithIndex(array);
        System.out.println();
    }

    public static void test2()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{1, -5, 8, 4, -2, 3, -1}; 
        Aron.printArray(array);
        maxSumWithIndex(array);
        System.out.println();
    }
    public static void test3()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{-2, 1, -5, 8, 4, -2, 3, -1}; 
        Aron.printArray(array);
        maxSumWithIndex(array);
        System.out.println();
    }
    public static void test4()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{-2, 4, 2}; 
        Aron.printArray(array);
        maxSumWithIndex(array);
        System.out.println();
    }
    public static void test5()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{-2, 4, 2, -8}; 
        Aron.printArray(array);
        maxSumWithIndex(array);
        System.out.println();
    }

    public static void test6()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{-2}; 
        Aron.printArray(array);
        maxSumWithIndex(array);
        System.out.println();
    }

    public static void test7()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{8}; 
        Aron.printArray(array);
        maxSumWithIndex(array);
        System.out.println();
    }
    public static void test8()
    {
        System.out.println("Hello World!");
        int[] array =new int[]{8, -1}; 
        Aron.printArray(array);
        maxSumWithIndex(array);
        System.out.println();
    }
    public static void maxSumWithIndex(int[] array)
    {
        if(array != null && array.length > 0)
        {
            int len = array.length;
            int[] maxArr = new int[len];
            maxArr[0] = array[0]; 

            int first = 0;
            int second = 0;
            int max = array[0];
            for(int i=1; i < len; i++)
            {
                maxArr[i] = Math.max(maxArr[i-1] + array[i], array[i]);            
                if(maxArr[i] > max)
                {
                    if(i-1 >=0 && maxArr[i-1] < 0)
                        first = i;
                    second = i;
                    max = maxArr[i];
                }
            }

            /*
            max = maxArr[0];
            for(int i=1; i<len; i++)
                if(maxArr[i] > max)
                    max = maxArr[i];
            */
            System.out.println("max=" + max);
            System.out.println("first=" + first);
            System.out.println("second=" + second);
        }
    }
}
