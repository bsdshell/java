public class ModifyBinSearch 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] array = {1, 2, 10, 4};
        int left = 0; int right = array.length-1;
        int max = max2(array, left, right);
        System.out.println("max="+max);
    }
    public static int max2(int[] array, int left, int right)
    {
        if(array != null)
        {
            int mid = (left + right)/2;
            if(mid < right)
            {
                if(array[mid] < array[mid + 1])
                {
                    return max2(array, mid+1, right);
                }
                else
                    return max2(array, left, mid);
            }
            else
                return array[mid];
        }
        return -1000;
    }
    public static int max(int[] array, int left, int right)
    {
        if(array != null)
        {
            if(array.length == 0)
            {
                return -1000;
            }
            else if(array.length == 1)
            {
                return array[0]; 
            }
            else //two or more elements 
            {
                int mid = (left + right)/2;
                if(right - left > 1)
                {
                    if(array[mid-1] < array[mid])
                        return max(array, mid, right);
                    else
                        return max(array, left, mid-1);
                }
                else
                {
                    return array[left] < array[right]? array[right]:array[left];
                }
            }
        }
        return -1000;
    }
}
