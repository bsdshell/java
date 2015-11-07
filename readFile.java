import java.io.*;
import java.lang.String;
import java.util.*;

//read file 
class readFile 
{
	public static void main(String args[])
	{
		try
		{
		  BufferedReader in = new BufferedReader(new FileReader("in.txt"));	
			
			String str;
			while((str = in.readLine()) != null)
			{
				System.out.println(str);
			}
			in.close();
		}
		catch(IOException io)
		{
            io.printStackTrace();
		}
	}
}
