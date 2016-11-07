public class AddMultiString 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        System.out.println("9+98");
        System.out.println(Add("0", "1"));
    }
    public static String Add(String s1, String s2)
    {
        String ret = "0";
        if(s1 != null && s2 != null)
        {
            if(s1 == "0" && s2 == "0")
                return ret; 

            int len1 = s1.length();
            int len2 = s2.length();
            int maxlen = len1 > len2 ? len1 : len2;
            int[] A1 = new int[maxlen];
            int[] A2 = new int[maxlen];

            for(int i=0; i<maxlen; i++)
                A1[i] = A2[i] = 0;

            int index1 = 0, index2 = 0;
            while(index1 < len1)
            {
                A1[(maxlen-len1)+index1] = s1.charAt(index1)-'0';
                index1++;
            }

            while(index2 < len2)
            {
                A2[(maxlen-len2)+index2] = s2.charAt(index2)-'0';
                index2++;
            }

            int[] sum = new int[maxlen+1];
            int s=0, carry = 0, i=0;
            for(i=maxlen-1; i >= 0; i--)
            {
                s = A1[i] + A2[i] + carry;    
                sum[i+1] = s % 10;
                carry = s / 10;
            }
            if(carry > 0)
            {
                sum[0] = carry;
            }
            
            for(int j=0; j<maxlen+1; j++)
            {
                if((j == 0 && sum[j] > 0) || j > 0)
                    ret += sum[j] + "";
            }
        }
        return ret;
    }
}
