import classfile.Aron;
import classfile.Print;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Print.p("Hello World");
        test0();
    }
    static void test0(){
        Aron.beg();

        String fName = "/Users/cat/myfile/github/snippets/snippet.m";
        List<List<String>> list2d = readCode(fName);

        Aron.printList2dln(list2d);

        Aron.end();
    }

    static List<List<String>> readCode(String fName){
        List<String> list = Aron.readFile(fName);
        List<List<String>> list2d = new ArrayList<List<String>>();

        List<String> line = new ArrayList<String>();
        for(String s : list){
            if(s.trim().length() > 0){
                line.add(s);
            }else{
                if(line.size() > 0) {
                    list2d.add((ArrayList<String>) line);
                    line = new ArrayList<String>();
                }
            }
        }
        return list2d;
    }

}
