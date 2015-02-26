public class ThreeBrothers 
{
    public static void main(String[] args)
    {
        //test1();
        Integer[] arr = {1, 2, 2};
        int d=0;
        printTriangle(arr, d);
        Character[] myarr = new Character[10];
        Aron.swap(myarr, 1, 3);
    }
    
    // min(a, MAX) = a
    // mul(a, 1)   = a
    public static void combination(int[] arr, int d, int[] w)
    {
        int min = Integer.MAX_VALUE;
        if(d < 3)
        {
            for(int i=d; i<arr.length; i++)
            {
                w[d] = arr[i];
                combination(arr, d+1, w);
                if(d == 2)
                    System.out.println("["+w[0]+"]["+w[1]+"]["+w[2]+"]");
                /*
                if(d == 2)
                {
                    int mindiff = 2*(Math.max(Math.max(w[0], w[1]), w[2]) - Math.min(Math.min(w[0], w[1]), w[2]));
                    if(mindiff < min)
                    {
                        min = mindiff;
                        System.out.println("["+w[0]+"]["+w[1]+"]["+w[2]+"]");
                        System.out.println();
                    }
                }
                */
            }
        }
    }
    
    
    public static void printTriangle(Integer[] arr, int d)
    {
        if(d == arr.length)
        {
            for(Integer n:arr)
                System.out.print("["+n+"]");
            System.out.println();
        }
        else
        {
            for(int i=d; i<arr.length; i++)
            {
                Aron.swap(arr, i, d);
                printTriangle(arr, d+1);
                Aron.swap(arr, i, d);
            }
        }
    }
    
    public static void test1()
    {
        int[] arr = {1, 2, 4, 5, 6, 8, 9, 11, 14};
        int[] w = new int[3];
        int d = 0;
        combination(arr, d, w);
    }
}
