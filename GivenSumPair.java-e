import java.io.*;
import java.util.*;
class GivenSumPair 
{
	public static void main(String args[])
	{
		int[] Arr = {7, 5, 6, 7, -10, 1};
		Pair(Arr, -9);

	}

	public static void Pair(int[] Arr, int sum)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<Arr.length; i++)
		{
			if(map.containsKey(new Integer(Arr[i])))
			{
				Integer v = map.get(new Integer(Arr[i]));
				int n = v.intValue(); n++;
				map.put(new Integer(Arr[i]), new Integer(n));
			}
			else
			{
				map.put(new Integer(Arr[i]), new Integer(1));
			}
		}

		for(int i=0; i<Arr.length; i++)
		{
			int diff = sum - Arr[i];
			if(map.containsKey(new Integer(diff)))
			{
				Integer v = map.get(new Integer(diff));
				int n = v.intValue();
				if(n > 0)
				{ System.out.println(diff + " " + Arr[i]);
					n--;
					map.put(new Integer(diff), new Integer(n));
				}
				Integer v1 = map.get(new Integer(Arr[i]));
				int n1 = v1.intValue();
				if(n1 > 0)
				{ n1--;
					map.put(new Integer(Arr[i]), new Integer(n1));
				}
			}
		}
	}
}
