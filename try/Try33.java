import java.util.*;
import java.io.*;
import classfile.*;
public class Try33{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        List<String> list = new ArrayList<String>(); 
        Aron.beg();
        List<String> list = new ArrayList<String>(); 
        list.add("Pronunciation");
        list.add("Pronoun");
        list.add("opening new opportunities");
        Iterator<String> ite = list.iterator();

        while(ite.hasNext()){
            Print.p(ite.next());
        }
        Print.p(ite.next());

        Aron.end();
    }
} 
