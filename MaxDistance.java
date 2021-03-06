import java.io.*;
import java.lang.String;
import java.util.*;
class MaxDistance {
    public static void main(String args[]) {
        int[] Arr = {10, 11, 2, 1, 0, 4};
        int max = MaxDistance(Arr);
        System.out.println("max=" + max);
    }


    public static int MaxDistance(int[] Arr) {
        int max_d = 0;
        if( Arr != null) {
            int len = Arr.length;
            int[] InxArr = new int[len];

            if(len > 0) {
                InxArr[0] = 0;
                int c=1;
                for(int i=1; i<len; i++) {
                    if(Arr[i-1] > Arr[i]) {
                        InxArr[c] = i;
                        c++;
                    }
                }
                int k=0;
                for(int i=0; i<len; i++) {
                    for(int j=k; j<c; j++) {
                        int d = len-1-i - InxArr[c-1-j];
                        if(d > 0 && Arr[len-1-i] > Arr[InxArr[c-1-j]]) {
                            if(d > max_d) {
                                max_d = d;
                                k=j;
                            }
                        }
                    }
                }
            }
        }
        return max_d;
    }
}
