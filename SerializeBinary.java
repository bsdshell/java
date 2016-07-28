import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

public class SerializeBinary {
    public static void main(String[] args) {
        test1();
    }
    static void test0(){
        Aron.beg();
        BST bin = new BST();
        bin.insert(10);
        bin.insert(11);

        System.out.println("");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));
            BufferedWriter out1 = new BufferedWriter(new FileWriter("level.txt"));

            serializeBinary(bin.root, out);
            serializeBinary2(bin.root, out1);
            out.close();
            out1.close();

            BufferedReader in = new BufferedReader(new FileReader("out.txt"));
            BufferedReader levelIn = new BufferedReader(new FileReader("level.txt"));

            BST newbin = new BST();
            int[] A = new int[1];
            A[0] = 0;
            String[] Array = readFile(in);
            List<List<String>> list = createMap(levelIn);
            int depth = 0;

            Node root = deserializeBinary2(list, depth);
            preorder(root);
            //newbin.root = deserializeBinary2(list, depth);
            //newbin.preorder(newbin.root);
        } catch(Exception e) {
        }
        Aron.end();
    }
    
    static void test1(){
        Aron.beg();

        BST bin = new BST();
        bin.insert(10);
        bin.insert(11);

        System.out.println("");
        try {
            FileWriter fstream = new FileWriter("out.txt");
            FileWriter fstream1 = new FileWriter("level.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            BufferedWriter out1 = new BufferedWriter(fstream1);

            serializeBinary(bin.root, out);
            serializeBinary2(bin.root, out1);
            out.close();
            out1.close();

            BufferedReader in = new BufferedReader(new FileReader("out.txt"));
            BufferedReader levelIn = new BufferedReader(new FileReader("level.txt"));

            BST newbin = new BST();
            int[] A = new int[1];
            A[0] = 0;
            String[] Array = readFile(in);
            //newbin.root = deserializeBinary(Array, A);
            //newbin.preorder(newbin.root);
            List<List<String>> listList = createMap(levelIn);
            int depth = 0;

            Node root = deserializeBinary2(listList, depth);
            preorder(root);
            //newbin.root = deserializeBinary2(listList, depth);
            //newbin.preorder(newbin.root);
        } catch(Exception e) {
        }
 
        Aron.end();
    }

    //Use Level order to write node to file
    public static void serializeBinary2(Node root, BufferedWriter out1) {
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

    public static Node deserializeBinary2(List<List<String>> listList, int depth) {
        Node curr = null;
        System.out.println("size=" + listList.size());
        System.out.println("depth=[" + depth+"]");
        if(depth < listList.size()) {
            curr = new Node(Integer.parseInt(listList.get(depth).get(0)));
            if(listList.get(depth).get(1) != "#") {
                curr.left = deserializeBinary2(listList, depth+1);
            } else
                curr.left = null;

            if(listList.get(depth).get(2) != "#") {
                curr.right = deserializeBinary2(listList, depth+1);
            } else
                curr.right = null;
        }
        return curr;
    }

//    public static Node deserializeBinary(String[] Array, int[] A) {
//        Node root = null;
//        if(Array != null && A[0] < Array.length) {
//            System.out.println("k="+A[0]+" Node("+Array[A[0]]+")");
//            System.out.println("Array["+Array[A[0]]+"]");
//            if(!Array[A[0]].equals("#")) {
//                root = new Node(Integer.parseInt(Array[A[0]]));
//                A[0]++;
//                root.left = deserializeBinary(Array, A);
//                A[0]++;
//                root.right = deserializeBinary(Array, A);
//            }
//        } else {
//            System.out.println("root is null");
//        }
//        return root;
//    }

    public static Node deserializeBinaryNew(Iterator<String> ite) {
        Node root = null;
        if(ite.hasNext()) {
            String token = ite.next();
            if(!token.equals("#")) {
                root = new Node(Integer.parseInt(token));
                root.left = deserializeBinaryNew(ite);
                root.right = deserializeBinaryNew(ite);
            }else
                return deserializeBinaryNew(ite);
        } 
        return root;
    }

    public static void preorder(Node root) {
        if(root != null) {
            System.out.println("preorder-["+root.data+"]");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void test3() {
        BST b1 = new BST();

        b1.insert(15);
        b1.insert(12);
        b1.insert(14);
        b1.insert(17);
        b1.insert(19);
        b1.insert(130);
        b1.insert(16);
        b1.insert(10);

        Aron.inorder(b1.getRoot());

        try {
            FileWriter fstream = new FileWriter("out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            int k=1;
            writeNodeToFile(b1.getRoot(), out, k);
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("out.txt"));
            Map<Integer, Integer> map = buildMapFromFile(in);

            k = 1;
            Node root = buildTree(map, k);
            System.out.println("[preorder]");
            Aron.preorder(root);

            System.out.println();
            System.out.println("[inorder]");
            Aron.inorder(root);

            System.out.println();
            System.out.println("[postorder]");
            Aron.postorder(root);


        } catch(Exception e) {
            System.err.println("Error" + e.getMessage());
        }
    }

    //Write nodes to file with inorder traversal
    public static void writeNodeToFile(Node root, BufferedWriter out, int k) {
        if(root != null) {
            String s = k + ":" + root.data + "\n";
            try {
                out.write(s);
                writeNodeToFile(root.left, out, 2*k);
                writeNodeToFile(root.right, out, 2*k + 1);
            } catch(Exception e) {
                System.err.println("Error" + e.getMessage());
            }
        }
    }
    //Initialize k = 1
    public static Node buildTree(Map<Integer,Integer> map, int k) {
        if(map.containsKey(k)) {
            Integer data = map.get(k);
            Node root = new Node(data);
            root.left = buildTree(map, 2*k);
            root.right = buildTree(map, 2*k+1);
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
