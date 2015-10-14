import java.io.*;
import java.lang.String;
class PermRecursive 
{
	public static void main(String args[])
	{
		// Print the content on the console
		//System.out.println ("cool");
		int inx=0;
		char[] charArr={'a', 'b', 'c'};
		//char[] charArr={};
		//Permu(charArr, inx);
		//String s = removeChar("abcde", 2);
		//System.out.println ("s=" + s);
        
        int[][] array = { {1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}
        }; 
        
        int col = 0;
        printUpperTriangle(array, col);
	}

    //[ file=PermuteJava.html title=" Generate permutation for n characters"
	public static void Permu(char[] charArr, int inx)
	{
		if( charArr != null)
		{
			if(charArr.length == inx)
			{
				for(int i=0; i<charArr.length; i++)
					System.out.print(charArr[i]+" ");
				System.out.println();
			}
			else 
				for(int i=inx; i<charArr.length; i++)
				{
					char tmp = charArr[i];
					charArr[i] = charArr[inx];
					charArr[inx] = tmp;
					Permu(charArr, inx+1);

					tmp = charArr[i];
					charArr[i] = charArr[inx];
					charArr[inx] = tmp;
				}
		}
	}
    //]
    public static void printUpperTriangle(int[][] array, int col)
    {
        for(int row=col; row<array.length; row++)        
        {
            printUpperTriangle(array, col+1);
            System.out.println("[" + col + "][" + row+ "]=" + array[col][row]); 
        }
    }
}
