public class MazeFindPath 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[][] maze = { {0,0, 4, 4},
                         {4,0, 0, 0},
                         {4,0, 4, 0},
                         {4,0, 0, 3}
                        }; 
        int row = 0;
        int col = 0;
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze.length; j++)
            {
                System.out.print("["+maze[i][j]+"]");
            }
            System.out.println();
        }

        findPath(maze, row, col);
    }
    public static boolean findPath(int[][] maze, int row, int col)
    {
        if(maze != null && row < maze.length && col < maze.length)
        {
               if(maze[row][col] == 3)
               {
                   System.out.println("["+row+"]["+col+"]");
                   return true;
               }
               if(maze[row][col] == 0)
               {
                    maze[row][col] = 2;
                    if(findPath(maze, row, col+1) == true){ 
                       System.out.println("["+row+"]["+col+"]");
                       return true;
                    }
                    if(findPath(maze, row+1, col) == true){
                       System.out.println("["+row+"]["+col+"]");
                       return true;
                    }
                    return false;
               }else{
                   return false;
               }
        }
        else
        {
            return false;
        }
    }
}
