public class MatrixMultiNew 
{
    public static void main(String[] args)
    {
        System.out.println("New Algorithm for Matrix Multiplication!");
        int[][] A = {{1, 2},
                     {3, 4}}; 
        int[][] B = {{2, 3},
                     {4, 5}}; 

        int[][] C = Multiply(A, B);
        for(int i=0; i<C.length; i++)
        {
            for(int j=0; j<C.length; j++)
            {
                System.out.print("["+C[i][j]+"]");
            }
            System.out.println();
        }
    }
    public static int[][] Multiply(int[][] A, int[][] B)
    {
        int[][] C = null;
        if(A != null && B != null)
        {
            C = new int[A.length][A.length];
            for(int i=0; i<A.length; i++)
            {
                for(int j=0; j<A.length; j++)
                {
                    for(int k=0; k<A.length; k++)
                    {
                        
                         C[k][j] += A[k][i]*B[i][j];
                    }
                }
            }
        }
        return C;
    }

}
