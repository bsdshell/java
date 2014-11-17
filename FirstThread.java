import java.io.*;
import java.lang.String;
import java.util.*;

class RunnableThread implements Runnable
{
	public void run()
	{
		for(int i=0; i<5; i++)
		{
			System.out.println("ID=["+Thread.currentThread().getName()+"]i="+i);
			try{
			Thread.sleep(3000);
			}catch(InterruptedException e){}
		}
	}
}


class FirstThread 
{
	public static void main(String args[])
	{
		for(int i=0; i<4; i++)
		{
			Thread t1 = new Thread(new RunnableThread());
			t1.start();
		}
	}
}
