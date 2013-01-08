import java.io.*;
class setbit 
{
	public static void main(String args[])
	{
		int num = 100;
		String n = Integer.toBinaryString(num);
		System.out.println(num+"=" + n);

		isSetBit(100, 2);
		
	}
	public static void isSetBit(int num, int k)
	{
		int bit = 1<<k;
		if((bit & num) > 0)
			System.out.println("set bit in " + k);
		else 
			System.out.println("does not set bit in " + k);
	}
}
