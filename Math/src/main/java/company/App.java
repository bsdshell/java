package company;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Math m = new Math();
        int[][] A = new int[2][2];

        double mid = m.rootofthree(8);
        System.out.println("mid="+mid);

        double p = m.power(0.3, -3);
        System.out.println("p="+p);
    }
}
