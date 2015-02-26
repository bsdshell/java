public final class Aron 
{

    //Need to fix the Node issue
    
    public static void inorder(Node curr)
    {
		if(curr != null)
		{
			inorder(curr.left);
			System.out.print(curr.data + " ");
			inorder(curr.right);
		}
    }

    public static void preorder(Node curr)
    {
        if(curr != null)
		{
			System.out.print(curr.data + " ");
			inorder(curr.left);
			inorder(curr.right);
		}
    }

    public static void postorder(Node curr)
    {
         if(curr != null)
		{
			inorder(curr.left);
			inorder(curr.right);
			System.out.print(curr.data + " ");
		}
    }
    

    public static void printArray2D(int[][] arr)
    {
        if(arr != null)
        {
            for(int c=0; c<arr.length; c++)
            {
                for(int r=0; r<arr[0].length; r++)
                {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void printArray(int[] arr)
    {
        if(arr != null)
        {
            for(int r=0; r<arr.length; r++)
            {
                System.out.print("["+arr[r]+"]");
            }
            System.out.println();
        }
    }

    public static void printTable(int[][] arr)
    {
        if(arr != null)
        {
            for(int c=0; c<arr.length; c++)
            {
                for(int r=0; r<arr[0].length; r++)
                {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
