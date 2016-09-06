import java.util.*;
import java.io.*;
import classfile.*;

class NNode<T>{
    public T data;
    public List<NNode> list = new ArrayList<NNode>();
    public NNode(T data){
        this.data = data;
    }
}

public class SerializeNaryTree{
    public static void main(String[] args) {
//        test1();
//        test2();
//
//        test0_deserialize_debug();
//        test1_deserialize_debug();
//        test2_deserialize_debug();
//        test00_writeFile();
          //test01_readFile();
//        test10_deserialize();
//        test11_deserializeStack();
//        test12_deserializeStack();
//        test13_deserializeStack();
          test02_buildTreeFromLevelOrder();
    }
    static void test0(){
        Aron.beg();
        NNode<String> root = new NNode<String>("1");

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode<String> node = deserialize(ite);
        printNary(node);

        Aron.end();
    }

    static void test0_deserialize_debug(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        root.list.add(new NNode("2"));
        root.list.add(new NNode("3"));
        root.list.add(new NNode("4"));
        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode<String> node = deserialize_debug(ite);
        printNary(node);

        Aron.end();
    }
    static void test2_deserialize_debug(){
        Aron.beg();
        NNode<String> root = new NNode("1");

        NNode<String> n2 = new NNode("2");
        NNode<String> n3 = new NNode("3");
        NNode<String> n4 = new NNode("4");

        NNode<String> n35 = new NNode("5");
        NNode<String> n36 = new NNode("6");
        n3.list.add(n35);
        n3.list.add(n36);

        root.list.add(n2);
        root.list.add(n3);
        root.list.add(n4);

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode<String> node = deserialize_debug(ite);
        printNary(node);

        Aron.end();
    }
    static void test1_deserialize_debug(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        NNode<String> n1 = new NNode("2");
        NNode<String> n2 = new NNode("3");
        NNode<String> n3 = new NNode("4");

        NNode<String> n4 = new NNode("5");
        NNode<String> n5 = new NNode("6");

        n3.list.add(n4);
        n3.list.add(n5);
        root.list.add(n1);
        root.list.add(n2);
        root.list.add(n3);

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode<String> node = deserialize_debug(ite);
        printNary(node);

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        root.list.add(new NNode("2"));
        root.list.add(new NNode("3"));
        root.list.add(new NNode("4"));

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode<String> node = deserialize(ite);
        printNary(node);

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        NNode<String> n2 = new NNode("2");
        NNode<String> n3 = new NNode("3");

        NNode<String> n4 = new NNode("4");
        NNode<String> n5 = new NNode("5");

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

        NNode<String> node = deserialize(ite);
        printNary(node);

        Aron.end();
    }
    static void test10_deserialize(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        NNode<String> n2 = new NNode("2");
        NNode<String> n3 = new NNode("3");

        NNode<String> n4 = new NNode("4");
        NNode<String> n5 = new NNode("5");

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

        NNode<String> node = deserializeStack(ite);
        printNary(node);

        Aron.end();
    }

    static void test11_deserializeStack(){
        Aron.beg();

        NNode<String> root = new NNode("1");
        NNode<String> n2 = new NNode("2");
        NNode<String> n3 = new NNode("3");

        root.list.add(n2);
        root.list.add(n3);

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode<String> node = deserializeStack(ite);
        printNary(node);
 

        Aron.end();
    }

    static void test12_deserializeStack(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode<String> node = deserializeStack(ite);
        printNary(node);

        Aron.end();
    }
    static void test13_deserializeStack(){
        Aron.beg();

        NNode<String> root = new NNode("1");
        NNode<String> n2 = new NNode("2");
        NNode<String> n3 = new NNode("3");
        NNode<String> n4 = new NNode("4");
        root.list.add(n2);
        root.list.add(n3);
        root.list.add(n4);
        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        NNode<String> node = deserializeStack(ite);
        printNary(node);

        Aron.end();
    }
    public static void printNary(NNode<String> curr){
        if(curr != null){
            Print.plb(curr.data);
            for(int i=0; i<curr.list.size(); i++){
                printNary((NNode)curr.list.get(i));
            } 
        }
    }

