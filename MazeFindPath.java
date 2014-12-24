public class MazeFindPath 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        /*
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
        //findAllPath(maze, row, col, path, level);
        //findPath(maze, row, col);
        int min=100;
        int[] minPath = new int[100];
        int m = findTheShortestPath(maze, col, row, path, minPath, level, min);
        for(int i=0; i<m; i++)
        {
            int c = minPath[i]/maze.length;
            int r = minPath[i]%maze.length;
            System.out.println("["+c+"]["+r+"]");
        }
        */

        test1();

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
                    if(findPath(maze, row, col+1))
                    { 
                       System.out.println("["+row+"]["+col+"]");
                       return true;
                    }
                    if(findPath(maze, row+1, col))
                    {
                       System.out.println("["+row+"]["+col+"]");
                       return true;
                    }
               }
        }
        return false;
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
    public static int findTheShortestPath(int[][] maze, int col, int row, int[] path, int[] minPath, int level, int min)
    {
        if( maze != null)
        {
            if(maze[col][row] == 3)
            {
                path[level] = col*maze.length+row;
                System.out.println("{"+col+"}{"+row+"}");
                System.out.println("minPath["+level+"]="+path[level]);
                if(level < min)
                {
                    min = level;                    
                    for(int i=0; i<=level; i++)
                    {
                        minPath[i] = path[i];
                    }
                }
            }
            else if(maze[col][row] == 0)
            {
                path[level] = col*maze.length+row;
                System.out.println("{"+col+"}{"+row+"}");
                maze[col][row] = 2;
                int r = 100, d = 100, l = 100, u = 100;
                if(row+1 < maze.length)
                    r = findTheShortestPath(maze, col, row+1, path, minPath, level+1, min);
                if(col+1 < maze.length)
                    d = findTheShortestPath(maze, col+1, row, path, minPath, level+1, min);
                if(row-1 > 0)
                    l = findTheShortestPath(maze, col, row-1, path, minPath, level+1, min);
                if(col-1 > 0)
                    u = findTheShortestPath(maze, col-1, row, path, minPath, level+1, min);
                min = Math.min(Math.min(r, d), Math.min(l, u));
            }
        }
        return min;
    }
    public static void test1()
    {
        int[][] maze = { 
                         {0,0, 4, 4, 0, 0},
                         {0,0, 0, 0, 0, 0},
                         {0,4, 0, 4, 4, 0},
                         {0,4, 0, 4, 0, 0},
                         {0,0, 0, 0, 4, 0},
                         {0,4, 4, 0, 0, 3}
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

        int[] path = new int[100];
        int[] minPath = new int[100];
        int level = 0;
        int min=100;

        int m = findTheShortestPath(maze, col, row, path, minPath, level, min);
        System.out.println("m["+m+"]");
        for(int i=0; i<=m; i++)
        {
            int c = minPath[i]/maze.length;
            int r = minPath[i]%maze.length;
            System.out.println("["+c+"]["+r+"]");
        }
    }
}
