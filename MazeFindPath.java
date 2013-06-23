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

        int[] path = new int[50];
        int level = 0;
        findAllPath(maze, row, col, path, level);
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
    public static void findAllPath(int[][] maze, int row, int col, int[] path, int level)
    {
        if(maze != null && row < maze.length && col < maze.length)
        {
               if(maze[row][col] == 3)
               {
                   path[level] = row*maze.length+col;
                   for(int i=0; i<=level; i++){
                       int r = path[i]/maze.length;
                       int c = path[i]%maze.length; 
                       System.out.println("["+r+"]["+c+"]");
                   }
                   System.out.println("");
               }
               if(maze[row][col] == 0)
               {
                   path[level]=row*maze.length + col;
                    findAllPath(maze, row, col+1, path, level+1);
                    findAllPath(maze, row+1, col, path, level+1);
               }
        }
    } 
}
