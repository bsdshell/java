import java.io.*;
class GetCurrentPath 
{
	public static void main(String args[])
	{
					File currentPath = new File(new File(".").getAbsolutePath());
					System.out.println("absoluatepath="+currentPath.getAbsolutePath());
					try{
					System.out.println("canonicalpath="+currentPath.getCanonicalPath());
					}catch(IOException e)
					{
					}
	}
}
