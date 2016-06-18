public class isPrime {
    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1() {
        int n = 100;
        System.out.println("is Prime="+n+" ["+ prime(2, 100)+"]");
        n = 971;
        System.out.println("is Prime="+n + " [" + prime(2, 971)+"]");
        n = 11211117;
        System.out.println("is Prime="+n + " [" + prime(2, 11217)+"]");
        n = 11;
        System.out.println("is Prime="+n + " [" + prime(2, 11)+"]");
    }

    public static void test2() {
        System.out.println("test2()");
        System.out.println("p = 2 [" + isPrimeLoop(2) + "]");
        System.out.println("p = 11[" + isPrimeLoop(11) + "]");
        System.out.println("p = 20[" + isPrimeLoop(20) + "]");
        System.out.println("p = 30[" + isPrimeLoop(30) + "]");
        System.out.println("p = 121[" + isPrimeLoop(121) + "]");
        System.out.println("p = 122[" + isPrimeLoop(122) + "]");
        System.out.println("p = 123[" + isPrimeLoop(123) + "]");
        System.out.println("p = 124[" + isPrimeLoop(124) + "]");
        System.out.println("p = 127[" + isPrimeLoop(127) + "]");
    }

    //[file=checkprime.html title=""
    public static boolean prime(int d, int n) {
        if(n == 2)
            return true;
        else if(n % d == 0)
            return false;
        else if(d*d <= n)
            return prime(d+1, n);
        else
            return true;
    }
    public static boolean isPrimeLoop(int n) {
        if( n == 2)
            return true;
        for(int d=2; d*d <= n; d++) {
            if(n % d == 0)
                return false;
        }
        return true;
    }
    //]
}
