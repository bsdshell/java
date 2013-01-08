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
}
