public class Queen2 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        final int len = 4;
        final int width = 8;
        int[][] board = new int[len][len];
        for(int i=0; i<len; i++)
            for(int j=0; j<len; j++)
                board[i][j] = i*len+j;

        int[][] path = new int[width][2];
        int depth = 0;
        queen(path, width, depth);

    }
    public static boolean consistent(int[][] path, int width, int depth, int newRow)
    {
        if(path != null)
        {
            for(int i = 0; i < depth; i++)
            {
                int currCol = path[i][0];
                int currRow = path[i][1];
                if(currRow == newRow)
                    return false;
                else if(Math.abs(depth - currCol ) ==Math.abs(newRow - currRow))
                    return false;
            }
        }
        return true;
    }
    public static void queen(int[][] path, int width, int depth)
    {
        if(depth == width)
        {
            for(int i=0; i < depth; i++)
                System.out.println("["+path[i][0]+"]["+path[i][1]+"]");
            System.out.println("");
        }
        else 
        {
            for(int row=0; row < width; row++)
            {
                if(consistent(path, width, depth, row)) 
                {
                    path[depth][0] = depth;
                    path[depth][1] = row;
                    queen(path, width, depth+1);
                }
            }
        }
    }
}
