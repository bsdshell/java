public class isPrime 
{
    public static void main(String[] args)
    {
        test1();
    }
    public static void test1()
    {
        int n = 100;
        System.out.println("is Prime="+n+" ["+ prime(2, 100)+"]");
        n = 971;
        System.out.println("is Prime="+n + " [" + prime(2, 971)+"]");
        n = 11211117;
        System.out.println("is Prime="+n + " [" + prime(2, 11217)+"]");
        n = 11;
        System.out.println("is Prime="+n + " [" + prime(2, 11)+"]");
    }

    public static boolean prime(int d, int n)
    {
        if(n == 2)
            return true;
        else if(n % d == 0)
            return false;
        else if(d*d <= n)
            return prime(d+1, n);
        else 
            return true;
    }
}
