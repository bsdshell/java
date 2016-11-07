public class CofactorMatrix 
{
				public static void main(String[] args)
				{
								System.out.println("Hello World!");
								int[][] A = {
															{1, 2},
															{3, 4}
														};

								int[][] B = cofactor(A, 1, 1);
								for(int r = 0;  B != null && r < B.length; r++)
								{
									for(int c = 0; c < B.length; c++)
									{
										System.out.print("["+B[r][c]+"]");
									}
									System.out.println();
								}
				}
				public static int[][] cofactor(int[][] A, int row, int col)
				{
					int len = 0;
					int[][] B = null; 
					if(A != null && (len = A.length) > 0 && row < len && col < len)
					{
						B = new int[len-1][len-1];
						int r1 = 0;
						for(int r = 0; r < len; r++)
						{
							if(r != row)
							{
								int c1 = 0;
								for(int c = 0; c < len; c++)
								{
									if(c != col)
									{
										B[r1][c1] = A[r][c];
										c1++;
									}
								}
								r1++;
							}
						}
					}
					return B;
				}
}
