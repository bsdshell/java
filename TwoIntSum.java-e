import java.io.*;
import java.lang.String;
import java.util.*;
class TwoIntSum
{
	public static void main(String args[])
	{
		int[] Arr={1, 2, 3, 3, 3, 3, 1, 5, 2, 4};
		TwoIntSum(Arr, 6);
	}
	//list has repeating numbers
	public static void TwoIntSum(int[] Arr, int sum)
	{
		if(Arr != null)
		{
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int len = Arr.length;
			int[] diffArr = new int[len];

			for(int i=0; i<len; i++)
			{ diffArr[i] = sum - Arr[i]; 
				if(map.containsKey(new Integer(Arr[i])))
				{ int val = map.get(new Integer(Arr[i])).intValue();
					val++;
					map.put(new Integer(Arr[i]), new Integer(val));
				}
				else
					map.put(new Integer(Arr[i]), new Integer(1)); 
			}

			for(int i=0; i<len; i++)
			{ if(map.containsKey(new Integer(diffArr[i])))
				{ int val = map.get(new Integer(diffArr[i])).intValue();
					if(val>0)
					{ val--;
						map.put(new Integer(diffArr[i]), val);

						int pair = sum - diffArr[i];	
						if(map.containsKey(new Integer(pair)))
						{
							int pval = map.get(new Integer(pair)).intValue();
							if(pval > 0)
							{
								pval--;
								map.put(new Integer(pair), pval);
								System.out.println("["+i+"]="+diffArr[i]);
								System.out.println("pair="+pair);
							}
						}
					}
				}
			}
		}	 //end if
	}//end TwoIntSum()
}
