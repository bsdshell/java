import java.util.*;
import java.io.*;
import classfile.*;

class NNode{
    public String data;
    public List<NNode> list = new ArrayList<NNode>();
    public NNode(String data){
        this.data = data;
    }
}

public class SerializeNaryTree{
    public static void main(String[] args) {
        test0();
        test1();
        test2();

        test10();
        test11();
        test12();
        test_deserialize_debug();
    }
    static void test0(){
        Aron.beg();
        NNode root = new NNode("1");

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode node = deserialize(ite);
        printNary(node);

        Aron.end();
    }

    static void test_deserialize_debug(){
        Aron.beg();
        NNode root = new NNode("1");
        root.list.add(new NNode("2"));
        root.list.add(new NNode("3"));
        root.list.add(new NNode("4"));
        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode node = deserialize_debug(ite);
        printNary(node);

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        NNode root = new NNode("1");
        root.list.add(new NNode("2"));
        root.list.add(new NNode("3"));
        root.list.add(new NNode("4"));

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode node = deserialize(ite);
        printNary(node);

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        NNode root = new NNode("1");
        NNode n2 = new NNode("2");
        NNode n3 = new NNode("3");

        NNode n4 = new NNode("4");
        NNode n5 = new NNode("5");

        root.list.add(n2);
        root.list.add(n3);

        n3.list.add(n4);
        n3.list.add(n5);

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode node = deserialize(ite);
        printNary(node);

        Aron.end();
    }
    static void test10(){
        Aron.beg();
        NNode root = new NNode("1");
        NNode n2 = new NNode("2");
        NNode n3 = new NNode("3");

        NNode n4 = new NNode("4");
        NNode n5 = new NNode("5");

        root.list.add(n2);
        root.list.add(n3);

        n3.list.add(n4);
        n3.list.add(n5);

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode node = deserializeStack(ite);
        printNary(node);

        Aron.end();
    }

    static void test11(){
        Aron.beg();

        NNode root = new NNode("1");
        NNode n2 = new NNode("2");
        NNode n3 = new NNode("3");


        root.list.add(n2);
        root.list.add(n3);

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode node = deserializeStack(ite);
        printNary(node);
 

        Aron.end();
    }

    static void test12(){
        Aron.beg();
        NNode root = new NNode("1");
        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode node = deserializeStack(ite);
        printNary(node);

        Aron.end();
    }
    public static void printNary(NNode curr){
        if(curr != null){
            System.out.println("[" + curr.data + "]"); 
            for(NNode n : curr.list){
                printNary(n);
            }
        }
    }

    public static void write(NNode curr, String fname){
        if(fname != null){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fname))){
                serialize(curr, bw);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static List<String> read(String fname){
        List<String> list = new ArrayList<String>(); 
        if(fname != null){
            try(BufferedReader br = new BufferedReader(new FileReader(fname))){
                String line; 
                while((line = br.readLine()) != null){
                    break;
                }
                String[] arr = line.trim().split("\\s+");
                for(int i=0; i<arr.length; i++){
                    if(arr[i].length() > 0)
                        list.add(arr[i]); 
                } 
                Aron.printList(list);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        return list;
    }
    //[ file=serializetree.html title=""
    // serialize n-ary tree from preorder to post order 
    public static void serialize(NNode curr, BufferedWriter bw){
        if(curr != null){
            try{
                bw.write(curr.data + " ");
                for(NNode node : curr.list){
                    serialize(node, bw);
                }
                bw.write("#" + " ");
            }catch(IOException e){
            }
        }
    }

    public static NNode deserialize(Iterator<String> ite){
        NNode root = null;
        if(ite.hasNext()){
            String token = ite.next();
            if(!token.equals("#")){
                root = new NNode(token);
                NNode child = deserialize(ite);
                if(child != null)
                    root.list.add(child);
            }else{
                root = deserialize(ite);
            }
        }
        return root;
    }

    public static NNode deserialize_debug(Iterator<String> ite){
        NNode root = null;
        if(ite.hasNext()){
            String token = ite.next();
//            Print.pl("[");
//            Print.pb(token);
            if(!token.equals("#")){
                root = new NNode(token);
                NNode child = deserialize_debug(ite);
                if(child != null)
                    root.list.add(child);
            }else{
                //Print.pl("]");
                root = deserialize_debug(ite);
            }
        }
        return root;
    }
    //]

    //[ file=deserializetree.html title=""
    // deserialize with stack
    public static NNode deserializeStack(Iterator<String> ite){
        Stack<NNode> stack = new Stack<NNode>(); 
        while(ite.hasNext()){
            String token = ite.next();
            if(!token.equals("#")){
                stack.push(new NNode(token));
            }else{
                if(stack.size() > 1){
                    NNode top = stack.pop();
                    NNode peek = stack.peek();
                    peek.list.add(top);
                }
            }
        }
        return stack.peek();
    }
    //]

//    public static NNode buildTree(String str){
//        if(!str.equals("#")){
//            Node r = new NNode(str);
//            r.left = buildTree(r.left, next());
//            r.right = buildTree(r.right, next());
//        }
//        return r;
//    }
} 
