import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;

public class MyDict{
    public static void main(String[] args) {
        //test0();
        Print.pbl("len=" + args.length);
        if(args.length > 0){
            Print.pbl("args[0]=" + args[0]);
            find(args[0]);
        }
        //test1();
    }
    public static void test0(){
        Aron.beg();
        String file = "/Users/cat/myfile/github/java/text/mydict.txt";
        List<ArrayList<String>> list2d = Aron.readFileSaperater(file);
        Aron.printList2dArr(list2d);

        Aron.end();
    }

    public static void find(String word){
        String pattern = "\\w+";
        Pattern r = Pattern.compile(word, Pattern.CASE_INSENSITIVE);

        String file = "/Users/cat/myfile/github/java/text/mydict.txt";
        List<ArrayList<String>> list2d = Aron.readFileSaperater(file);
        for(ArrayList<String> list : list2d){
            String[] arr = list.get(0).split("\\s+");

            Matcher mat = r.matcher(arr[0]);
            if(mat.find()){
                Print.pbl("w=" + arr[0] + " " + list);
            }
        }
        //Aron.printList2dArr(list2d);
    } 
    public static void test1(){
        Aron.beg();
        find("abacus");
        Aron.end();
    }
} 

