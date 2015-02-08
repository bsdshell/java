import java.util.*;

class Triple{
    int x;
    int y;
    int z;
    public Triple(int x, int y, int z)
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
	    test0();
	    test1();
	    test2();
	    test3();
	    test4();
	    test5_maxArea();
	    test6_maxVolumn();
        test1_motorable();
        
        test2_motorable();
        /*
        test3_motorable();
        */
    }
    static void test0()
    {
        System.out.println("test1()");

        int[][] E = {{11}};
        int col=0, row=0;
        List<List<Triple>> listList = new ArrayList<List<Triple>>(); 
        int w = 10;
        int count = countComponent(E, listList, w);
        System.out.println("count=["+count+"]");
    }
    static void test1()
    {
        System.out.println("test1()");

        int[][] E = {
            {11, 0},
            {0, 11}
        };
        int col=0, row=0;
        List<List<Triple>> listList = new ArrayList<List<Triple>>(); 
        int w = 10;
        int count = countComponent(E, listList, w);
        System.out.println("count=["+count+"]");
    }

    static void test2()
    {
        System.out.println("test2()");
         int[][] F = {
            {0, 1},
            {1, 0}
        };
        int col=0, row=0;
        int w = 10;
        List<List<Triple>> listList = new ArrayList<List<Triple>>(); 
        int count = countComponent(F, listList, w);
        System.out.println("count=["+count+"]");
        printListList(listList);
    }

    static void test3()
    {
        System.out.println("test3()");
        int[][] H = {   {1, 1, 6, 1},
                        {1, 1, 4, 9},
                        {4, 3, 1, 1},
                        {0, 7, 1, 1}
                    };
        int col=0, row=0;
        int w = 2;
        List<List<Triple>> listList = new ArrayList<List<Triple>>(); 
        int count = countComponent(H, listList, w);
        System.out.println("count=["+count+"]");
        printListList(listList);
    }

	static void printListList(List<List<Triple>> listList)
    {
        System.out.println("lake:(x, y, z)");
        int count = 1;
        for(List<Triple> list:listList)
        {
            System.out.print("lake:"+count+"=");
            for(Triple t:list)
            {
                System.out.print("("+t.x+" "+" "+t.y+" "+t.z+")");
            }
            count++;
            System.out.println();
        }
    }
	static void test4()
    {
        System.out.println("test4()");
        int[][] G = {   {0, 1, 1, 0},
                        {9, 3, 6, 9},
                        {2, 8, 0, 1},
                        {0, 0, 0, 0}
                    };
        int col=0, row=0;
        int w = 4;
        List<List<Triple>> listList = new ArrayList<List<Triple>>(); 
        int count = countComponent(G, listList, w);
        System.out.println("count=["+count+"]");
    }
			
	static void test5_maxArea()
    {
        System.out.println("test5_maxArea()");
        int[][] G = {   {2, 9, 1, 4},
                        {9, 9, 9, 9},
                        {9, 1, 0, 5},
                        {8, 3, 2, 4}
                    };

        //Threshold
        final int w=5;

        int max = maxArea(G, w);
        System.out.println("max=["+max+"]");

    }

    static void test6_maxVolumn()
    {
        System.out.println("test6_maxVolumn()");
        int[][] G = {   {2, 9, 1, 4},
                        {9, 9, 9, 9},
                        {9, 1, 9, 5},
                        {4, 3, 9, 4}
                    };

        //Threshold
        final int w=5;

        int max = maxVolumn(G, w);
        System.out.println("max=["+max+"]");

    }

	static int component(int[][] A, int x, int y, List<Triple> lake, int w)
	{
		if(A != null && A[0] != null)
		{
            if(A[x][y] >= 0 && A[x][y] < w)
            {
                int up=0, down=0, right=0, left=0;
                if(lake != null)
                    lake.add(new Triple(x, y, A[x][y]));

                A[x][y] = -1;

                if(x+1 < A.length)
                    up = component(A, x+1, y, lake, w);	
                if(x-1 >= 0)
                    down = component(A, x-1, y, lake, w);	
                if(y+1 < A.length)
                    right = component(A, x, y+1, lake, w);	
                if(y-1 >= 0)
                    left = component(A, x, y-1, lake, w);	

                return right + left + down + up + 1;
            }
		}
        return 0;
	}

    static void test1_area()
    {
        final int w=5;
        System.out.println("test1_area()");
        int[][] G = {   {2, 1, 1, 3},
                        {1, 1, 0, 1},
                        {4, 1, 0, 1},
                        {3, 2, 4, 2}
                    };
        int max = maxArea(G, w);
        System.out.println("max area=["+max+"]");

    }
    static int maxArea(int[][] A, int w)
    {
        int max=0;
        if(A != null && A[0] != null)
        {
            for(int i=0; i<A.length; i++)   
            {
                for(int j=0; j<A[0].length; j++)
                {
                    if(A[i][j] < w)
                    {
                        int a = area(A, i, j, w);
                        if(a > max) 
                            max = a;
                    }
                }
            }
        }
        return max;
    }

    static int maxVolumn(int[][] A, int w)
    {
        int max=0;
        if(A != null && A[0] != null)
        {
            for(int i=0; i<A.length; i++)   
            {
                for(int j=0; j<A[0].length; j++)
                {
                    if(A[i][j] < w)
                    {
                        int v = volumn(A, i, j, w);
                        if(v > max) 
                            max = v;
                    }
                }
            }
        }
        return max;
    }

    //Calculate the volumn of lake
    static int volumn(int[][] A, int x, int y, int w)
	{
		if(A != null && A[0] != null)
		{
            if(A[x][y] >= 0 && A[x][y] < w)
            {
                int wl = A[x][y];
                A[x][y] = -1;
                int up=0, down=0, right=0, left=0;
                if(x+1 < A.length)
                    up = volumn(A, x+1, y, w);	
                if(x-1 >= 0)
                    down = volumn(A, x-1, y, w);	
                if(y+1 < A[0].length)
                    right = volumn(A, x, y+1, w);	
                if(y-1 >= 0)
                    left = volumn(A, x, y-1, w);	

                return right + left + down + up + wl;
            }
		}
        return 0;
	}

    //Calculate the area of lake
    static int area(int[][] A, int x, int y,  int w)
	{
		if(A != null && A[0] != null)
		{
            if(A[x][y] >= 0 && A[x][y] < w)
            {
                A[x][y] = -1;
                int up=0, down=0, right=0, left=0;
                if(x+1 < A.length)
                    up = area(A, x+1, y, w);	
                if(x-1 >= 0)
                    down = area(A, x-1, y, w);	
                if(y+1 < A[0].length)
                    right = area(A, x, y+1, w);	
                if(y-1 >= 0)
                    left = area(A, x, y-1, w);	

                return right + left + down + up + 1;
            }
		}
        return 0;
	}

    static void test3_motorable()
    {
        System.out.println("test3_motorable()");
        int[][] A = {{3, 5}
                    };
        
        int prev_x = -1;
        int prev_y = -1;
        int x = 0;
        int y = 0;
        int bx = 0;
        int by = 1;
        int G = 10;
        int[][] path = new int[50][3];    
        List<Triple> shortestPath= new ArrayList<Triple>();   
        int[] min = {Integer.MAX_VALUE};
        int depth = 0;
        int minGradient = motorable(A, x, y, prev_x, prev_y, bx, by, G, path, shortestPath, depth, min);
        System.out.println("minGradient=["+minGradient+"]");
        for(Triple t: shortestPath)
        {
            System.out.print("["+t.x+","+t.y+","+t.z+"]");
        }
        System.out.println();
    }
    static void test2_motorable()
    {
        System.out.println("test2_motorable()");
        int[][] A = {   {3, 5, 4},
                        {7, 1, 3},
                        {6, 2, 1}
                    };
        
        int prev_x = -1;
        int prev_y = -1;
        int x = 0;
        int y = 0;
        int bx = 1;
        int by = 1;
        int G = 10;
        int[][] path = new int[50][3];    
        List<Triple> shortestPath= new ArrayList<Triple>();   
        int[] min = {Integer.MAX_VALUE};
        int depth = 0;
        int minGradient = motorable(A, x, y, prev_x, prev_y, bx, by, G, path, shortestPath, depth, min);

        System.out.println("minGradient=["+minGradient+"]");
        for(Triple t: shortestPath)
        {
            System.out.print("["+t.x+","+t.y+","+t.z+"]");
        }
        System.out.println();

    }
    static void test1_motorable()
    {
        System.out.println("test1_motorable()");
        int[][] A = {   {3, 5, 1, 3},
                        {7, 1, 4, 1},
                        {4, 1, 2, 1},
                        {3, 2, 4, 2}
                    };
        
        int prev_x = -1;
        int prev_y = -1;
        int x = 0;
        int y = 0;
        int bx = 1;
        int by = 1;
        int G = 5;
        int[][] path = new int[50][3];    
        List<Triple> shortestPath= new ArrayList<Triple>();   
        int[] min = {Integer.MAX_VALUE};
        int depth = 0;
        int minGradient = motorable(A, x, y, prev_x, prev_y, bx, by, G, path, shortestPath, depth, min);
        System.out.println("minGradient=["+minGradient+"]");
        for(Triple t: shortestPath)
        {
            System.out.print("["+t.x+","+t.y+","+t.z+"]");
        }
        System.out.println();
    }

    // Initialize: prev_x = -1, prev_y = -1
    // G is the threshold of gradient 
    // A[prev_x][prev_y] is the z value of  previous point
    // A[x][y] is the z value of current point
    static int motorable(int[][] A, int x, int y, 
                        int prev_x, int prev_y, 
                        int bx, int by, int G, int[][] path, List<Triple> shortestPath,int depth, int[] min)
	{
		if(A != null)
		{
            int gradient = 0;
            if(prev_x >= 0 && prev_y >= 0)
            {
                gradient = Math.abs(A[x][y] - A[prev_x][prev_y]);
                if(gradient < G)
                {
                    if(x == bx && y == by)
                    {
                        path[depth][0] = x;
                        path[depth][1] = y;
                        path[depth][2] = A[x][y];

                        for(int i=0; i<=depth; i++)
                            System.out.print("["+path[i][0]+","+path[i][1]+","+path[i][2]+"]");

                        int s=0;
                        for(int i=1; i<=depth; i++)
                           s += Math.abs(path[i-1][2] - path[i][2]); 

                        if(s < min[0])
                        {
                            min[0] = s;
                            shortestPath.clear();
                            for(int i=0; i<=depth; i++)
                            {
                                shortestPath.add(new Triple(path[i][0], path[i][1], path[i][2]));
                            }
                        }
                        System.out.println();
                        return gradient;
                    }
                    else
                    {
                        int down=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
                        if(y+1 < A[0].length)
                        {
                            path[depth][0] = x;
                            path[depth][1] = y;
                            path[depth][2] = A[x][y];
                            right = motorable(A, x, y+1, x, y, bx, by, G, path, shortestPath, depth+1, min) + gradient;
                        }
                        if(x+1 < A.length)
                        {
                            path[depth][0] = x;
                            path[depth][1] = y;
                            path[depth][2] = A[x][y];
                            down = motorable(A, x+1, y, x, y, bx, by, G, path, shortestPath, depth+1, min) + gradient;
                        }
                        return Math.min(right, down);
                    }
                }
            }
            else
            {
                int down=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
                if(y+1 < A[0].length)
                {
                    path[depth][0] = x;
                    path[depth][1] = y;
                    path[depth][2] = A[x][y];
                    right = motorable(A, x, y+1, x, y, bx, by, G, path, shortestPath, depth+1, min) + gradient;
                }
                if(x+1 < A.length)
                {
                    path[depth][0] = x;
                    path[depth][1] = y;
                    path[depth][2] = A[x][y];
                    down = motorable(A, x+1, y, x, y, bx, by, G, path, shortestPath, depth+1, min) + gradient;
                }
                return Math.min(right, down);
            }
		}
        return 0;
	}

    static int countComponent(int[][] A, List<List<Triple>> listList, int w)
	{
        int s=0;
        if(A != null)
        {
            for(int i=0; i<A.length; i++)   
            {
                for(int j=0; j<A.length; j++)
                {
                    if(A[i][j] >= 0 && A[i][j] < w)
                    {
                        List<Triple> lake = new ArrayList<Triple>();
                        component(A, i, j, lake, w);
                        listList.add(lake);
                        s += 1;
                    }
                }
            }
        }
        return s;
	}
}
