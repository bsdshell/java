import java.io.*;
class Square 
{
	public static void main(String args[])
	{
		sqrt(10);
	}
	public static double sqrt(int n)
	{
		double a = 1.0;
		double b = n/2;

		
		for(int i = 0; i < 10; i++)
		{
			if( ((a + b)/2)*((a + b)/2) > n)
			{
				b = (a + b)/2;
			}
			else if( ((a + b)/2)*((a + b)/2) < n)
			{
				a = (a + b)/2;
			}
			else if( ((a + b)/2)*((a + b)/2) == n)
			{

			}
			System.out.println("a=" + a + " b=" + b);
		}
		return a;	
	}
}
