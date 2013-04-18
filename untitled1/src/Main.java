public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] rowArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int[] colArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        int[][] table = new int[18][18];
        for(int c = 0; c < 18; c++)
        {
            for(int r=0; r < 18; r++)
            {
                table[c][r] = (c+r) % 18;
                System.out.print("["+table[c][r]+"]");
            }
            System.out.println("");
        }
    }
}
