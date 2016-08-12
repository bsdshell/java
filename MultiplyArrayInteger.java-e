import java.io.*;
import java.lang.String;
import java.util.*;
class MultiplyArrayInteger 
{
	public static void main(String args[])
	{
        test1();
        test2();
        test3();
	}
     
    //[ file = multiply.html title="multiple array"
    public static int[] multiply(int[] arr)
    {
        if(arr != null && arr.length > 1)
        {
            int len = arr.length;
            int[] A = new int[len];
            int[] B = new int[len];

            A[0] = 1;
            B[len-1] = 1;
            for(int i = 1; i < len; i++)
            {
                A[i] = arr[i-1]*A[i-1];
                B[len-1-i] = arr[len-1-i+1]*B[len-1-i+1];
            }
            
            for(int i = 0; i < len; i++)
                A[i] = A[i]*B[i];

            return A;
        }
        return null;
    }
    //]

    public static void test1()
    {
        int[] Arr={1, 2, 3, 4};
        int[] A = multiply(Arr);

		for(int i=0; i<A.length; i++)
				System.out.println("A["+i+"]=" + A[i]);
        System.out.println();
    } 
    public static void test2()
    {
        int[] Arr={1, 2};
        int[] A = multiply(Arr);

		for(int i=0; i<A.length; i++)
				System.out.println("A["+i+"]=" + A[i]);
        System.out.println();
    } 
    public static void test3()
    {
        int[] Arr={0, 2, 3};
        int[] A = multiply(Arr);

		for(int i=0; i<A.length; i++)
				System.out.println("A["+i+"]=" + A[i]);

        System.out.println();
    }
}
