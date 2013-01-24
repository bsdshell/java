public class MatrixMulti 
{
				public static void main(String[] args)
				{
								System.out.println("Hello World!");
								int[][] A = {{1, 1},
														 {0, 1}};
								int[][] B = {{2, 0},
														 {0, 3}};
								int[][] C = multiply(A, B);
								for(int i=0; C != null && i < C.length; i++)
								{
									for(int j=0;  C != null && j < C.length; j++)
									{
										System.out.print("["+C[i][j]+"]");
									}
									System.out.println("");
								}
				}
				public static int[][] multiply(int[][] A, int[][] B)
				{
					int[][] C = null;
					if( A != null && B != null)
					{
						int alen = A.length;
						int blen = B.length;
						int clen = alen;
						C = new int[alen][alen];
						for(int c = 0; c < clen; c++)
						{
							for(int i = 0; i < alen; i++)
							{
								int s = 0;
								for(int j = 0; j < blen; j++)
								{
									s += A[i][j]*B[j][c];	
								}
								C[i][c] = s;
							}
						}
					}
					return C;
				}
}