    public static void write(NNode<String> curr, String fname){
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
    public static void serialize(NNode<String> curr, BufferedWriter bw){
        if(curr != null){
            try{
                bw.write(curr.data + " ");
                for(NNode<String> node : curr.list){
                    serialize(node, bw);
                }
                bw.write("#" + " ");
            }catch(IOException e){
            }
        }
    }

    public static NNode<String> deserialize(Iterator<String> ite){
        NNode<String> root = null;
        if(ite.hasNext()){
            String token = ite.next();
            //Print.plb("[" + token);
            if(!token.equals("#")){
                root = new NNode(token);
                NNode<String> child = deserialize(ite);
                if(child != null)
                    root.list.add(child);
            }else{
                root = deserialize(ite);
            }
            //Print.plb("]");
        }
        return root;
    }

    public static NNode<String> deserialize_debug(Iterator<String> ite){
        NNode<String> root = null;
        if(ite.hasNext()){
            String token = ite.next();
            if(!token.equals("#")){
                Print.p("[" + token);
                root = new NNode(token);
                NNode<String> child = deserialize_debug(ite);
                if(child != null){
                    root.list.add(child);
                    Print.plb(root.data + "->(" + child.data + ")");
                }
                Print.p("]");
            }else{
                Print.p("[" + token);
                root = deserialize_debug(ite);
                Print.p("]");
            }
        }
        return root;
    }
    //]

    //[ file=deserializetree.html title=""
    // deserialize with stack
    public static NNode<String> deserializeStack(Iterator<String> ite){
        Stack<NNode> stack = new Stack<NNode>(); 
        while(ite.hasNext()){
            String token = ite.next();
            if(!token.equals("#")){
                stack.push(new NNode(token));
            }else{
                if(stack.size() > 1){
                    NNode<String> top = stack.pop();
                    NNode<String> peek = stack.peek();
                    peek.list.add(top);
                }
            }
        }
        return stack.peek();
    }
    //]

    public static void writeFile(NNode<String> r, String fName){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fName));
            levelOrder(r, bw);
            bw.close();
        }catch(IOException ie){
            ie.printStackTrace();
        }
    }
    public static void levelOrder(NNode<String> r, BufferedWriter bw){
        if(r != null){
            try{
                Queue<NNode> queue = new LinkedList<NNode>(); 
                if(r != null){
                    queue.add(r);
                    while(!queue.isEmpty()){
                        NNode<String> node = queue.remove();
                        bw.write(node.data + ":");
                        for(NNode<String> n : node.list){
                            bw.write(n.data + ":");
                            queue.add(n);
                        }
                        bw.write("\n");
                    }
                }
            }catch(IOException ie){
                ie.printStackTrace();
            }
        }
    }
    public static Map<Integer, List<Integer>> readFile(String fName){
       Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(); 
       if(fName != null){
           try{
               BufferedReader br = new BufferedReader(new FileReader(fName));
               String line = null;
               while((line = br.readLine()) != null){
                   String[] arr = line.split(":");
                   List<Integer> list = new ArrayList<Integer>(); 
                   for(int i=0; i<arr.length; i++){
                       if(arr[i].trim().length() > 0){
                           list.add(Integer.parseInt(arr[i]));
                       }
                   } 
                   if(list.size() > 1){
                       map.put(list.get(0), list.subList(1, list.size()));
                   }else if(list.size() == 1){
                       map.put(list.get(0), new ArrayList<Integer>());
                   }
               }
           }catch(IOException ie){
               ie.printStackTrace();
           }
       }
       return map;
    }
    
    static void test00_writeFile(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        NNode<String> n2 = new NNode("2");
        NNode<String> n3 = new NNode("3");
        NNode<String> n4 = new NNode("4");
        
        NNode<String> n5 = new NNode("5");
        NNode<String> n6 = new NNode("6");

        n3.list.add(n5);
        n3.list.add(n6);

        root.list.add(n2);
        root.list.add(n3);
        root.list.add(n4);

        printNary(root);
        String fName = "file5.txt";
        writeFile(root, fName);
        Aron.end();
    }
    static void test01_readFile(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        NNode<String> n2 = new NNode("2");
        NNode<String> n3 = new NNode("3");
        NNode<String> n4 = new NNode("4");
        
        NNode<String> n5 = new NNode("5");
        NNode<String> n6 = new NNode("6");

        n3.list.add(n5);
        n3.list.add(n6);

        root.list.add(n2);
        root.list.add(n3);
        root.list.add(n4);

        printNary(root);
        String fName = "file5.txt";
        writeFile(root, fName);
//        Map<Integer, List<Integer>> map = readFile(fName); 
//        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
//            Print.pp(entry.getKey());
//            Aron.printList(entry.getValue());
//        } 
        Aron.end();
    }
    static void test02_buildTreeFromLevelOrder(){
        Aron.beg();
        NNode<String> root = new NNode("1");
        NNode<String> n2 = new NNode("2");
        NNode<String> n3 = new NNode("3");
        NNode<String> n4 = new NNode("4");
        
        NNode<String> n5 = new NNode("5");
        NNode<String> n6 = new NNode("6");

        n3.list.add(n5);
        n3.list.add(n6);

        root.list.add(n2);
        root.list.add(n3);
        root.list.add(n4);

        printNary(root);
        String fName = "file5.txt";
        writeFile(root, fName);
        Map<Integer, List<Integer>> map = readFile(fName); 
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            Print.pp(entry.getKey());
            Aron.printList(entry.getValue());
        } 
        NNode<String> r = buildTreeFromLevelOrder(map, 1);  
        printNary(r);

        Aron.end();
    }
    public static NNode<String> buildTreeFromLevelOrder(Map<Integer, List<Integer>> map, Integer r){
        NNode<String> parent = null;
        if(map.size() > 0){
            parent = new NNode(r + "");
            List<Integer> list = map.get(r);
            for(Integer n : list){
                parent.list.add(buildTreeFromLevelOrder(map, n));
            }
        }
        return parent;
    }
} 
