public class FindKeyRotateArray
{
				public static void main(String[] args)
				{
                   test1(); 
                   test2(); 
                   test3(); 
                   test4(); 
                   test5(); 
                   test6(); 
                   test7(); 
                   test8(); 
				}

                public static void test0()
                {
                    System.out.println("Find the max element in a sorted and rotated array");
                    int[] array = {1, 2, 3};
                    int left = 0;
                    int right = array.length - 1;
                    int key = 1;
                    boolean ret = findKey(array, left, right, key);
                    //boolean ret1 = binarySearch(array, left, right, key);
                    boolean ret2 = findKey(array, left, right, key);
                    System.out.println("key="+ret);
                    //System.out.println("key1="+ret1);
                    System.out.println("key2="+ret2);
                }
                public static void test1()
                {
                    System.out.println("Find the max element in a sorted and rotated array");
                    int[] array = {1, 2, 3};
                    int left = 0;
                    int right = array.length - 1;
                    int key = 1;
                    Aron.printArray(array);
                    System.out.println("key="+key);
                    boolean ret = findKey(array, left, right, key);
                    System.out.println("key="+ret);
                }

                public static void test2()
                {
                    System.out.println("Find the max Index in a sorted and rotated array");
                    int[] array = {1, 2, 3};
                    int left = 0;
                    int right = array.length - 1;
                    Aron.printArray(array);
                    int index = findMaxIndex(array, left, right);
                    System.out.println("index="+index);
                }
                public static void test3()
                {
                    System.out.println("Find the max Index in a sorted and rotated array");
                    int[] array = {2, 3, 1};
                    int left = 0;
                    int right = array.length - 1;
                    Aron.printArray(array);
                    int index = findMaxIndex(array, left, right);
                    System.out.println("index="+index);
                }

                public static void test4()
                {
                    System.out.println("Find the max Index in a sorted and rotated array");
                    int[] array = {2};
                    int left = 0;
                    int right = array.length - 1;
                    Aron.printArray(array);
                    int index = findMaxIndex(array, left, right);
                    System.out.println("index="+index);
                }

                public static void test5()
                {
                    System.out.println("Find the max Index in a sorted and rotated array");
                    int[] array = {2, 3, 1};
                    int left = 0;
                    int right = array.length - 1;
                    Aron.printArray(array);
                    int index = findMaxIndex(array, left, right);
                    System.out.println("index="+index);
                }

                public static void test6()
                {
                    System.out.println("Find the max Index in a sorted and rotated array");
                    int[] array = {2, 3, 1};
                    int left = 0;
                    int right = array.length - 1;
                    Aron.printArray(array);
                    int index = findMaxIndex2(array, left, right);
                    System.out.println("index="+index);
                }

                public static void test7()
                {
                    System.out.println("Find the min Index in a sorted and rotated array");
                    int[] array = {3, 2};
                    int left = 0;
                    int right = array.length - 1;
                    Aron.printArray(array);
                    int index = findMinIndex(array, left, right);
                    System.out.println("index="+index);
                }

                public static void test8()
                {
                    System.out.println("Find the min Index in a sorted and rotated array");
                    int[] array = {2, 3, 1};
                    int left = 0;
                    int right = array.length - 1;
                    Aron.printArray(array);
                    int index = findMinIndex(array, left, right);
                    System.out.println("index="+index);
                }

                public static int findMaxIndex(int[] array, int left, int right)
                {
                    int ret = -1; 
                    int len = right - left + 1;
                    if( len == 1)
                        ret = left;
                    else if( len == 2)
                        ret = array[left] > array[right]? left:right;
                    else if(len > 2)
                    {
                        int mid = (left + right)/2;
                        if(array[left] < array[mid])
                            ret = findMaxIndex(array, mid, right);
                        else 
                            ret = findMaxIndex(array, left, mid);
                    }
                    return ret;
                }
                
                public static boolean findKey(int[] array, int left, int right, int key)
                {
                    if(left == right)
                        return array[left] == key;

                    int maxIndex = findMaxIndex(array, left, right);
                        return binarySearch(array, left, maxIndex, key) || binarySearch(array, maxIndex+1, right, key); 
                } 
                public static boolean binarySearch(int[] array, int left, int right, int key)
                {
                    boolean ret = false;
                    if(array != null)
                    {
                        int mid = (left + right)/2;
                        if(left < right)
                        {
                            if(key < array[mid])
                            {
                                ret = binarySearch(array, left, mid-1, key);
                            }
                            else if(key > array[mid])
                            {
                                ret = binarySearch(array, mid+1, right, key);
                            }
                            else
                                ret = true;
                        }
                        else if(left == right)
                            ret = array[left] == key;
                    }
                    return ret;
                }

                // 1 2 3
                // 2 3 1
                // 1
                public static int findMinIndex(int[] array, int left, int right)
                {
                    if(array != null)
                    {
                        if(array[left] < array[right])
                            return left;
                        else 
                        {
                            int mid = (left + right)/2;
                            if(array[mid] < array[right])
                                return findMinIndex(array, left, mid);
                            else if(array[mid] > array[right])
                                return findMinIndex(array, mid+1, right);
                            else if(array[mid] == array[right])
                                return mid;
                        }
                    }
                    return -1;
                }
                // 1 2 3
                // 2 3 1
                // 3 1
                // 
                // 3 1 2

                public static int findMaxIndex2(int[] array, int left, int right)
                {
                    if( array != null)
                    {
                        //no rotation
                        // {2}
                        // {2, 3}
                        if(array[left] < array[right])
                            return right;
                        else
                        {
                            //One rotation at least
                            int mid = (left + right)/2;
                            if(array[left] < array[mid])
                                return findMaxIndex2(array, mid, right);
                            else if(array[left] > array[mid])
                                return findMaxIndex2(array, left, mid);
                            else if(array[left] == array[mid])
                                return mid;
                        }
                    }     
                    return -1;
                }

                //No duplicated elements in the array
                public static boolean findKeyRotateArray(int[] array, int left, int right, int key)
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
