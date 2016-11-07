import java.io.*;
import java.lang.String;
import java.util.*;
class binperm 
{
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<String>();
		char[] charArr = {'1','a', 'b', 'c', 'c', 'c', 'a', 'k', 'e'};
		//char[] charArr = {'a'};
		int i=0;
		binperm(charArr, i, list);
		for(int j=0; j<list.size(); j++)
			System.out.println("list["+j+"]="+list.get(j));
	}
	

	public static void binperm(char[] charArr, int i, ArrayList<String> list)
	{
		if( charArr != null)
		{
			if(i < charArr.length)
			{
				if(('a' <= charArr[i] && charArr[i] <= 'z') || ('A' <= charArr[i] && charArr[i] <= 'Z'))
				{
					charArr[i] = Character.toUpperCase(charArr[i]);
					if(i == charArr.length-1)
					list.add(new String(charArr));
					binperm(charArr, i+1, list);

					charArr[i] = Character.toLowerCase(charArr[i]);
					if(i == charArr.length-1)
					list.add(new String(charArr));
					binperm(charArr, i+1, list);
				}
				else
				{
					if(i == charArr.length-1)
					list.add(new String(charArr));
					binperm(charArr, i+1, list);
				}
			}
		}
	}	
}
