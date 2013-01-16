import java.io.*;
import java.lang.String;
import java.util.*;
class repeatingChar 
{
	public static void main(String args[])
	{
		boolean ret = checkRepeating("abcdb");
		System.out.println(ret);
	}
	public static boolean checkRepeating(String str)
	{
		boolean ret = false;
		if( str != null)
		{
			int len = str.length();
			int check = 0;
			int bit = 0;
			for(int i=0; i<len && !ret; i++) {
				int nleft = str.charAt(i) - 'a' + 1;
				check = 1<<nleft;
				if( (check & bit) > 0 ){
					ret = true;
				}
				else {
					bit = check | bit;
				}
			}
		}
		return ret;
	}
}
