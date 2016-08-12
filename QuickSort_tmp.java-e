	public static int Partition2(int[] Arr, int left, int right)
	{
		int ret = 0;
		if(Arr != null)
		{
			int len = right - left + 1; 
			if(len == 1)
				ret = left;
			else if(len > 1)
			{
				int pivot = Arr[left];
				int i=left;
				int j=right;
				while(i < j)
				{
					while(i < right && Arr[i] <= pivot ) i++;
					while(j > left && Arr[j] > pivot) j--;
					if(i<j)
					{ int tmp = Arr[i];
						Arr[i] = Arr[j];
						Arr[j] = tmp;
					}
				}
				int t = Arr[left];
				Arr[left] = Arr[j];
				Arr[j] = t;
				ret = j;
			}
		}
		return ret;
	}
