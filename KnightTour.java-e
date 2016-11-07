
//Find a sequence of moves of a Knight on a chessboard such that the Knight visits each square only once 
public class KnightTour 
{
    public static void main(String[] args)
    {
        test1();
    }
    public static void test1()
    {
        int[][] board = new int[8][8];
        int count = 0;
        int c = 0;
        int r = 0;
        findPath(board, count, c, r);
    }
    public static void findPath(int[][] board, int count, int c, int r)
    {
        if(board != null)
        {
            if(count == 64)
            {
                Aron.printArray2D(board);
                System.exit(0);
            }
            else
            {
                board[c][r] = count+1;
                System.out.println("["+c+"]["+r+"] count="+count);

                if(c + 1 < 8 && r + 2 < 8 && board[c+1][r+2] == 0)
                    findPath(board, count+1, c+1, r+2);

                if(c + 2 < 8 && r + 1 < 8 && board[c+2][r+1] == 0)
                    findPath(board, count+1, c+2, r+1);

                if(c + 2 < 8 && r - 1 >= 0 && board[c+2][r-1] == 0)
                    findPath(board, count+1, c+2, r-1);

                if(c + 1 < 8 && r - 2 >= 0 && board[c+1][r-2] == 0)
                    findPath(board, count+1, c+1, r-2);

                if(c - 1 >= 0 && r - 2 >= 8 && board[c-1][r-2] == 0)
                    findPath(board, count+1, c-1, r-2);

                if(c - 2 >= 0 && r - 1 >= 0 && board[c-2][r-1] == 0)
                    findPath(board, count+1, c-2, r-1);

                if(c - 2 >= 0 && r + 1 < 8 && board[c-2][r+1] == 0)
                    findPath(board, count+1, c-2, r+1);

                if(c - 1 >= 0 && r + 2 < 8 && board[c-1][r+2] == 0)
                    findPath(board, count+1, c-1, r+2);

                board[c][r] = 0;
            }
        }
    }
}
