import java.io.*;

class MultiplyLongInt
{
	public static void main(String args[])
	{
        test1();
        test2();
        test3();
        test4();
        test5();
	}
     
    //[file=multiplylong.html title="multiply long integer"
    public static int[] multiply(int[] arr1, int[] arr2)
    {
        if(arr1 != null && arr2 != null && arr1.length > 0 && arr2.length > 0)
        {
            int len1 = arr1.length;
            int len2 = arr2.length;
            Reverse(arr1);        
            Reverse(arr2);
            int[][] array = new int[len1][len1+len2];

            for(int i=0; i<len1; i++)
            {
                int carrying = 0;
                int j=0;
                for(j=0; j<len2; j++)
                {
                    int t = arr1[i]*arr2[j] + carrying;
                    array[i][j + i] = t % 10;
                    carrying = t / 10;
                }
                array[i][j + i] = carrying;
            }

            int[] total = new int[len1+len2];
            int carrying = 0;
            for(int i=0; i<len1 + len2; i++)
            {
                int s = 0;
                for(int j=0; j < len1; j++)
                {
                    s += array[j][i];
                }
                total[i] = (s + carrying) % 10; 
                carrying = (s + carrying) / 10;
            }
            Reverse(total);
            return total;
        }
        return null;
    }

    public static void Reverse(int[] A)
    {
        if(A != null)
        {
            int len = A.length;
            for(int i=0; i<len/2; i++)
            {
                int tmp = A[i];
                A[i] = A[len-1-i];
                A[len-1-i] = tmp;
            }
        }
    }
    //]

    public static void test1()
    {
        System.out.println("test1");
		int[] A = {9, 9, 9};
		int[] B = {9, 0, 9};
		int[] S = multiply(A, B);
        for(int i=0; i<S.length; i++)
            System.out.print("["+S[i]+"]");

        System.out.println();
    } 
    public static void test2()
    {
        System.out.println("test2");
		int[] A = {9, 9, 9};
		int[] B = {9, 9, 9};
		int[] S = multiply(A, B);

        for(int i=0; i<S.length; i++)
            System.out.print("["+S[i]+"]");

        System.out.println();
    } 
    public static void test3()
    {
        System.out.println("test3");
		int[] A = {9};
		int[] B = {9, 9, 9};
		int[] S = multiply(A, B);

        for(int i=0; i<S.length; i++)
            System.out.print("["+S[i]+"]");

        System.out.println();
    } 
    public static void test4()
    {
        System.out.println("test4");
		int[] A = {9};
		int[] B = {1};
		int[] S = multiply(A, B);

        for(int i=0; i<S.length; i++)
            System.out.print("["+S[i]+"]");

        System.out.println();
    }
    public static void test5()
    {
        System.out.println("test5");
		int[] A = {9, 9};
		int[] B = {9};
		int[] S = multiply(A, B);

        for(int i=0; i<S.length; i++)
            System.out.print("["+S[i]+"]");

        System.out.println();
    }
}
