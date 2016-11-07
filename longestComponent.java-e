public class longestComponent {
    //[file=longestcomponent.html title=""
    static int component(int[][] A, int x, int y) {
        if(A != null && A[0] != null && 0 <= x && x < A.length && 0 <= y &&
                y < A[0].length && A[x][y] == 1) {
            A[x][y] = 2;
            int up    = component(A,   x+1,   y   ); 
            int down  = component(A,   x-1,   y   ); 
            int right = component(A,   x,     y+1 ); 
            int left  = component(A,   x,     y-1 ); 
            return right + left + down + up + 1;
        }
        return 0;
    }
    static int  longest(int[][] A) {
        int max = 0;
        if(A != null) {
            for(int i=0; i<A.length; i++)   {
                for(int j=0; j<A[0].length; j++) {
                    int count = component(A, i, j);
                    if(count > max)
                        max = count;
                }
            }
        }
        return max;
    }
    //]

    static void test0() {
        System.out.println("---------------------------------\n");
        int[][] A = null;
        int count = longest(A);
        System.out.println("longest="+count);
        System.out.println("---------------------------------\n");
    }
    static void test1() {
        System.out.println("---------------------------------\n");
        int[][] B = {};
        int count = longest(B);
        System.out.println("longest="+count);
        System.out.println("---------------------------------\n");
    }
    static void test2() {
        System.out.println("---------------------------------\n");
        int[][] C = {{0}};
        int count = longest(C);
        System.out.println("longest="+count);
        System.out.println("---------------------------------\n");
    }

    static void test3() {
        System.out.println("---------------------------------\n");
        int[][] D = {{1}};
        int count = longest(D);
        System.out.println("longest="+count);
        System.out.println("---------------------------------\n");
    }
    static void test4() {
        System.out.println("---------------------------------\n");
        int[][] E = {
            {0, 0},
            {0, 0}
        };
        int count = longest(E);
        System.out.println("longest="+count);

        System.out.println("---------------------------------\n");
    }
    static void test5() {
        System.out.println("---------------------------------\n");
        int[][] F = {
            {1, 0},
            {1, 1}
        };
        int count = longest(F);
        System.out.println("longest="+count);
        System.out.println("---------------------------------\n");
    }

    static void test6() {
        System.out.println("---------------------------------\n");
        int[][] H = {   {0, 1, 1, 1},
            {0, 1, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };
        int count = longest(H);
        System.out.println("longest="+count);
        System.out.println("---------------------------------\n");
    }

    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
