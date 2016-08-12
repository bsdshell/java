	public static boolean BinSearch(int[] arr, int left, int right, int key)
	{
		boolean ret = false;
		if(arr != null && left <= right)
		{
			int middle = (left + right)/2;
			if(key < arr[middle])
			{
                ret = BinSearch(arr, left, middle - 1, key);
			}
			else if(key > arr[middle])
			{
                ret = BinSearch(arr, middle + 1, right, key);
			}
			else 
				ret = true;
		}
		return ret;
	}
