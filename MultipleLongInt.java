import java.io.*;

class MultipleLongInt
{
	public static void main(String args[])
	{
		System.out.println("cool");
		int[] A1 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9,9};
		int[] A2 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,9};
		int[][] S = Multiply(A1, A2);
	}
	public static int[][] Multiply(int[] A1, int[] A2)
	{
		int[][] S = null;
		if( A1 != null && A2 != null)
		{
			int len1 = A1.length;
			int len2 = A2.length;
			S = new int[len2][len2+len1];
			int[] total = new int[len1+len2+1];
			for(int i=0; i<len1; i++)
				for(int j=0; j<len1+len2; j++)
					S[i][j]=0;
			int c=0;
			int mod=0;
			for(int i=0; i<len2; i++)
			{
				int j=0;
				c = 0;
				mod=0;
				for(j=0; j<len1; j++)
				{
					mod = (c + A2[len2-1-i]*A1[len1-1-j])%10;
					c = 	(c + A2[len2-1-i]*A1[len1-1-j])/10;
					S[i][i+j] = mod;
				}
				if( c>0 )
				{
					S[i][i+j] = c;
				}
			}

			c = 0;
			int i=0;
			for(i=0; i<len1+len2; i++)
			{
				int sum=0;
				mod = 0;
				for(int j=0; j<len2; j++)
				{
						sum += S[j][i];
				}
				mod = (c + sum)%10;
				c   = (c + sum)/10;
				total[i] = mod;	
			}
			if(c>0)
				total[i]=c;	

			
			int len3 = total.length; 
			for(i=len3-1; i>=0 && total[i]==0; i--)
				;
			for(int k=0; k<(i+1)/2; k++)
			{
				int tmp = total[k];
				total[k] = total[(i+1)-1-k];
				total[(i+1)-1-k] = tmp;
			}
			

			for(i=0; i<len1+len2+1; i++)
			{
				System.out.print("["+total[i]+"]");
			}
			System.out.println();
			
			for(i=0; i<len2; i++)
			{ for(int j=0; j<(len2+len1); j++)
					System.out.print(S[i][j]+" ");
				System.out.println();
			}
		}
		return S;
	}
}
