public class Try 
{
				public static void main(String[] args)
				{
                    System.out.println("Hello World!");
                    int[] array = {3,0};
                    int left = 0;
                    int right = array.length-1;
                    mergeSort(array, left, right); 
                    for(int i=0; i<array.length; i++)
                        System.out.println("["+array[i]+"]");
				}
                public static void mergeSort(int[] array, int left, int right)
                {
                    int mid = (left + right)/2;
                    if(left < right)
                    {
                        mergeSort(array, left, mid);
                        mergeSort(array, mid+1, right);
                        merge(array, left, mid, right);
                    }
                }
                public static void merge(int[] array, int left, int mid, int right)
                {
                    if(array != null && left < right)
                    {
                        int i = left;
                        int j = mid + 1; 
                        int len = right-left + 1;
                        int k = 0;
                        int[] tmpArray = new int[len];
                        while(i <= mid || j <= right)
                        {
                            if(i > mid)
                            {
                                tmpArray[k] = array[j]; j++;
                            }
                            else if(j > right)
                            {
                                tmpArray[k] = array[i]; i++;
                            }
                            else
                            {
                                if(array[i] < array[j])
                                {
                                    tmpArray[k] = array[i];i++;
                                }
                                else
                                {
                                    tmpArray[k] = array[j];j++;
                                }
                            }
                            k++;
                        }
                        for(int x=0; x<len; x++)
                        {
                            array[left + x] = tmpArray[x];
                        }
                    }
                }
                4, 2, 1
                2, 4, 1
                2 1 4
                public static int partition(int[] array, int left, int right)
                {
                    int pivot = 0;
                    if(array != null)
                    {
                       int len = array.length; 
                       if(len > 1)
                       {
                           int first = array[0];
                       }
                    }
                }
}
