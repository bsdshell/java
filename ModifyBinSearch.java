public class ModifyBinSearch 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] array = {1, 4, 9, 20, 5};
        int left = 0; int right = array.length-1;
        int max = max(array, left, right);
        System.out.println("max="+max);
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
