import java.util.*;

class Point{
    int x;
    int y;
    int z;
    public Point(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class landscape 
{
	public static void main(String[] args)
    {
        test_question1();
        test0_question21();
        test_question21();
        test_question22();
        test0_question3();
        test1_question3();
        test2_question3();
        test3_question3();
        test4_question3();
    }
    
    static void test_question1()
    {
        System.out.println("===================================================");
        System.out.println("Question(1) Find all the lakes in the landscape");
        System.out.println("test_question1()");
        int w = 10;
        int[][] F = {
            {0, 1},
            {1, 0}
        };
        System.out.println("w="+w);
        printArray2D(F);
        int col=0, row=0;
        List<List<Point>> listList = new ArrayList<List<Point>>(); 
        int count = countLake(F, listList, w);
        printListList(listList);
        System.out.println("Numbers of lake = "+listList.size());
        System.out.println();
    }

    static void test0_question21()
    {
        System.out.println("===================================================");
        System.out.println("Question(2.1) Find the lake with largest surface area");
        System.out.println("test0_question21()");
        final int w=0;
        int[][] G = {   {2, 9, 1, 4},
                        {9, 9, 9, 9},
                        {9, 1, 0, 5},
                        {8, 3, 2, 4}
                    };

        System.out.println("w="+w);
        printArray2D(G);
        //Threshold
        int max = maxArea(G, w);
        System.out.println("Max area=["+max+"]");
        System.out.println();
    }

    static void test_question21()
    {
        System.out.println("===================================================");
        System.out.println("Question(2.1) Find the lake with largest surface area");
        System.out.println("test_question21()");
        final int w=5;
        int[][] G = {   {2, 9, 1, 4},
                        {9, 9, 9, 9},
                        {9, 1, 0, 5},
                        {8, 3, 2, 4}
                    };

        System.out.println("w="+w);
        printArray2D(G);
        //Threshold
        int max = maxArea(G, w);
        System.out.println("Max area=["+max+"]");
        System.out.println();
    }

	static void printListList(List<List<Point>> listList)
    {
        System.out.println("lake:(x, y, z)");
        int count = 1;
        for(List<Point> list:listList)
        {
            System.out.print("lake:"+count+"=");
            for(Point t:list)
            {
                System.out.print("("+t.x+" "+" "+t.y+" "+t.z+")");
            }
            count++;
            System.out.println();
        }
    }

    static void test_question22()
    {
        System.out.println("===================================================");
        System.out.println("test_question22");
        System.out.println("Questions(2.2) find the lake with largest volumn of water");
        //Threshold
        final int w=5;
        System.out.println("w="+w+"");

        int[][] G = {   {2, 9, 1, 4},
                        {9, 9, 9, 9},
                        {9, 1, 9, 5},
                        {4, 3, 9, 4}
                    };
        printArray2D(G);
        
        int max = maxVolumn(G, w);
        System.out.println("Max volumn=["+max+"]");
    }

    //Count the numbers of point(each lake) in the landscape
	static int landscapeLake(int[][] land, int x, int y, List<Point> lake, int w)
	{
		if(land != null && land[0] != null)
		{
            if(land[x][y] >= 0 && land[x][y] < w)
            {
                int up=0, down=0, right=0, left=0;
                if(lake != null)
                    lake.add(new Point(x, y, land[x][y]));

                land[x][y] = -1;

                if(x+1 < land.length)
                    up = landscapeLake(land, x+1, y, lake, w);	
                if(x-1 >= 0)
                    down = landscapeLake(land, x-1, y, lake, w);	
                if(y+1 < land.length)
                    right = landscapeLake(land, x, y+1, lake, w);	
                if(y-1 >= 0)
                    left = landscapeLake(land, x, y-1, lake, w);	

                return right + left + down + up + 1;
            }
		}
        return 0;
	}

    //Calculate the maximum area of a lake
    static int maxArea(int[][] land, int w)
    {
        int max=0;
        if(land != null && land[0] != null)
        {
            for(int i=0; i<land.length; i++)   
            {
                for(int j=0; j<land[0].length; j++)
                {
                    if(land[i][j] < w)
                    {
                        int a = area(land, i, j, w);
                        if(a > max) 
                            max = a;
                    }
                }
            }
        }
        return max;
    }

    //Calculate the maximum volumn of a lake
    static int maxVolumn(int[][] land, int w)
    {
        int max=0;
        if(land != null && land[0] != null)
        {
            for(int i=0; i<land.length; i++)   
            {
                for(int j=0; j<land[0].length; j++)
                {
                    if(land[i][j] < w)
                    {
                        int v = volumn(land, i, j, w);
                        if(v > max) 
                            max = v;
                    }
                }
            }
        }
        return max;
    }

    //Calculate the volumn of a lake
    static int volumn(int[][] land, int x, int y, int w)
	{
		if(land != null && land[0] != null)
		{
            if(land[x][y] >= 0 && land[x][y] < w)
            {
                int wl = land[x][y];
                land[x][y] = -1;
                int up=0, down=0, right=0, left=0;
                if(x+1 < land.length)
                    up = volumn(land, x+1, y, w);	
                if(x-1 >= 0)
                    down = volumn(land, x-1, y, w);	
                if(y+1 < land[0].length)
                    right = volumn(land, x, y+1, w);	
                if(y-1 >= 0)
                    left = volumn(land, x, y-1, w);	

                return right + left + down + up + wl;
            }
		}
        return 0;
	}

    //Calculate the area of a lake
    static int area(int[][] land, int x, int y,  int w)
	{
		if(land != null && land[0] != null)
		{
            if(land[x][y] >= 0 && land[x][y] < w)
            {
                land[x][y] = -1;
                int up=0, down=0, right=0, left=0;
                if(x+1 < land.length)
                    up = area(land, x+1, y, w);	
                if(x-1 >= 0)
                    down = area(land, x-1, y, w);	
                if(y+1 < land[0].length)
                    right = area(land, x, y+1, w);	
                if(y-1 >= 0)
                    left = area(land, x, y-1, w);	

                return right + left + down + up + 1;
            }
		}
        return 0;
	}

    static void test0_question3()
    {
        System.out.println("===================================================");
        System.out.println("test0_question3()");
        System.out.println("The shortest motorable path between points A and B");
        int G = 10;
        int x = 0;
        int y = 0;
        int bx = 0;
        int by = 1;
        System.out.println("The threshold of gradient G="+G);
        System.out.println("A=("+x+","+y+")  B=("+bx+","+by+")");

        int[][] A = {{3}
                    };
        
        printArray2D(A);

        int prev_x = -1;
        int prev_y = -1;
        
        int[][] path = new int[50][3];    
        List<Point> shortestPath= new ArrayList<Point>();   
        int[] min = {Integer.MAX_VALUE};
        int depth = 0;
        motorable(A, x, y, prev_x, prev_y, bx, by, G, path, shortestPath, depth, min);

        System.out.println();
        System.out.println("The shortest path: point[x, y z]");
        for(Point t: shortestPath)
            System.out.print("["+t.x+","+t.y+","+t.z+"]");
        System.out.println();
    }

    static void test1_question3()
    {
        System.out.println("===================================================");
        System.out.println("test1_question3()");
        System.out.println("The shortest motorable path between points A and B");
        int G = 10;
        int x = 0;
        int y = 0;
        int bx = 0;
        int by = 1;
        System.out.println("The threshold of gradient G="+G);
        System.out.println("A=("+x+","+y+")  B=("+bx+","+by+")");

        int[][] A = {{3, 5}
                    };
        
        printArray2D(A);

        int prev_x = -1;
        int prev_y = -1;
        
        int[][] path = new int[50][3];    
        List<Point> shortestPath= new ArrayList<Point>();   
        int[] min = {Integer.MAX_VALUE};
        int depth = 0;
        motorable(A, x, y, prev_x, prev_y, bx, by, G, path, shortestPath, depth, min);

        System.out.println();
        System.out.println("The shortest path: point[x, y z]");
        for(Point t: shortestPath)
            System.out.print("["+t.x+","+t.y+","+t.z+"]");
        System.out.println();
    }
    static void test2_question3()
    {
        System.out.println("===================================================");
        System.out.println("test2_question3()");
        System.out.println("The shortest motorable path between points A and B");
        int G = 10;
        int x = 0;
        int y = 0;
        int bx = 1;
        int by = 1;
        System.out.println("The threshold of gradient G="+G);
        System.out.println("A=("+x+","+y+")  B=("+bx+","+by+")");
        int[][] A = {   {3, 5, 4},
                        {7, 1, 3},
                        {6, 2, 1}
                    };
        printArray2D(A);

        int prev_x = -1;
        int prev_y = -1;
        
        int[][] path = new int[50][3];    
        List<Point> shortestPath= new ArrayList<Point>();   
        int[] min = {Integer.MAX_VALUE};
        int depth = 0;
        motorable(A, x, y, prev_x, prev_y, bx, by, G, path, shortestPath, depth, min);

        System.out.println();
        System.out.println("The shortest path: point[x, y, z]");
        System.out.print("path:");
        for(Point t: shortestPath)
            System.out.print("["+t.x+","+t.y+","+t.z+"]");
        System.out.println();

    }

    static void test3_question3()
    {
        System.out.println("===================================================");
        System.out.println("test3_question3()");
        System.out.println("The shortest motorable path between points A and B");
        int G = 5;
        int x = 0;
        int y = 0;
        int bx = 2;
        int by = 2;
        System.out.println("The threshold of gradient G="+G);
        System.out.println("A=("+x+","+y+")  B=("+bx+","+by+")");

        int[][] A = {   {3, 5, 1, 3},
                        {7, 1, 4, 1},
                        {4, 1, 2, 1},
                        {3, 2, 4, 2}
                    };

        printArray2D(A);

        int prev_x = -1;
        int prev_y = -1;
        
        int[][] path = new int[50][3];    
        List<Point> shortestPath= new ArrayList<Point>();   
        int[] min = {Integer.MAX_VALUE};
        int depth = 0;
        motorable(A, x, y, prev_x, prev_y, bx, by, G, path, shortestPath, depth, min);

        System.out.println();
        System.out.println("The shortest path: point[x, y z]");
        System.out.print("path:");
        for(Point t: shortestPath)
            System.out.print("["+t.x+","+t.y+","+t.z+"]");
        System.out.println();

    }

    static void test4_question3()
    {
        System.out.println("===================================================");
        System.out.println("test4_question3()");
        System.out.println("The shortest motorable path between points A and B");
        int G = 5;
        int x = 0;
        int y = 0;
        int bx = 10;
        int by = 10;
        System.out.println("The threshold of gradient G="+G);
        System.out.println("A=("+x+","+y+")  B=("+bx+","+by+")");

        int[][] A = {   {3, 5, 1, 3},
                        {7, 1, 4, 1},
                        {4, 1, 2, 1},
                        {3, 2, 4, 2}
                    };

        printArray2D(A);

        int prev_x = -1;
        int prev_y = -1;
        
        int[][] path = new int[50][3];    
        List<Point> shortestPath= new ArrayList<Point>();   
        int[] min = {Integer.MAX_VALUE};
        int depth = 0;
        motorable(A, x, y, prev_x, prev_y, bx, by, G, path, shortestPath, depth, min);

        System.out.println();
        System.out.println("The shortest path: point[x, y z]");
        System.out.print("path:");
        for(Point t: shortestPath)
            System.out.print("["+t.x+","+t.y+","+t.z+"]");
        System.out.println();

    }

    // Initialize: prev_x = -1, prev_y = -1
    // G is the threshold of gradient 
    // land[prev_x][prev_y] is the z value of  previous point
    // land[x][y] is the z value of current point
    // A=(x, y) B=(bx, by)
    // depth is the numbers of points in a path
    // min is the minimum of gradients for all the paths
    static void motorable(int[][] land, int x, int y, 
                        int prev_x, int prev_y, 
                        int bx, int by, int G, int[][] path, List<Point> shortestPath,int depth, int[] min)
	{
		if(land != null)
		{
            if(prev_x >= 0 && prev_y >= 0)
            {
                int gradient = Math.abs(land[x][y] - land[prev_x][prev_y]);
                if(gradient < G)
                {
                    if(x == bx && y == by)
                    {
                        path[depth][0] = x;
                        path[depth][1] = y;
                        path[depth][2] = land[x][y];

                        System.out.print("path:");
                        for(int i=0; i<=depth; i++)
                            System.out.print("["+path[i][0]+","+path[i][1]+","+path[i][2]+"]");
                        System.out.println();

                        int s=0;
                        for(int i=1; i<=depth; i++)
                           s += Math.abs(path[i-1][2] - path[i][2]); 

                        if(s < min[0])
                        {
                            min[0] = s;
                            shortestPath.clear();
                            for(int i=0; i<=depth; i++)
                            {
                                shortestPath.add(new Point(path[i][0], path[i][1], path[i][2]));
                            }
                        }
                    }
                    else
                    {
                        if(y+1 < land[0].length)
                        {
                            path[depth][0] = x;
                            path[depth][1] = y;
                            path[depth][2] = land[x][y];
                            motorable(land, x, y+1, x, y, bx, by, G, path, shortestPath, depth+1, min);
                        }
                        if(x+1 < land.length)
                        {
                            path[depth][0] = x;
                            path[depth][1] = y;
                            path[depth][2] = land[x][y];
                            motorable(land, x+1, y, x, y, bx, by, G, path, shortestPath, depth+1, min);
                        }
                    }
                }
            }
            else
            {
                if(y+1 < land[0].length)
                {
                    path[depth][0] = x;
                    path[depth][1] = y;
                    path[depth][2] = land[x][y];
                    motorable(land, x, y+1, x, y, bx, by, G, path, shortestPath, depth+1, min);
                }
                if(x+1 < land.length)
                {
                    path[depth][0] = x;
                    path[depth][1] = y;
                    path[depth][2] = land[x][y];
                    motorable(land, x+1, y, x, y, bx, by, G, path, shortestPath, depth+1, min);
                }
            }
		}
	}

    static int countLake(int[][] land, List<List<Point>> listList, int w)
	{
        int s=0;
        if(land != null)
        {
            for(int i=0; i<land.length; i++)   
            {
                for(int j=0; j<land.length; j++)
                {
                    if(land[i][j] >= 0 && land[i][j] < w)
                    {
                        List<Point> listPoint = new ArrayList<Point>();
                        landscapeLake(land, i, j, listPoint, w);
                        listList.add(listPoint);
                        s += 1;
                    }
                }
            }
        }
        return s;
	}

    public static void printArray2D(int[][] arr)
    {
        if(arr != null)
        {
            for(int c=0; c<arr.length; c++)
            {
                for(int r=0; r<arr[0].length; r++)
                {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
