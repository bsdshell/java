package company;

import java.util.List;

public class Math {
    public Math(){}
    public int[][] multiply(int[][] A, int[][] B)
    {
        int[][] C = null;
        if( A != null && B != null)
        {
            int alen = A.length;
            int blen = B.length;
            int clen = alen;
            C = new int[alen][alen];
            for(int c = 0; c < clen; c++)
            {
                for(int i = 0; i < alen; i++)
                {
                    int s = 0;
                    for(int j = 0; j < blen; j++)
                    {
                        s += A[i][j]*B[j][c];
                    }
                    C[i][c] = s;
                }
            }
        }
        return C;
    }
    public int[][] pow(int[][] A, int n)
    {
        if(A != null && n > 0)
        {
            if(n == 1)
                return A;
            else if(n % 2 == 0)
            {
                return multiply(pow(A, n/2), pow(A, n/2));
            }
            else
            {
                return multiply(A, multiply(pow(A, (n-1)/2), pow(A, (n-1)/2)));
            }
        }
        return null;
    }

    public int[] multiplyVector(int[][] A, int[] V)
    {
        int[] Vect = null;
        if(A != null && V != null)
        {
            int ColLen = A.length;
            int Vlen = V.length;
            if(ColLen > 0 && ColLen == Vlen)
            {
                int RowLen = A[0].length;
                if(RowLen == ColLen)
                {
                    Vect = new int[ColLen];
                    for(int i=0; i<ColLen; i++)
                    {
                        int s=0;
                        for(int j=0; j<RowLen; j++)
                        {
                            s += A[i][j]*V[j];
                        }
                        Vect[i] = s;
                    }
                }
            }
        }
        return Vect;
    }
    public int[][] add(int[][] A, int[][] B)
    {
        int[][] C = null;
        if(A != null && B != null)
        {
            int acollen = A.length;
            int bcollen = B.length;

            if(acollen > 0 && acollen == bcollen)
            {
                int arowlen = A[0].length;
                int browlen = B[0].length;
                if(acollen == bcollen && acollen == arowlen && arowlen == browlen)
                {
                    for(int i=0; i<arowlen; i++)
                    {
                        for(int j=0; j<browlen; j++)
                        {
                            C[i][j] = A[i][j] + B[i][j];
                        }
                    }
                }
            }
        }
        return C;
    }
    public int[][] subtract(int[][] A, int[][] B)
    {
        int[][] C = null;
        if(A != null && B != null)
        {
            int acollen = A.length;
            int bcollen = B.length;

            if(acollen > 0 && acollen == bcollen)
            {
                int arowlen = A[0].length;
                int browlen = B[0].length;
                if(acollen == bcollen && acollen == arowlen && arowlen == browlen)
                {
                    for(int i=0; i<arowlen; i++)
                    {
                        for(int j=0; j<browlen; j++)
                        {
                            C[i][j] = A[i][j] - B[i][j];
                        }
                    }
                }
            }
        }
        return C;
    }
    public int gcd(int a, int b)
    {
        if(a == 0 && b != 0)
            return b;
        else if( a != 0 && b == 0)
            return a;
        else if( a != 0 && b != 0)
            if(a >= b)
                return gcd(b, a%b);
            else
                return gcd(a, b%a);
        else
        {
            System.out.println("Error: a and b can't be both zero");
            return 0;
        }
    }
    public int lcm(int a, int b)
    {
        if(a != 0 || a != 0)
        {
            return (a*b)/gcd(a, b);
        }
        else
        {
            System.out.println("Error: a and b can't be both zero");
            return 0;
        }
    }
    public int[] allPrime(int n)
    {return null;}
    public boolean isPrime(int n)
    { return false;}
    public long sqrt(long n)
    { return 0;}
    public long deterimine(long[][] matrix)
    {
        return 0;
    }
    public boolean isInvertiable(long[][] matrix)
    { return true;}
    public List<List<Integer>> permutation(int n)
    { return null;}
    public List<List<Integer>> combination(int n)
    { return null;}

    public List<Long> solve(List<Long> polynomial)
    { return null;}
}
