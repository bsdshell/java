/**
  * solve eight queen problem with backtrack 
  */
public class Queen 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        final int len = 4;
        int[][] board = new int[len][len];
        for(int i=0; i<len; i++)
            for(int j=0; j<len; j++)
                board[i][j] = i*len+j;

        int[] path = new int[len];
        int row = 0;
        queen(board, row, path);
    }
    public static void queen(int[][] board, int row, int[] path)
    {
        if(board != null && board[0] != null)
        {
            int len = board.length;
            for(int col = 0; col < len && row < len; col++)
            {
                if(consistent(path, row, col))
                {
                    //System.out.println("row["+row+"]");
                    path[row] = col;
                    queen(board, row+1, path);
                }
            }

            if(row == len)
            {
                for(int r=0; r<len; r++)
                {
                    for(int c=0; c<len; c++)
                    {
                        if(path[r] == c)
                            System.out.print("["+"x"+"]");        
                        else
                            System.out.print("["+"0"+ "]");        

                    }
                    System.out.println("");        
                }
                System.out.println("");        
            }
        }
    }
    public static boolean consistent(int[] path, int currentRow, int currentCol) 
    {
        boolean ret = true;
        if(path != null)
        {
            int len = path.length;
            for(int row=0; row < currentRow && ret; row++)
            {
                if(path[row] == currentCol)
                    ret = false;
                else if( Math.abs(currentRow - row ) == Math.abs(currentCol - path[row]))
                    ret = false;
            }
        }
        return ret;
    }
}
