import java.io.*;
import java.lang.String;
import java.util.*;

class Shuffle 
{
	public static void main(String args[])
	{
		int[] B = new int[10];
		for(int i=0; i<10; i++)
			B[i] = i;  

		for(int i=0; i<B.length; i++)
			System.out.print(B[i]+" ");

		System.out.println();

		int[] A = Shuffle(B);
		for(int i=0; i<B.length; i++)
			System.out.print(A[i]+" ");
		System.out.println();
        
        test1();
        test2();

	}
	public static int[] Shuffle(int[] A)
	{
		Random ran = new Random();
		if( A != null) {
			int len=A.length;
			if(len > 1)
			for(int i=0; i<len; i++) {
				int r = ran.nextInt(len) % (len-i);
				int tmp = A[r]; A[r] = A[len-1-i]; A[len-1-i] = tmp;
			}
		}
		return A;
	}

    // given string s and t of the same length
    public static String PerfectShuffle(String s, String t)
    {
        int n = s.length();    
        if(n <= 1) return s + t;
        
        String a = PerfectShuffle(s.substring(0, n/2), t.substring(0, n/2));
        String b = PerfectShuffle(s.substring(n/2, n), t.substring(n/2, n));
        return a + b;
    }
    public static void test1()
    {
        String s = "abc";
        String t = "efg";
        System.out.print("\n test1() \n");
        System.out.print("\n s=" + s + "\n");
        System.out.print("\n t=" + t + "\n");
        System.out.print("\n PerfectShuffle()=" + PerfectShuffle(s, t) + "\n");
    }
    public static void test2()
    {
        String s = "a";
        String t = "e";
        System.out.print("\n test2() \n");
        System.out.print("\n s=" + s + "\n");
        System.out.print("\n t=" + t + "\n");
        System.out.print("\n PerfectShuffle()=" + PerfectShuffle(s, t) + "\n");
    }
}
