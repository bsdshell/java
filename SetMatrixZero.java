import java.util.ArrayList;
public class SetMatrixZero 
{
    public static void main(String[] args)
    {
        System.out.println("SetMatrixZero");
        int[][] Matrix = {
            {0, 3, 5, 6},
            {1, 3, 5, 0},
            {4, 0, 5, 6},
            {7, 3, 5, 6}
        };
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int len = Matrix.length; 
        for(int i=0; i<len; i++)
        {
            for(int j=0; j <len; j++)
            {
                if(Matrix[i][j] == 0)
                {
                    arrayList.add(i*len + j);
                }
            }
        }

        for(int i=0; i<len; i++)
        {
            for(int j=0; j <len; j++)
            {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for(int k=0; k<arrayList.size(); k++)
        {
            int row = arrayList.get(k)/len;
            int col = arrayList.get(k)%len;
            for(int i=0; i<len; i++)
            {
               for(int j=0; j<len; j++)
               {
                   if(i==row || j==col)
                   {
                       Matrix[i][j] = 0;
                   }
               } 
            }
        }

        for(int i=0; i<len; i++)
        {
            for(int j=0; j <len; j++)
            {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
