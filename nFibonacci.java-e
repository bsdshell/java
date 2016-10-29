import java.io.*;
import java.lang.String;
class nFibonacci 
{
	public static void main(String args[])
	{
		int n=10;
		int[][] Arr = new int[2][2];
		int[][] A = nFibonacciNum2(Arr, n);
		System.out.println("A[1][0]=" + A[1][0]);

		int fib = nFibonacciNum1(n);
		System.out.println("fib=" + fib);
	}
	//O(n^2)
	public static int nFibonacciNum(int n)
	{
		if(n == 0)
			return 0;	
		else if(n==1)
			return 1;
		return nFibonacciNum(n-1)+nFibonacciNum(n-2);
	}

	//O(n)
	public static int nFibonacciNum1(int n)
	{
		int ret=0;
		if(n==0)
			ret = 0;
		else if(n==1)
			ret = 1;
		else 
		{ int a=0;
			int b=1;
			int c=1;
			int count=2;
			while(count <= n)
			{
				c = a + b;
				a = b;
				b = c;
				count++;
			}
			ret = c;
		}
		return ret;
	}
	//O(logn)
	public static int[][] nFibonacciNum2(int[][] A, int n)
	{
		if(n==0)
		{
			A[0][0] = 0;
			A[1][0] = 0;
			A[0][1] = 0;
			A[1][1] = 0;
			return A;
		}	
		else if(n==1)
		{
			A[0][0] = 1;
			A[1][0] = 1;
			A[0][1] = 1;
			A[1][1] = 0;
			return A;
		}
		else 
		{
			if(n%2 == 0)
				return MultiMat(nFibonacciNum2(A, n/2), nFibonacciNum2(A, n/2));
			else 
				return MultiMat(A, MultiMat(nFibonacciNum2(A, (n-1)/2), nFibonacciNum2(A, (n-1)/2)));
		}
	}
	public static int[][] MultiMat(int[][] A1, int[][] A2)
	{
		int[][] A = new int[2][2];

		A[0][0] = A1[0][0]*A2[0][0] + A1[0][1]*A2[1][0];
		A[1][0] = A1[1][0]*A2[0][0] + A1[1][1]*A2[1][0];
		A[0][1] = A1[0][0]*A2[1][0] + A1[0][1]*A2[1][1];
		A[1][1] = A1[1][0]*A2[0][1] + A1[1][1]*A2[1][1];
		return A;
	}
}
