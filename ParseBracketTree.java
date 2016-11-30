import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.util.stream.*;
import classfile.*;

enum Type{
    OPEN,
    CLOSE,
    ITEM,
    NONE
}

public class ParseBracketTree{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
    }
    public static void test0(){
        Aron.beg();

        String str = "[ 1 ]";
        String[] arr = str.split("\\s+");
        List<String> list = Arrays.asList(arr);
        Iterator<String> ite = list.iterator(); 
        Node root = buildTree(ite);
        int level = 0;
        Aron.prettyPrintGeneral(root, level);

        Aron.printList(list);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        String str = "[ 1"
                    +" [ 12 ]"
                    +" [ 13 ]"
                    +" ]";
        String[] arr = str.split("\\s+");
        List<String> list = Arrays.asList(arr);
        Iterator<String> ite = list.iterator(); 
        Node root = buildTree(ite);
        int level = 0;
        Aron.prettyPrintGeneral(root, level);
        Aron.preorderGraph(root);
        Aron.printList(list, "(");
         
        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        String str = "[ 1"
                    +" [ 12 ]"
                    +" [ 13 ]"
                    +" [ 14 ]"
                    +"  [ 111 "
                         +" [ 112 ]"
                         +" [ 113 ]"
                    +"  ]"
                    +" ]";
        String[] arr = str.split("\\s+");
        List<String> list = Arrays.asList(arr);
        Iterator<String> ite = list.iterator(); 
        Node root = buildTree(ite);
        int level = 0;
        Aron.prettyPrintGeneral(root, level);
        Aron.preorderGraph(root);
        Aron.printList(list, "(");
         
        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        String str = "[ 1 ]";
        String[] arr = str.split("\\s+");
        List<String> list = Arrays.asList(arr);
        List<String> list2 = new ArrayList<String>(); 

        for(String s : list){
            if(getTokenType(s) != Type.OPEN)
                list2.add(s);
        }
        
        Iterator<String> ite = list2.iterator(); 
        Node root = buildTreeRecursion(ite);
        int level = 0;
        Aron.prettyPrintGeneral(root, level);
        Aron.preorderGraph(root);
        Aron.printList(list, "(");
         
        Aron.end();
    }
    public static void test4(){
        Aron.beg();
        String str = "[ 1"
                    +" [ 12 ]"
                    +" [ 13 ]"
                    +" [ 14 ]"
                    +"  [ 111 "
                         +" [ 112 ]"
                         +" [ 113 ]"
                    +"  ]"
                    +" ]";
        String[] arr = str.split("\\s+");
        List<String> list = Arrays.asList(arr);
        List<String> list2 = new ArrayList<String>(); 

        for(String s : list){
            if(getTokenType(s) != Type.OPEN)
                list2.add(s);
        }

        Aron.printList(list2, "(");
        
        Iterator<String> ite = list2.iterator(); 
        Node root = buildTreeRecursion(ite);
        int level = 0;
        Aron.prettyPrintGeneral(root, level);
        Aron.preorderGraph(root);
        Aron.printList(list, "(");
         
        Aron.end();
    }
    public static boolean validate(String fname){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line = null;
            while( (line = br.readLine()) != null){
                Print.pbl(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public static Node buildTree(Iterator<String> ite){
        Stack<Node> stack = new Stack<>();

        while(ite.hasNext()){
            String item = ite.next();
            if(getTokenType(item) == Type.ITEM){
                stack.push(new Node(item));
            }else if(getTokenType(item) == Type.CLOSE){
                if(stack.size() > 1){
                    Node node = stack.pop();
                    stack.peek().list.add(node);
                }
            }
        }
        return stack.peek();
    }
    public static Node buildTreeRecursion(Iterator<String> ite){
        Node root = null;
        if(ite.hasNext()){
            String item = ite.next();
            if(getTokenType(item) == Type.ITEM){
                root = buildTreeRecursion(ite);
            }else if(getTokenType(item) == Type.CLOSE){
                Node ret = buildTreeRecursion(ite);     
            }
        }
        return root;
    }

    public static Type getTokenType(String str){
        Pattern r = Pattern.compile("\\d+");
        if(str.equals("[")){
            return Type.OPEN;
        }else if(str.equals("]")){
            return Type.CLOSE;
        }else if(r.matcher(str).find()){
            return Type.ITEM;
        }
        return Type.NONE;
    }
    
    static void test9(){
        Aron.beg();
        Type type1 = getTokenType("[");
        Type type2 = getTokenType("]");
        Type type3 = getTokenType("123");
        Print.pbl(type1);
        Print.pbl(type2);
        Print.pbl(type3);
        Aron.end();
    }
} 

