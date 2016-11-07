public class MatrixMulti {
    public static void main(String[] args) {
        test0();
        test1();
    }

    // multiply matrix, mul matrix, mult matrix
    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] C = null;
        if( A != null && B != null) {
            int alen = A.length;
            int blen = B.length;
            int clen = alen;
            C = new int[alen][alen];
            for(int c = 0; c < clen; c++) {
                for(int i = 0; i < alen; i++) {
                    int s = 0;
                    for(int j = 0; j < blen; j++) {
                        s += A[i][j]*B[j][c];
                    }
                    C[i][c] = s;
                }
            }
        }
        return C;
    }

    //[ file=matrixmul.html title=""
    // Better way to multiply matrix, mul matrix, mult matrix
    public static int[][] multiply2(int[][] arr1, int[][] arr2) {
        int[][] arr3 = null;
        if( arr1 != null && arr2 != null) {
            int height = arr1.length;
            int width = arr1[0].length;
            int len = height;
            arr3 = new int[height][height];
            for(int k = 0; k < len; k++) {
                for(int i = 0; i < height; i++) {
                    for(int j = 0; j < width; j++) {
                        arr3[i][j] += arr1[i][k]*arr2[k][j];
                    }
                }
            }
        }
        return arr3;
    }
    //]
    
    static void test0(){
        System.out.println("---------------------------------\n");
        int[][] A = {{1}};
        int[][] B = {{2}};
        int[][] C = multiply2(A, B);
        Aron.printArray2D(C);

        System.out.println("---------------------------------\n");
    }
    static void test1(){
        System.out.println("---------------------------------\n");
        int[][] A = {{1, 1},
                    {0, 1}
        };
        int[][] B = {{2, 0},
                    {0, 3}
        };
        int[][] C = multiply2(A, B);
        Aron.printArray2D(C);
        System.out.println("---------------------------------\n");
    }
}
