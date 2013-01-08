import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
import java.lang.Number;
class biggest 
{
	public static void main(String args[])
	{
		int j = 0;
		String str= "2334343535";
		ArrayList<Integer> list = new ArrayList<Integer>();
		int len = str.length();
		char[] Ch = new char[len];
		if(len > 1)
		{
			for(int i = 0; i < len - 1; i++)
			{
				int a0 = str.charAt(i) - '0';
				int a1 = str.charAt(i + 1) - '0';
				int d = a1 - a0;
				if( d == 1)
				{
					System.out.println("d=" + d);	
					Ch[j] = str.charAt(i);
					j++;
				}
				else 
				{
					if(j > 0)
					{
						System.out.println("Ch=" + Ch);
						int num = Integer.parseInt(new String(Ch));
						System.out.println("num=" + num);
						list.add(num);
						j = 0;
					}
				}
			}
		}

	}
}
