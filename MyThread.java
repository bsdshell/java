import java.io.*;
import java.lang.String;
import java.util.*;

class RunnableThread implements Runnable
{
	Thread runner;

	public RunnableThread()
	{
	}
	public RunnableThread(String name)
	{
		runner = new Thread(this, name);
		System.out.println(runner.getName());
		runner.start();
	}
	public void run()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(Thread.currentThread()+"i="+i);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println(Thread.currentThread());
			}
		}
	}
}

class MyThread 
{
	public static void main(String args[])
	{
		System.out.println("n2=");

		Thread thread1 = new Thread(new RunnableThread(), "thread1");
		Thread thread2 = new Thread(new RunnableThread(), "thread2");

		thread1.start();
		thread2.start();

		try
		{
			Thread.currentThread().sleep(1000);
		}
		catch(InterruptedException e)
		{
		}
		System.out.println(Thread.currentThread());
	}
}
