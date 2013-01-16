import java.io.*;
import java.lang.String;
import java.util.*;
class CountNBit 
{
	public static void main(String args[])
	{
		CountNBit(32);
		System.out.println();
		int n = CountNBit(10);
		System.out.println("n=" + n);
	}

	public static int CountNBit(int n)
	{
		/*
		for(int i=0; i<n; i++)
		{
			String bin = Integer.toBinaryString(i);
			System.out.println(String.format("%5s", bin));
		}
		*/
		
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else 
		{

			//a/2*x: half of column are 1
			//a is 2^floor(logn)
			//x = floor(logn)
			//
			//F(n-a): the number of 1 bit from 1 - 2^floor(logn)
			//
			//n-a+1 is the number of MSB from 2^floor(logn)-n
			//
			//F(n) = a/2*x + F(n-a) + n-a+1
			//
			int x = (int)Math.floor((double)Math.log(n)/(double)Math.log(2));
			int a = (int)Math.pow(2, x);
			return (a/2)*x + CountNBit(n-a) + (n-a+1);
		}
		
		
		
	}
}
