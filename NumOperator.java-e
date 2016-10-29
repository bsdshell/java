import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.List;

public class NumOperator{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        test();
    }
    static int numOperator(int n){
        List<Integer> list = new ArrayList<Integer>();
        if(n == 0)
            list.add(0);
        else if(n > 0){
            while(n > 0){
                int r = n % 2;
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
        System.out.println(numOperator(5));
        System.out.println(numOperator(3));
    }
}
