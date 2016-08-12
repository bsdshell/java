import java.io.*;
import java.util.Vector;
import java.lang.String;
/*
 * remove whitespace, and concatenate words to line and each line had less than or equal to 10 characters and each word can't been split 
 *
*/ 
class splitword 
{
	public static void main(String args[])
	{
		String str = "what are you going to do that? well. I have no idea!";
		Vector<String> vet = splitword(str);
		for(int i=0; i<vet.size(); i++)
			System.out.println("["+vet.get(i)+"]");
		
	}
	public static Vector<String> splitword(String str)
	{
	 	Vector<String> vet = new Vector<String>();	
		if( str != null && str.length() > 0)
		{
			int len = str.length();
			String s="";
			String line="";
			int sum=0;
			for(int i=0; i<len-1; i++)
			{
				if(str.charAt(i) != ' ' && str.charAt(i+1) ==' ') {
					s += str.charAt(i)+"";
					vet.add(s);	
					if(sum + s.length() <= 10) {
						line += s;
						sum += s.length();
					}
					else {
						line += "\n"+s;
						sum = s.length();
					}
					s="";
				}
				else if(str.charAt(i) != ' ' && str.charAt(i+1) != ' ')
					s += str.charAt(i)+"";
			}
			if(str.charAt(len-1) != ' ')
			{
				s += str.charAt(len-1);
				if(sum + s.length() <=10) {
					line += s;
					sum += s.length();
				}
				vet.add(s);	
			}
			System.out.println("line="+line);
		}
	
		return vet;
	}
}
