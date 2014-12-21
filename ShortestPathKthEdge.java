public class ShortestPathKthEdge 
{
    static final int INT = 100;
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[][] graph= { {0, 10, 3, 2},
                         {INT, 0, INT, 7},
                         {INT, INT, 0, 6},
                         {INT, INT, INT, 0}
                        };
        int k = 3;
        int edge = 0;
        int numVertex = 4;
        //int min = minPath(graph, numVertex, k, edge);
        //System.out.println("finalmin=["+min+"]");
        int numEdge = 2;
        int u = 0;
        int v = 3;
        int min2 = minPathDP(graph, numVertex, numEdge, u, v);  
        System.out.println("min2=["+min2+"]");
    }

    //Use Depth First Search to find the shortest path from vertex u to v with k edges
    public static int minPath(int[][] array, int numEdge, int k, int edge)
    {
        if(k <= 0 || edge+1 >= numEdge)
            return 0;

        int min = 1000;
        for(int i=edge; i<numEdge; i++)
        {
            if(i != edge && array[edge][i] != INT)
            {
                System.out.println("up["+edge+"]["+i+"]");
                int subm = minPath(array, numEdge, k-1, i);
                min = Math.min(min, subm + array[edge][i]);
                System.out.println("min=["+min+"] subm["+subm+"]   ["+edge+"]["+i+"]");
            }
        }
        return min;
    }
    

    //Use dynamic programming to find the shortest path from vertex u to v with numEdge
    //edge
    public static int minPathDP(int[][] graph, int numVertex, int numEdge, int u, int v)
    {
        int[][][] cube = new int[numVertex][numVertex][numEdge+1];    

        for(int e=0; e<numEdge+1; e++)
        {
            for(int i=0; i<numVertex; i++)
            {
                for(int j=0; j<numVertex; j++)
                {
                    cube[i][j][e] = INT;

                    //base case
                    if( e == 0 && i == j)
                        cube[i][j][e] = 0;
                    else if ( e == 1 && graph[i][j] != INT)
                        cube[i][j][e] = graph[i][j];
                    else if( e > 1)
                    {
                        for(int a=0; a < numVertex; a++)
                        {
                            if(i != j && a != i && a != j && graph[i][a] != INT &&
                                    cube[i][j][e-1] != INT) 
                            cube[i][j][e] = Math.min(graph[i][a] + cube[a][j][e-1], 
                                                     cube[i][j][e]);
                        }
                    }
                }
            }
            
            for(int i=0; i<numVertex; i++)
            {
                for(int j=0; j<numVertex; j++)
                {
                    if(cube[i][j][e] < 100)
                        System.out.print("["+cube[i][j][e]+"]");
                    else
                        System.out.print("["+0+"]");
                }
                System.out.println();
            }
            System.out.println();
        }
        return cube[u][v][numEdge];
    }
}
