public class SieveEratosthenes 
{
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        Prime(1000000);
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("diff=" + diff);
    }

    //Find all the primes from 2 to n
    //Sieve of Eratosthenes Algorithm
    public static void Prime(int n)
    {
        boolean[] prime = new boolean[n+1];
        for(int i=0; i<n; i++)
            prime[i] = true;

        for(int i=2; i<Math.sqrt(n); i++)
        {
            int k=0;
            int index = i*i + k*i;
            if(prime[i])
            {
                while(index <= n)
                {
                    if(prime[index])
                        prime[index] = false;
                    index = i*i + k*i;
                    k++;
                }
            }
        }
        for(int i=2; i<n; i++)
        {
            System.out.println("[" + i + "]=" + prime[i]);
        }
    }
}
