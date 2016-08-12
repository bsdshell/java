import java.util.*;
import java.math.*;
import classfile.*;

public class CarmichaelNumber{
    public static void main(String[] args) {
        test1();
    }
    //[ file=carmichaelnumber.html title=""
    public static boolean CarmichaelNumber(int n){
        for(int b=2; b<n; b++){
            if(gcd(b, n) == 1){
                BigDecimal bg = new BigDecimal(b);
                BigDecimal big = bg.pow(n-1);
                BigDecimal bgremainder = big.remainder(new BigDecimal(n));
                if(Integer.parseInt(bgremainder.toString()) != 1)
                    return false;
            }
        }
        return true;
    }
    //]
    static void test0(){
        Aron.beg();
        System.out.println("3=[" + gcd(0, 3) + "]");
        System.out.println("1=[" + gcd(2, 3) + "]");
        System.out.println("1=[" + gcd(3, 2) + "]");
        System.out.println("3=[" + gcd(3, 3) + "]");
        System.out.println("2=[" + gcd(2, 4) + "]");
        System.out.println("2=[" + gcd(6, 4) + "]");
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        int carnum = 561;
        System.out.println("561 is Carmichael Number? [" + CarmichaelNumber(carnum) + "]");
        Aron.end();
    }
    public static int gcd(int a, int b){
        if(a == 0 && b > 0)
            return b;
        else if( a > 0 && b == 0){
            return a;
        }else{
            if(a >= b){
                return gcd(a-b, b);
            }else{
                return gcd(a, b-a);
            }
        }
    }
}
