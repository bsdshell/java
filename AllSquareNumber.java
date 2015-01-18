public class AllSquareNumber 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        SquareNumber(10);
    }
    //(X-1)^2 = X^2 -2X + 1
    //=>   X^2= (X-1)^2 + 2X + 1
    //=>   X^2= (X-1)^2 + (X-1) + X 
    static void SquareNumber(int n)
    {
        int prev = 0;
        int prevSquare = 0;   
        for(int curr=1; curr<=n; curr++)
        {
            prevSquare = prevSquare + prev + curr;
            System.out.println("["+prevSquare+"]");
            prev = curr;
        }
    }
}
