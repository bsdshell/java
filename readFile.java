import java.io.*;
import java.lang.String;
import java.util.*;
class readFile 
{
	public static void main(String args[])
	{
		try
		{
		  BufferedReader in = new BufferedReader(new FileReader("in.txt"));	
			
			String str;
			while( (str = in.readLine()) != null)
			{
				System.out.println(str);
			}
			in.close();
		}
		catch(Exception e)
		{
			System.err.println("Error" + e.getMessage());
		}
	}
}
