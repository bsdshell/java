import java.io.*;
import java.lang.String;
import java.util.*;

//read file 
class readFile 
{
    
	public static void main(String args[])
	{
	    readFile();	
	}
    public static void readFile(){
        try {
          // searchkey: read file line by line
		  BufferedReader in = new BufferedReader(new FileReader("input.txt"));	
			
			String str;
			while((str = in.readLine()) != null)
			{
				System.out.println(str);
			}
			in.close();
		}
		catch(IOException io) {
            io.printStackTrace();
		}
    }
}
