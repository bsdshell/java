import java.io.*;

class queue<T>
{
	class Node 
	{
		Node next;
		Node prev;
		T data;
		public Node(T d)
		{ data = d;}
	}

	Node head;
	Node tail;
	int limit;
	int size;
	public queue()
	{
		limit = 10;
		size=0;
	}
	public queue(int size)
	{ head = tail = null; limit=size;}
	public boolean isEmpty()
	{ return head == null;}
	public int size()
	{return size;}
	public T dequeue()
	{ T ret = null;
		if(!isEmpty())
		{ Node tmp = head;
			ret = head.data;
			if(head == tail)
			{ head.next = head.prev = null;
				head = tail = null;
			}
			else 
			{ head = head.next;
				tmp.next = tmp.prev = null;
			}
			size--;
		}
		return ret;
	}
	public void enqueue(T data)
	{
		Node no = new Node(data); 
		if(size() < limit)
		{
			if(isEmpty())
				head = tail = no;
			else 
			{ tail.next = no;
				no.prev = tail;
				tail = no;
			}
			size++;
		}
	}
}

class bqueue 
{
	queue<String> q;
	int limit;
	public bqueue(int size)
	{ 
		limit = size;
		q = new queue<String>(size);}

	public synchronized String dequeue()
		throws InterruptedException
	{
		if(q.size() == 0)
			wait();
		else if(q.size() == limit)
			notifyAll();
		return q.dequeue();
	}
	public synchronized void enqueue(String str)
		throws InterruptedException
	{
		if(q.size() == limit)
			wait();			
		else if(q.size() == 0)
			notifyAll();	
		q.enqueue(str);
	}
}
class myqueue 
{
	public static void main(String args[])
	{
		queue<String> q = new queue<String>();

		q.enqueue("dog");
		q.enqueue("cat");
		q.enqueue("cow");

		while(!q.isEmpty())
		{
			System.out.println(q.dequeue());
		}
	}
}
