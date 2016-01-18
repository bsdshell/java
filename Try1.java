import Lib.*;

public class Try1 
{
    public static void main(String[] args)
    {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    public static void test1()
    {
         System.out.println("test1");
        int[][] array = {
                        {1,2,3}
                        };
        int k=0;
        spiral(array, k);
    } 
    public static void test2()
    {
         System.out.println("test1");
        int[][] array = {
                        {1,2,3},
                        {4,5,6}
                        };
        int k=0;
        spiral(array, k);
    } 

    public static void test3()
    {
         System.out.println("test3");
        int[][] array = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9},
                        {10,11,12}
                        };
        int k=0;
        spiral(array, k);
    } 

    public static void test4()
    {
         System.out.println("test4");
        int[][] array = {
                        {1}
                        };
        int k=0;
        spiral(array, k);
    } 
    public static void test5()
    {
         System.out.println("test5");
        int[][] array = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9},
                        {10,11,12},
                        {13,14,15}
                        };
        int k=0;
        spiral(array, k);
    } 
    public static void test6()
    {
         System.out.println("test6");
        int[][] array = {
                        {1,2,3,4},
                        {5,6,7,8}
                        };
        Aron.printArray2D(array);
         System.out.println("-----------------");
        int k=0;
        spiral(array, k);
    } 
    public static void test7()
    {
         System.out.println("test7");
        int[][] array = {
                        {1,2},
                        {5,6}
                        };
        Aron.printArray2D(array);
         System.out.println("-----------------");
        int k=0;
        spiral(array, k);
    } 
    // init: k = 0
    public static void spiral(int[][] array, int k){
        if(array != null){
            int hlen= array.length;
            int wlen= array[0].length;
            
            if(k < hlen/2 && k < wlen/2){
                if(hlen - 2*k == 1){
                    for(int i=k; i<wlen-k; i++){
                        System.out.println(array[k][i]);
                    }
                }else if(wlen -2*k ==1){
                    for(int i=k; i<hlen-k; i++){
                        System.out.println(array[i][k]);
                    }
                }else{
                    for(int w=k; w<wlen-1-k; w++){
                        System.out.println(array[k][w]);
                    }
                    for(int h=k; h<hlen-1-k; h++){
                        System.out.println(array[h][wlen-1-k]);
                    }
                    for(int w=k; w<wlen-1-k; w++){
                        System.out.println(array[hlen-1-k][wlen-1-w]);
                    }
                    for(int h=k; h<hlen-1-k; h++){
                        System.out.println(array[hlen-1-h][k]);
                    }
                    spiral(array, k+1);
                }
            }
        }
  }
}
