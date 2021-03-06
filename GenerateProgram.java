import java.util.*;
import java.io.*;
import classfile.*;

/**
* Generate Java simple template code
*/ 
public class GenerateProgram{
    final static String fName = "/Users/cat/myfile/github/java/text/program.txt";
    public static void main(String[] args) {
        printInfo();
        Print.p("Argument len=" + args.length);

        for(String s : args){
            Print.p("args:" + s);
        }
        if(args.length > 0)
            generateCode(args[0]);
        else
            Print.p("No Class Name is provided");
    }

    public static void printInfo(){
        Print.pb(fName);
    }
    /**
    * Generate Java file from a class name(e.g. MyClass => MyClass.java)
    */ 
    public static void generateCode(String pName){
        Aron.beg();
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
