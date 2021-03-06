import classfile.*;

// update: Wed Sep 28 03:22:10 PDT 2016
//
public class ShortestPathKthEdge {
    static final int INT = 100;
    public static void main(String[] args) {
        Print.p("Hello World!");
        int[][] graph= { 
            {0, 10, 3, 2},
            {INT, 0, INT, 7},
            {INT, INT, 0, 6},
            {INT, INT, INT, 0}
        };
        int u = 0;
        int v = 3;
        int k = 2;
        int numVertex = 4;
        int min = minPath(graph, numVertex, k, u, v);
        Print.p("u=["+u+"]");
        Print.p("v=["+v+"]");
        Print.p("k=["+k+"]");
        Print.p("finalmin=["+min+"]");
        int numEdge = 0;

        //GraphTraveral(graph, numVertex, numEdge);
        Ut.l();
        PreorderGraphTraveral(graph, numVertex, numEdge);
        Ut.l();
        PostGraphTraveral(graph, numVertex, numEdge);
        /*
        int min2 = minPathDP(graph, numVertex, numEdge, u, v);
        Print.p("min2=["+min2+"]");
        */
    }

    //Use Depth First Search to find the shortest path from vertex u to v with k edges
    public static int minPath(int[][] graph, int numVertex, int k, int u, int v) {
        //when u == v, assume the cycle in the same node
        if(k <= 0 && u == v)
            return 0;
        else if( k <= 0)
            return INT;
        /*
        else if( k == 1 && graph[u][v] != INT)
            return graph[u][v];
        */
        else {
            int min = INT;
            for(int i=0; i<numVertex; i++) {
                if(graph[u][i] != INT && u != i && v != i) {
                    Print.p("inorder["+u+"]["+i+"]=["+graph[u][i]+"]");
                    Print.p("k=["+k+"]");
                    int subm = minPath(graph, numVertex, k-1, i, v);
                    if(subm != INT) {
                        min = Math.min(min, subm) + graph[u][i];
                        Print.p("min=["+min+"] subm["+subm+"]   ["+u+"]["+i+"]");
                    }
                }
            }
            return min;
        }
    }

    //Traveral from node(depth) to other nodes
    public static void PostGraphTraveral(int[][] w, int numVertex, int depth) {
        for(int i=0; i<numVertex; i++) {
            if( i !=depth && w[depth][i] != 0 && w[depth][i] != INT) {
                PostGraphTraveral(w, numVertex, i);
                //Print.p(depth+"->"+i+"["+w[depth][i]+"]");
                Print.p(i+"->"+depth+"["+w[depth][i]+"]");
            }
        }
    }

    //Preorder Traveral
    public static void PreorderGraphTraveral(int[][] w, int numVertex, int depth) {
        for(int i=0; i<numVertex; i++) {
            if( i !=depth && w[depth][i] != INT) {
                Print.p(depth+"->"+i+"["+w[depth][i]+"]");
                PreorderGraphTraveral(w, numVertex, i);
            }
        }
    }


    //Use dynamic programming to find the shortest path from vertex u to v with numEdge
    //edge
    public static int minPathDP(int[][] graph, int numVertex, int numEdge, int u, int v) {
        int[][][] cube = new int[numVertex][numVertex][numEdge+1];

        for(int e=0; e<numEdge+1; e++) {
            for(int i=0; i<numVertex; i++) {
                for(int j=0; j<numVertex; j++) {
                    cube[i][j][e] = INT;

                    //base case
                    if( e == 0 && i == j)
                        cube[i][j][e] = 0;
                    else if ( e == 1 && graph[i][j] != INT)
                        cube[i][j][e] = graph[i][j];
                    else if( e > 1) {
                        for(int a=0; a < numVertex; a++) {
                            if(i != j && a != i && a != j && graph[i][a] != INT &&
                                    cube[i][j][e-1] != INT)
                                cube[i][j][e] = Math.min(graph[i][a] + cube[a][j][e-1],
                                                         cube[i][j][e]);
                        }
                    }
                }
            }

            for(int i=0; i<numVertex; i++) {
                for(int j=0; j<numVertex; j++) {
                    if(cube[i][j][e] < 100)
                        Print.p("["+cube[i][j][e]+"]");
                    else
                        Print.p("["+0+"]");
                }
            }
        }
        return cube[u][v][numEdge];
    }
}
