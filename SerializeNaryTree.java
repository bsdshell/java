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
        if(ite.hasNext()){
            String token = ite.next();
            if(!token.equals("#")){
                NNode node = new NNode(token);
                NNode n = deserialize(ite);
                if(n != null)
                    node.list.add(n);

                return node;
            }else{
                return deserialize(ite);
            }
        }
        return null;
    }
//    public static NNode buildTree(String str){
//        if(!str.equals("#")){
//            Node r = new NNode(str);
//            r.left = buildTree(r.left, next());
//            r.right = buildTree(r.right, next());
//        }
//        return r;
//    }
} 
