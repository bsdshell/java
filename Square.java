import java.io.*;
class Square 
{
	public static void main(String args[])
	{
        double n = 0.9;
		sqrt(n);
        double value = sqrt2(n, 0.00001);
        System.out.println("real sqrt(value)=" + Math.sqrt(n));
        System.out.println("value=" + value);
	}
	public static double sqrt(double n)
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
    //Precondition: n is integer and greater than or equal zero 
    public static double sqrt2(double n, double error)
    {
        double left = 0;
        double right = n; 
        double value = 0;
        double diff = 2*error;
        while(Math.abs(diff) > error)
        {
            value = (left + right)/2;
            diff = value*value - n;
            if(diff > 0)
            {
                right = value;
            }
            else if(diff < 0)
            {
                left = value;
            }
            else
                break;
        }
        return value;
    }
}
