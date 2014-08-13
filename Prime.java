public class Prime
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        long startTime = System.currentTimeMillis();
        Prime(100000);
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("diff=" + diff);
    }

    //Find all the primes from 2 to n
    public static void Prime(int n)
    {
        boolean[] prime = new boolean[n];
        for(int i=0; i<n; i++)
            prime[i] = true;

        for(int i=2; i<n; i++)
        {
            for(int j=2; j<i && prime[i]; j++)
            {
                if(prime[j] && (i % j) == 0)
                    prime[i] = false;
            }
        }
        for(int i=2; i<n; i++)
        {
            System.out.println("[" + i + "]=" + prime[i]);
        }
    }
}
