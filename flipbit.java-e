import java.io.*;
import java.lang.String;
import java.lang.Math;
import java.util.*;
class flipbit 
{
	public static void main(String args[])
	{
		int num = 10;
		String numBin = Integer.toBinaryString(num);
		System.out.println("num=" + num);
		System.out.println("numBin=" + numBin);

		int n = flip(num);
		String nBin = Integer.toBinaryString(n);
		System.out.println("n=" + n);
		System.out.println("nBin=" + nBin);
	}
	public static int flip(int n)
	{
		int nbit = (int)Math.floor(Math.log(n)) + 1;
		return  ((int)Math.pow(2, nbit+1) - 1)^n;
	}
	
}
