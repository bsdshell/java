import java.util.*;
import java.util.stream.*;
import java.io.*;
import classfile.*;

public class Filter {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();
        List<Integer> list1 = Arrays.asList(1, 2, 3); 
        List<Integer> list2 = Arrays.asList(2, 1, 3); 
        List<Integer> left = list1.stream().filter(x -> x < 2).collect(Collectors.toList());
        List<Integer> right = list1.stream().filter(x -> x > 2).collect(Collectors.toList());
        Aron.printList(left);
        Aron.printList(right);

        

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        Aron.end();
    }
}

