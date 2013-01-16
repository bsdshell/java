import java.io.*;

class MyHeap
{
	final int Max = 100;
	int[] Arr = new int[Max];
	int inx;
	int size;
	public MyHeap()
	{ inx = 0;}

	public void insert(int n)
	{
		if(inx < Max)
		{
			inx++;
			Arr[inx] = n;
			heapUp(inx);
		}
	}
	public void remove()
	{
		if(inx == 1)
			inx--;
		else if(inx > 1)
		{
			int tmp = Arr[1];
			Arr[1] = Arr[inx];
			inx--;
			heapDown(1);
			
		}
	}
	public void heapDown(int index)
	{
		int leftchild = index*2;
		int rightchild = index*2 + 1;

		if(rightchild <= inx)
		{
			if(Arr[leftchild] < Arr[rightchild])
			{
				if(Arr[index] > Arr[leftchild])
				{ int tmp = Arr[index];
					Arr[index] = Arr[leftchild];
					Arr[leftchild] = tmp;
					heapDown(leftchild);
				}
			}
			else
			{
				if(Arr[index] > Arr[rightchild])
				{ int tmp = Arr[index];
					Arr[index] = Arr[rightchild];
					Arr[rightchild] = tmp;
					heapDown(rightchild);
				}
			}
		}
		else
		{
			if(leftchild <= inx)
			{
				if(Arr[index] > Arr[leftchild])
				{ int tmp = Arr[index];
					Arr[index] = Arr[leftchild];
					Arr[leftchild] = tmp;
					heapDown(leftchild);
				}
			}
		}
	}

	public void heapUp(int index)
	{
		int parent = index/2;
		if(parent >= 1)
		{
			if(Arr[index] < Arr[parent])
			{
				int tmp = Arr[index];
				Arr[index] = Arr[parent];
				Arr[parent] = tmp;
				heapUp(parent);
			}
		}
	}
	public void show()
	{
		for(int i=1; i<=inx; i++)
		{
			System.out.println("Arr[" + i + "]=" + Arr[i]);
		}	
	}



}

class heap 
{
	public static void main(String args[])
	{
		MyHeap h = new MyHeap();
		h.insert(100);
		h.insert(11);
		h.show();
		h.remove();
		System.out.println("cool");
		h.show();

		System.out.println("cool");

	}
}
