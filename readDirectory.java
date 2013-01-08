import java.io.*;
import java.lang.String;
import java.util.*;
class readDirectory 
{
	public static void main(String args[])
	{
		File dir = new File("/home");
		String fname[] = dir.list();
		for(int i=0; i<fname.length; i++)
		{
			System.out.println(fname[i]);
		}

	}
}
