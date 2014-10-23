public class FindMaxRotateArray 
{
				public static void main(String[] args)
				{
                    System.out.println("Find the max element in a sorted and rotated array");
                    int[] array = {1, 2, 4};
                    int left = 0;
                    int right = array.length - 1;
                    int max = findMax(array, left, right);
                    int key = 2;
                    boolean ret = findKey(array, left, right, key);
                    System.out.println("max="+max);
                    System.out.println("key="+ret);
				}
                public static int findMax(int[] array, int left, int right)
                {
                    int ret = 0; 
                    int len = right - left + 1;
                    if( len == 1)
                        ret = array[left];
                    else if( len == 2)
                        ret = array[left] > array[right]? array[left]:array[right];
                    else if(len > 2)
                    {
                        int mid = (left + right)/2;
                        if(array[left] < array[mid])
                            ret = findMax(array, mid, right);
                        else 
                            ret = findMax(array, left, mid);
                    }
                    return ret;
                }
                //No duplicated elements in the array
                public static boolean findKey(int[] array, int left, int right, int key)
                {
                    boolean ret = false;    
                    if(array != null)
                    {
                        int len = right - left + 1; 
                        if(len == 1)
                        {
                            if(key == array[left])
                                ret = true;
                        }
                        else if (len > 1)
                        {
                            int mid = (left + right)/2;    
                            if(array[left] < array[mid])
                            {
                                if(key > array[mid])
                                    ret = findKey(array, mid+1, right, key);
                                else if(key < array[mid])
                                {
                                    if(array[left] < key)
                                        ret = findKey(array, left, mid-1, key);
                                    else if(array[left] > key)
                                        ret = findKey(array, mid+1, right, key);
                                    else 
                                        ret = true;
                                }
                                else
                                    ret = true;
                            }
                            else if(array[left] > array[mid])
                            {
                                if(key < array[mid])
                                    ret = findKey(array, left, mid-1, key);
                                else if(key > array[mid])
                                {
                                    if(key < array[left])
                                    {
                                        ret = findKey(array, mid+1, right, key);
                                    }
                                    else if(key > array[left])
                                    {
                                        ret = findKey(array, left, mid-1, key);
                                    }
                                    else
                                        ret = true;
                                }
                                else
                                    ret = true;
                            }
                            else
                            {
                                ret = array[left] == key || array[right] == key? true : false;
                            }
                        }
                    }
                    return ret;
                }
}
