import java.util.Random;

public class RandomNumber
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] array = RandomNum(1, 10);
        Aron.printArray(array);
    }
    // generate 0 - [n-1]
    public static int[] RandomNum(int init, int n)
    {   
        int[] array = new int[n]; 
        Random rn = new Random();
        for(int i=0; i<n; i++)
            array[i] = rn.nextInt(n) + init;

        return array;
    }
}
