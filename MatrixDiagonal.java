public class MatrixDiagonal 
{
				public static void main(String[] args)
				{
                    int[][] array = { {1, 2, 3, 4},
                                      {2, 3, 4, 5},
                                      {6, 7, 9, 8},
                                      {3, 2, 1, 2}
                                    };
                    int len = array.length;                      
                    for(int i=0; i<len; i++)
                    {
                        for(int j=0; j<len; j++)
                        {
                               System.out.print("["+array[i][j]+"]");
                        }
                       System.out.println("");
                    }

                    System.out.println("Print all diagonals of matrix");
                    printDiagonal(array);
				}
                //Given square matrix
                public static void printDiagonal(int[][] array)
                {
                    if(array != null)
                    {
                        int len = array.length;
                        for(int i=0; i<2*len-1; i++)
                        {

                                for(int j=0; j<len && j+i<len; j++)
                                {
                                    if(j == j+i)
                                    {
                                       System.out.print("["+array[j][j]+"]");
                                    }
                                }
                                if(i==0)
                                   System.out.println("");
                                for(int j=0; j<len && j+i < len; j++)
                                {
                                    if(j < j+i)
                                    {
                                        System.out.print("["+array[j][j+i]+"]");
                                    }
                                }
                                if(i != 0)
                                   System.out.println("");
                                for(int j=0; j<len && j+i<len; j++)
                                {
                                    if(j < j+i)
                                    {
                                        System.out.print("["+array[j+i][j]+"]");
                                    }
                                }
                                if(i != 0)
                                   System.out.println("");
                        }
                    }
                }
}
