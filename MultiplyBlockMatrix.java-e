public class MultiplyBlockMatrix
{
    public static void main(String[] args)
    {
        System.out.println("Multiply Block Matrix!");
    }
    public static int[][] multiply(int[][] A, int col_lo_a, int col_hi_a, 
                                              int row_lo_a, int row_hi_a,
                                    int[][] B,int col_lo_b, int col_hi_b,
                                              int row_lo_b, int row_hi_b)
    {
        int[][] C = null;
        int col_mid_a = (col_lo_a + col_hi_a)/2;
        int row_mid_a = (row_lo_a + row_hi_a)/2;
        int col_mid_b = (col_lo_b + col_hi_b)/2;
        int row_mid_b = (row_lo_b + row_hi_b)/2;

        int[][] a11 = multiply(A, B, col_lo_a, col_mid_a, row_lo_a, row_mid_a,
                                     col_lo_b, col_mid_b, row_lo_b, row_mid_b);

        int[][] a12 = multiply(A, B, col_mid_a, col_hi_a, row_lo_a, row_mid_a, 
                                     col_mid_b, col_hi_b, row_lo_b, row_mid_b);
        int[][] a21 = multiply(A, B, col_lo_a,  col_mid_a,row_mid_a,row_hi_a,
                                     col_lo_b,  col_mid_b,row_mid_b,row_hi_b);
        int[][] a22 = multiply(A, B, col_mid_a, col_hi_a, row_mid_a,row_hi_a,
                                     col_mid_b, col_hi_b, row_mid_b,row_hi_b);
        return C;
    }
}
