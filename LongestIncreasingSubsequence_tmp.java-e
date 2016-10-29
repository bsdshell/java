    //Dynamic programming algorithm solves Longest Increasing Subsequence
    //with complexity O(n^2)
    public static int LISDP(int[] array)
    {
        int len = array.length;
        int[] maxlist = new int[len];
        for(int i=0; i<len; i++)
            maxlist[i] = 1;

        for(int i=1; i<len; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(array[j] < array[i])            
                    maxlist[i] = Math.max(1 + maxlist[j], maxlist[i]);
            }            
        } 
        
        int m = Integer.MIN_VALUE;
        for(int i=0; i<len; i++)
        {
            if(maxlist[i] > m)
                m = maxlist[i];
        }
        return m;
    }
