import java.io.*;
import java.lang.String;
class PermRecursive 
{
	public static void main(String args[])
	{
		// Print the content on the console
		//System.out.println ("cool");
		int inx=0;
		char[] charArr={'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		//char[] charArr={};
		Permu(charArr, inx);
		//String s = removeChar("abcde", 2);
		//System.out.println ("s=" + s);
	}

	public static void Permu(char[] charArr, int inx)
	{
		if( charArr != null)
		{
			if(charArr.length == inx)
			{
				for(int i=0; i<charArr.length; i++)
					System.out.print(charArr[i]+" ");
				System.out.println();
			}
			else 
				for(int i=inx; i<charArr.length; i++)
				{
					char tmp = charArr[i];
					charArr[i] = charArr[inx];
					charArr[inx] = tmp;
					Permu(charArr, inx+1);

					tmp = charArr[i];
					charArr[i] = charArr[inx];
					charArr[inx] = tmp;
				}
		}
	}

}
