import java.io.*;
class allprime 
{
	public static void main(String args[])
	{
		allprime(10000);
	}
	public static void allprime(int num)
	{
		boolean[] primeArr = new boolean[num+1];
		for(int i=2; i<=num; i++)
			primeArr[i] = true;	

		for(int i=2; i<=num; i++)
			for(int j=i; i*j<=num; j++)
				primeArr[i*j] = false;

		int count=1;
		for(int i=2; i<=num; i++)
		{
			if(primeArr[i])
			{
				System.out.print(String.format("%6d", i));
				if(count%30==0)	
					System.out.println();
				count++;
			}
		}
		System.out.println();
	}
}
