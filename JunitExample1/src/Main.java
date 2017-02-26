import classfile.Aron;
import classfile.Print;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.List;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Print.p("Hello World");
        test0();
        test1();
    }
    static void test0(){
        Aron.beg();
        ListMultimap<String, String> mmap = ArrayListMultimap.create();
        mmap.put("dog", "exact");
        mmap.put("dog", "exact1");
        mmap.put("cat", "exactly");
        mmap.put("scene", "sense");

        for (String firstName : mmap.keySet()) {
            List<String> lastNames = mmap.get(firstName);
            out.println(firstName + ": " + lastNames);
        }

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        Aron.end();
    }
}
