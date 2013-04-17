public class LCS 
{
				public static void main(String[] args)
				{
								System.out.println("Hello World!");
								char[] A = {'a', 'b', 'c', 'd'}; 
								char[] B = {'a', 'c'}; 
								char[] Arr = new char[10];
								int i = A.length;
								int j = B.length;
								int k = 0;
								LCS(A, i, B, j, Arr, k); 
								for(int x=0; x<2; x++)
								{
									System.out.println("Arr["+x+"]="+Arr[x]);
								}
				}
				static int LCS(char[] A, int i, char[] B, int j, char[] Arr, int k)
				{
					if(i == 0 || j == 0)
					{
						return 0;
					}
					else if(A[i-1] == B[j-1])
					{
						Arr[k]=A[i-1];
						return LCS(A, i-1, B, j-1, Arr, k+1)+1;
					}
					else
					{
						return LCS(A, i-1, B, j, Arr, k)>LCS(A, i, B, j-1, Arr, k)?LCS(A, i-1, B, j, Arr, k):LCS(A, i, B, j-1, Arr, k);
					}
				}
}
