import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.List;

public class Add2{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        test();
    }

    static int countOp(long n){
        List<Long> list = new ArrayList<Long>();
        if(n == 0)
            list.add((long)0);
        else if(n > 0){
            while(n > 0){
                long r = n % 2;
                list.add(r);
                n = n/2;
            }
        }

        int sum = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == 1)
                sum += i+1;
        }
        return sum;
    }
    static void test(){
        System.out.println(countOp(5));
        System.out.println(countOp(3));
        System.out.println(countOp(6));
    }

    static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int[][] gridArray = new int[cityLength][cityWidth];
        
        for (int i = 0; i < cityLength; i++) {
            for (int j = 0; j < cityWidth; j++) {
                for (int k = 0; k < lockerXCoordinates.length; k++) {
                    int distance1 = Math.abs(lockerXCoordinates[k] - i + 1 );
                    int distance2 = Math.abs(lockerYCoordinates[k] - j + 1 );
                    int sumDistance = distance1 + distance2;
                    
                    if (k == 0) {
                        gridArray[i][j] = sumDistance;
                    } else {
                        if (sumDistance < gridArray[i][j]) {
                            gridArray[i][j] = sumDistance;
                        }
                    }
                }
            }
        }
        return gridArray;
    }

//    static int[][] grid(int height, int width, int[] coordX, int[] coordY) {
//        int[][] gridArray = new int[height][width];
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                for (int k = 0; k < coordX.length; k++) {
//                    int distance1 = Math.abs(coordX[k] - i + 1);
//                    int distance2 = Math.abs(coordY[k] - j + 1);
//                    int sumDistance = distance1 + distance2;
//                    
//                    if (k != 0) {
//                            if (sumDistance < gridArray[i][j]) {
//                                gridArray[i][j] = sumDistance;
//                            }
//                    }else{
//                        
//                        gridArray[i][j] = sumDistance;
//                    }
//                }
//            }
//        }
//        return gridArray;
//    }
}
