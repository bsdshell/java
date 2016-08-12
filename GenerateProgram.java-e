import java.util.*;
import java.io.*;
import classfile.*;
public class GenerateProgram{
    public static void main(String[] args) {
        String str = "Try199";
        for(String s : args){
            Print.p("s=" + s);
        }
        Print.p("len=" + args.length);
        if(args.length > 0)
            test0(args[0]);
        else
            Print.p("no argument is provided");
    }
    static void test0(String pName){
        Aron.beg();
        String fName = "/Users/cat/myfile/github/java/program.txt";
        List<String> list = Aron.readFile(fName);

        for(int i=0; i<list.size(); i++){ 
            String s = list.get(i);
            String newStr  = s.replace("Program", pName);
            Print.p(newStr);
            list.set(i, newStr);
        }
        Aron.line();

        List<String> list2 = new ArrayList<String>(); 
        for(int i=0; i<list.size(); i++){ 
            String s = list.get(i);
            Print.p(s);
            list2.add(s + "\n");
        }

        String newName = "/Users/cat/myfile/github/java/" + pName + ".java";
        Aron.writeFile(newName, list2);

        Aron.end();
    }
} 
