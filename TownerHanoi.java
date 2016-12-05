import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TownerHanoi{
    public static void main(String[] args) {
        test1();
    }

    // gf http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/13/hanoi.html
    public static String hanoi(int n, int fromPeg, int toPeg) {
        if(n == 1){
            return (fromPeg + "->" + toPeg + "\n");
        }else{
            int helperPeg = 6 - fromPeg - toPeg; 
            String s1 = hanoi(n-1, fromPeg, helperPeg);
            String myStep = fromPeg + "->" + toPeg + "\n";
            String s2 = hanoi(n-1, helperPeg, toPeg);
            return s1 + myStep + s2; 
        }
    }

    static void test1(){
        Aron.beg();
        int n = 3;
        int fromPeg   = 1;
        int helperPeg = 2; 
        int toPeg     = 3;
        String ss        = hanoi(n, fromPeg, toPeg);
        Print.p(ss);

        Aron.end();
    }
} 

