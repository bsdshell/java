import java.io.*;
import java.lang.String;
import java.util.*;
class writeFile 
{
	public static void main(String args[])
	{
		try
		{
			FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("hello java");
			out.close();
		}
		catch(Exception e)
		{
			System.err.println("Error" + e.getMessage());
		}
	}
}
