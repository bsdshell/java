import java.io.*;
class wordcount 
{
	public static void main(String args[])
	{
		String str="a";
		int c = WordCount(str);
		System.out.println("c=" + c);

	}
	public static int WordCount(String str)
	{
		int c = 0;
		if(str != null)
		{
			if(str.length() == 1)
			{
				if(str.charAt(0) !=' ')
					c=1;
			}
			else
			{
				for(int i=1; i<str.length(); i++)
				{
					if(str.charAt(i-1) != ' ' && str.charAt(i) == ' ')
						c++;
				}
				if(str.charAt(str.length() - 1) != ' ')
					c++;
			}

		}	
		return c;
	}
}
