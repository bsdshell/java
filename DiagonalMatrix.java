public class DiagonalMatrix 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[][] Array = {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                        };
        for(int i=0; i<Array.length; i++)
        {
            for(int j=0; j<Array[0].length; j++)
            {
                System.out.print("["+Array[i][j]+"]");
            }
            System.out.println("");
        }
        System.out.println("");
        DiagonalMatrix(Array);
        System.out.println("");
        DiagonalMatrixAll(Array);
    }
    public static void DiagonalMatrix(int[][] matrix)
    {
        if(matrix != null)
        {
            int rowLen = matrix.length;
            if(matrix[0] != null)
            {
                int colLen = matrix[0].length;
                for(int i=0; i<rowLen; i++)
                {
                    for(int j=0; j<colLen; j++)
                    {
                        if(j-i >= 0)
                            System.out.print("["+matrix[j][j-i]+"]");
                        else
                            System.out.print("[ ]");
                    }
                    System.out.println("");
                }
            }
        }
    }
    public static void DiagonalMatrixAll(int[][] matrix)
    {
        if(matrix != null)
        {
            int rowLen = matrix.length;
            if(matrix[0] != null){
                int colLen = matrix[0].length;
                for(int i=0; i<rowLen; i++){
                    for(int j=0; j<colLen; j++){
                        if(j==j+i){
                            System.out.print("["+matrix[j][j+i]+"]");
                        }
                        else{
                            if(i%2 == 1){
                                if(j+i < colLen)
                                    System.out.print("["+matrix[j][j+i]+"]");
                                else
                                    System.out.print("[ ]");
                            }
                            else{
                                if(j-i >= 0)
                                    System.out.print("["+matrix[j][j-i]+"]");
                                else 
                                    System.out.print("[ ]");
                            }
                        }
                    }
                    System.out.println(" ");
                }
            }
        }
    }
}
