import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

public class SerializeBinary {
    public static void main(String[] args) {
        test_serializeLevel();
        test_deserializeBinary();
        test1_deserializeIterator();
        test2_deserializeIterator();
        test_deSerializeIndex();
        test1_deSerializeIndex();
    }
    static void test_serializeLevel(){
        Aron.beg();
       
        BST bin = new BST();
        bin.insert(10);
        bin.insert(5);
        bin.insert(15);
        bin.insert(12);

        Aron.inorder(bin.root);
        Aron.line();
        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("text/level0.txt"));

            serializeLevel(bin.root, out1);
            out1.close();

            BufferedReader levelIn = new BufferedReader(new FileReader("text/level0.txt"));

            List<List<String>> list = createMap(levelIn);
            int depth = 0;
            
            Map<String, Node> map = new HashMap<String, Node>(); 
            Node root = deserializeLevel(list, map);
            Aron.line();
            Aron.inorder(root);
        } catch(Exception e) {
        }
        Aron.end();
    }
    
    static void test1_deserializeIterator(){
        Aron.beg();
        BST bin = new BST();
        bin.insert(10);
        bin.insert(11);

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("text/out.txt"));
            serializeBinary(bin.root, out);
            out.close();

            List<String> list = Aron.readFileOneLine("text/out.txt");
            Iterator<String> ite = list.iterator();
            Node root = deserializeIterator(ite);

            Aron.inorder(root);

        } catch(Exception e) {
        }

        Aron.end();
    } 

    static void test2_deserializeIterator(){
        Aron.beg();
        BST bin = new BST();
        bin.insert(10);
        bin.insert(5);
        bin.insert(15);
        bin.insert(12);

        try {
            Aron.inorder(bin.root);
            Aron.line();

            BufferedWriter out = new BufferedWriter(new FileWriter("text/out.txt"));
            serializeBinary(bin.root, out);
            out.close();

            List<String> list = Aron.readFileOneLine("text/out.txt");
            Iterator<String> ite = list.iterator();
            Node root = deserializeIterator(ite);

            Aron.inorder(root);

        } catch(Exception e) {
        }

        Aron.end();
    } 
    
    static void test_deserializeBinary(){
        Aron.beg();

        BST bin = new BST();
        bin.insert(10);
        bin.insert(5);
        bin.insert(15);
        bin.insert(12);

        try {
            Aron.inorder(bin.root);

            BufferedWriter out = new BufferedWriter(new FileWriter("text/out.txt"));
            serializeBinary(bin.root, out);
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("text/out.txt"));

            int[] A = new int[1];
            A[0] = 0;
            String[] Array = readFile(in);
            Node root = deserializeBinary(Array, A);
            Aron.inorder(root);
        } catch(Exception e) {
        }

        Aron.end();
    }

    static void test_deserializeBinary3(){
        Aron.beg();

        BST bin = new BST();
        bin.insert(10);
        bin.insert(5);
        bin.insert(15);
        bin.insert(12);

        System.out.println("");
        try {
            Aron.inorder(bin.root);

            BufferedWriter out = new BufferedWriter(new FileWriter("text/out.txt"));
            serializeBinary(bin.root, out);
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("text/out.txt"));

            String[] Array = readFile(in);
            Node root = deserializeBinary3(Array);
            Aron.inorder(root);
        } catch(Exception e) {
        }

        Aron.end();
    }

    //Use Level order to write node to file
    public static void serializeLevel(Node root, BufferedWriter out1) {
        try {
            if(root != null) {
                Queue<Node> q1 = new LinkedList<Node>();
                Queue<Node> q2 = new LinkedList<Node>();
                q1.add(root);
                while(q1.peek() != null || q2.peek() != null) {
                    while(q1.peek() != null) {
                        String s = "";
                        Node node = q1.remove();
                        s += node.data + " ";
                        if(node.left != null) {
                            s += node.left.data + " ";
                            q2.add(node.left);
                        } else
                            s += "#" + " ";
                        if(node.right != null) {
                            s += node.right.data + " ";
                            q2.add(node.right);
                        } else
                            s += "#" + " ";

                        s += "\n";
                        out1.write(s);
                    }

                    while(q2.peek() != null) {
                        String s = "";
                        Node node = q2.remove();
                        s += node.data + " ";
                        if(node.left != null) {
                            s += node.left.data + " ";
                            q1.add(node.left);
                        } else
                            s += "#" + " ";
                        if(node.right != null) {
                            s += node.right.data + " ";
                            q1.add(node.right);
                        } else
                            s += "#" + " ";

                        s += "\n";
                        out1.write(s);
                    }
                }

            }
        } catch(Exception e) {
        }
    }

    public static void serializeBinary(Node root, BufferedWriter out) {
        try {
            if(root != null) {
                out.write(root.data + " ");
                serializeBinary(root.left, out);
                serializeBinary(root.right, out);
            } else {
                out.write("# ");
            }
        } catch(Exception e) {
            System.err.println("Error" + e.getMessage());
        }
    }
    public static List<List<String>> createMap(BufferedReader in) {
        List<List<String>> list = new ArrayList<List<String>>();
        try {
            String line = null;
            while((line = in.readLine()) != null) {
                line = line.trim();
                String[] array = line.split("\\s+");
                if(array != null && array.length == 3) {
                    list.add(Arrays.asList(array));
                }
            }
        } catch(Exception e) {
        }
        return list;
    }

    public static String[] readFile(BufferedReader in) {
        String[] Array = null;
        try {
            String str;
            boolean end = false;
            while( (str = in.readLine()) != null && !end) {
                System.out.println(str);
                Array = str.split("\\s");
                end = true;
            }
            in.close();

            for(int i=0; Array != null && i<Array.length; i++) {
                System.out.println("["+Array[i]+"]");
            }

        } catch(Exception e) {
            System.err.println("Error" + e.getMessage());
        }
        return Array;
    }

    public static Node deserializeLevel(List<List<String>> listList, Map<String, Node> map) {
        Node root = null;
        for(List<String> list : listList){
            if(root == null){
                root = new Node(Integer.parseInt(list.get(0)));
                map.put(list.get(0), root);

                String left = list.get(1);
                if(!left.equals("#")){
                    Node node =  new Node(Integer.parseInt(left));
                    root.left = node;
                    map.put(left, node);
                }

                String right = list.get(2);
                if(!right.equals("#")){
                    Node node =  new Node(Integer.parseInt(right));
                    root.right = node;
                    map.put(right, node);
                }
            }
            else{
                Node curr = map.get(list.get(0));
                if(curr == null){
                    curr = new Node(Integer.parseInt(list.get(0)));
                    map.put(list.get(0), curr);
                }

                String left = list.get(1);
                if(!left.equals("#")){
                    Node node =  new Node(Integer.parseInt(left));
                    curr.left = node;
                    map.put(left, node);
                }

                String right = list.get(2);
                if(!right.equals("#")){
                    Node node =  new Node(Integer.parseInt(right));
                    curr.right = node;
                    map.put(right, node);
                }
            }
        }
        return root;
    }

    public static Node deserializeBinary(String[] Array, int[] A) {
        Node root = null;
        if(Array != null && A[0] < Array.length) {
            if(!Array[A[0]].equals("#")) {
                root = new Node(Integer.parseInt(Array[A[0]]));
                A[0]++;
                root.left = deserializeBinary(Array, A);
                A[0]++;
                root.right = deserializeBinary(Array, A);
            }
        } else {
            Print.plb("root is null");
        }
        return root;
    }

    static int index = 0;
    public static Node deserializeBinary3(String[] Array) {
        Node root = null;
        if(Array != null && index < Array.length) {
            if(!Array[index].equals("#")) {
                root = new Node(Integer.parseInt(Array[index]));
                index++;
                root.left = deserializeBinary3(Array);
                index++;
                root.right = deserializeBinary3(Array);
            }
        } else {
            Print.plb("root is null");
        }
        return root;
    }

    public static Node deserializeIterator(Iterator<String> ite) {
        Node root = null;
        if(ite.hasNext()) {
            String token = ite.next();
            if(!token.equals("#")) {
                root = new Node(Integer.parseInt(token));
                root.left = deserializeIterator(ite);
                root.right = deserializeIterator(ite);
            }
        } 
        return root;
    }

    public static void test_deSerializeIndex() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(15);
        b1.insert(12);
        b1.insert(14);
        b1.insert(17);
        b1.insert(19);
        b1.insert(130);
        b1.insert(16);
        b1.insert(10);

        Aron.inorder(b1.root);
        Aron.line();

        try {
            FileWriter fstream = new FileWriter("text/out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            int k=0;
            serializeIndex(b1.getRoot(), out, k);
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("text/out.txt"));
            Map<Integer, Integer> map = buildMapFromFile(in);

            k = 0;
            Node root = deSerializeIndex(map, k);
            Aron.inorder(root);

        } catch(Exception e) {
            System.err.println("Error" + e.getMessage());
        }
        Aron.end();
    }

    public static void test1_deSerializeIndex() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(12);

        Aron.inorder(b1.root);
        Aron.line();

        try {
            FileWriter fstream = new FileWriter("text/out1.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            int k=0;
            serializeIndex(b1.getRoot(), out, k);
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("text/out1.txt"));
            Map<Integer, Integer> map = buildMapFromFile(in);

            k = 0;
            Node root = deSerializeIndex(map, k);
            Aron.inorder(root);

        } catch(Exception e) {
            System.err.println("Error" + e.getMessage());
        }
        Aron.end();
    }

    //Write nodes to file with inorder traversal
    public static void serializeIndex(Node root, BufferedWriter out, int k) {
        if(root != null) {
            String s = k + ":" + root.data + "\n";
            try {
                serializeIndex(root.left, out, 2*k + 1);
                out.write(s);
                serializeIndex(root.right, out, 2*k + 2);
            } catch(Exception e) {
                System.err.println("Error" + e.getMessage());
            }
        }
    }
    //Initialize k = 0 
    public static Node deSerializeIndex(Map<Integer,Integer> map, int k) {
        if(map.containsKey(k)) {
            Integer data = map.get(k);
            Node root = new Node(data);
            root.left = deSerializeIndex(map, 2*k + 1);
            root.right = deSerializeIndex(map, 2*k + 2);
            return root;
        }
        return null;
    }

    public static Map<Integer,Integer> buildMapFromFile(BufferedReader in) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        try {
            String line = null;
            while((line = in.readLine()) != null) {
                line = line.trim();
                String[] array = line.split(":");
                if(array.length == 2) {
                    map.put(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
                } else
                    System.err.println("Error: invalid file format");
            }
        } catch(Exception e) {
            System.err.println("Error" + e.getMessage());
        }
        return map;
    }
}
