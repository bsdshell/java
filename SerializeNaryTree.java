import java.util.*;
import java.io.*;
import java.util.stream.*;
import classfile.*;

//class NNode<T>{
//    public T data;
//    public List<NNode> list = new ArrayList<>();
//    public NNode(T data){
//        this.data = data;
//    }
//}

public class SerializeNaryTree{
    public static void main(String[] args) {
        //test0();
        test00();
        //test1();
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
//        test02_buildTreeFromLevelOrder();
    }
    static void test0(){
        Aron.beg();
        Node root = new Node("1");
        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        Node node = deserialize(ite);
        int level = 0;
        Aron.prettyPrintGeneral(node, level);

        Aron.end();
    }
    static void test00(){
        Aron.beg();

        String fName = "file4.txt";
        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();
        Node root = deserialize(ite);
        int level = 0;
        Aron.prettyPrintGeneral(root, level);

        Aron.end();
    }

    static void test0_deserialize_debug(){
        Aron.beg();
        Node root = new Node("1");
        root.list.add(new Node("2"));
        root.list.add(new Node("3"));
        root.list.add(new Node("4"));
        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        Node node = deserialize_debug(ite);
        printNary(node);

        Aron.end();
    }
    static void test2_deserialize_debug(){
        Aron.beg();
        Node root = new Node("1");

        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");

        Node n35 = new Node("5");
        Node n36 = new Node("6");
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

        Node node = deserialize_debug(ite);
        printNary(node);

        Aron.end();
    }
    static void test1_deserialize_debug(){
        Aron.beg();
        Node root = new Node("1");
        Node n1 = new Node("2");
        Node n2 = new Node("3");
        Node n3 = new Node("4");

        Node n4 = new Node("5");
        Node n5 = new Node("6");

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

        Node node = deserialize_debug(ite);
        printNary(node);

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        Node root = new Node("1");
        root.list.add(new Node("2"));
        root.list.add(new Node("3"));
        root.list.add(new Node("4"));

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        Node node = deserialize(ite);
        printNary(node);

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        Node root = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");

        Node n4 = new Node("4");
        Node n5 = new Node("5");

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

        Node node = deserialize(ite);
        printNary(node);

        Aron.end();
    }
    static void test10_deserialize(){
        Aron.beg();
        Node root = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");

        Node n4 = new Node("4");
        Node n5 = new Node("5");

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

        Node node = deserializeStack(ite);
        printNary(node);

        Aron.end();
    }

    static void test11_deserializeStack(){
        Aron.beg();

        Node root = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");

        root.list.add(n2);
        root.list.add(n3);

        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        Node node = deserializeStack(ite);
        printNary(node);
 

        Aron.end();
    }

    static void test12_deserializeStack(){
        Aron.beg();
        Node root = new Node("1");
        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        Node node = deserializeStack(ite);
        printNary(node);

        Aron.end();
    }
    static void test13_deserializeStack(){
        Aron.beg();

        Node root = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        root.list.add(n2);
        root.list.add(n3);
        root.list.add(n4);
        printNary(root);

        String fName = "file4.txt";
        write(root, fName);

        List<String> list = read(fName);
        Aron.printList(list);
        Iterator<String> ite = list.iterator();

        Node node = deserializeStack(ite);
        printNary(node);

        Aron.end();
    }
    public static void printNary(Node curr){
        if(curr != null){
            Print.pbl(curr.data);
            for(int i=0; i<curr.list.size(); i++){
                printNary((Node)curr.list.get(i));
            } 
        }
    }

    public static void write(Node curr, String fname){
        if(fname != null){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fname))){
                serialize(curr, bw);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static List<String> read(String fname){
        List<String> list = null; 
        if(fname != null){
            try(BufferedReader br = new BufferedReader(new FileReader(fname))){
                String line; 
                while((line = br.readLine()) != null){
                    break;
                }
                list = Arrays.asList(line.trim().split("\\s+"));

                Aron.printList(list);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        return list;
    }
    //[ file=serializetree.html title=""
    // serialize n-ary tree from preorder to post order 
    public static void serialize(Node curr, BufferedWriter bw){
        if(curr != null){
            try{
                bw.write(curr.data + " ");
                for(Node node : curr.list){
                    serialize(node, bw);
                }
                bw.write("#" + " ");
            }catch(IOException e){
            }
        }
    }

    public static Node deserialize(Iterator<String> ite){
        Node root = null;
        if(ite.hasNext()){
            String token = ite.next();
            //Print.pbl("[" + token);
            if(!token.equals("#")){
                root = new Node(token);
                Node child = deserialize(ite);
                if(child != null)
                    root.list.add(child);
            }else{
                root = deserialize(ite);
            }
            //Print.pbl("]");
        }
        return root;
    }

    public static Node deserialize_debug(Iterator<String> ite){
        Node root = null;
        if(ite.hasNext()){
            String token = ite.next();
            if(!token.equals("#")){
                Print.p("[" + token);
                root = new Node(token);
                Node child = deserialize_debug(ite);
                if(child != null){
                    root.list.add(child);
                    Print.pbl(root.data + "->(" + child.data + ")");
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
    public static Node deserializeStack(Iterator<String> ite){
        Stack<Node> stack = new Stack<>(); 
        while(ite.hasNext()){
            String token = ite.next();
            if(!token.equals("#")){
                stack.push(new Node(token));
            }else{
                if(stack.size() > 1){
                    Node top = stack.pop();
                    Node peek = stack.peek();
                    peek.list.add(top);
                }
            }
        }
        return stack.peek();
    }
    //]

    public static void writeFile(Node r, String fName){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fName));
            levelOrder(r, bw);
            bw.close();
        }catch(IOException ie){
            ie.printStackTrace();
        }
    }
    public static void levelOrder(Node r, BufferedWriter bw){
        if(r != null){
            try{
                Queue<Node> queue = new LinkedList<Node>(); 
                if(r != null){
                    queue.add(r);
                    while(!queue.isEmpty()){
                        Node node = queue.remove();
                        bw.write(node.data + ":");
                        for(Node n : node.list){
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
       Map<Integer, List<Integer>> map = new HashMap<>(); 
       if(fName != null){
           try{
               BufferedReader br = new BufferedReader(new FileReader(fName));
               String line = null;
               while((line = br.readLine()) != null){
                   List<String> strList = Arrays.asList(line.split(":"));
                   // Java 8 lambda expr
                   List<Integer> list = strList.stream().map(Integer::parseInt).collect(Collectors.toList());
                   if(list.size() > 0) 
                       map.put(list.get(0), list.size() > 1? list.subList(1, list.size()) : new ArrayList<Integer>());
               }
           }catch(IOException ie){
               ie.printStackTrace();
           }
       }
       return map;
    }
    
    static void test00_writeFile(){
        Aron.beg();
        Node root = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        
        Node n5 = new Node("5");
        Node n6 = new Node("6");

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
        Node root = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        
        Node n5 = new Node("5");
        Node n6 = new Node("6");

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
        Node root = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        
        Node n5 = new Node("5");
        Node n6 = new Node("6");

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
        Node r = buildTreeFromLevelOrder(map, 1);  
        printNary(r);

        Aron.end();
    }
    public static Node buildTreeFromLevelOrder(Map<Integer, List<Integer>> map, Integer r){
        Node parent = null;
        if(map.size() > 0){
            parent = new Node(r + "");
            List<Integer> list = map.get(r);
            for(Integer n : list){
                parent.list.add(buildTreeFromLevelOrder(map, n));
            }
        }
        return parent;
    }
} 
