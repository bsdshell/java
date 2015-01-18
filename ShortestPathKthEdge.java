public class ShortestPathKthEdge 
{
    static final int INT = 100;
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[][] graph= { {0, 10, 3, 2},
                         {INT, 0, INT, 7},
                         {INT, INT, 0, 6},
                         {INT, INT, INT, 0}};
        int u = 0;
        int v = 1;                
        int k = 1;
        int numVertex = 4;
        int min = minPath(graph, numVertex, k, u, v);
        System.out.println("u=["+u+"]");
        System.out.println("v=["+v+"]");
        System.out.println("k=["+k+"]");
        System.out.println("finalmin=["+min+"]");
        int numEdge = 2;
        
        /*
        traveralGraph(graph, numVertex, edge);
        int min2 = minPathDP(graph, numVertex, numEdge, u, v);  
        System.out.println("min2=["+min2+"]");
        */
    }

    //Use Depth First Search to find the shortest path from vertex u to v with k edges
    public static int minPath(int[][] graph, int numVertex, int k, int u, int v)
    {
        if(k <= 0 && u == v)
            return 0;
        else if( k <= 0)
            return INT;
        else if( k == 1 && graph[u][v] != INT)
            return graph[u][v];

        int min = INT;
        for(int i=0; i<numVertex; i++)
        {
            if(graph[u][i] != INT && u != i && v != i)
            {
                System.out.println("inorder["+u+"]["+i+"]=["+graph[u][i]+"]");
                System.out.println("k=["+k+"]");
                int subm = minPath(graph, numVertex, k-1, i, v);
                if(subm != INT)
                {
                    min = Math.min(min, subm + graph[u][i]);
                    System.out.println("min=["+min+"] subm["+subm+"]   ["+u+"]["+i+"]");
                }
            }
        }
        return min;
    }
    
    public static void traveralGraph(int[][] graph, int numVertex, int depth)
    {
        for(int i=0; i<numVertex; i++)
        {
            if( i !=depth && graph[depth][i] != INT)
            {
                System.out.println(depth+"->"+i+"["+graph[depth][i]+"]");
                traveralGraph(graph, numVertex, i);  
            }
        }
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
