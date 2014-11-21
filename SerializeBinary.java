import java.io.*;
import java.lang.String;
import java.util.*;

class Node{
        int data;
        Node left;
        Node right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Binary{
    Node root;
    public Binary(){
        root = null;
    }
    public void insert(int data){
        if(root == null){
            root = new Node(data);
        }else{
            Node current = root;
            boolean end = false;
            while(!end){
                if(data < current.data){
                   if(current.left == null){
                       current.left = new Node(data);
                       end = true;
                   }else{
                       current = current.left; 
                   }
                }
                else{
                    if(current.right== null){
                       current.right= new Node(data);
                        end = true;
                    }
                    else{
                       current = current.right;
                    }
                }
            }
        } 
    }
    public void preorder(Node root)
    {
        if(root != null){
            System.out.println("preorder["+root.data+"]");
            preorder(root.left);
            preorder(root.right);
        }
    }

}

public class SerializeBinary 
{
    public static void main(String[] args)
    {
        System.out.println("SerializeBinary");
        Binary bin = new Binary();
        bin.insert(10);
        bin.insert(11);
        //bin.insert(13);
        /*
        bin.insert(15);
        bin.insert(1);
        bin.insert(7);
        bin.insert(12);
        bin.insert(20);
        bin.insert(19);
        */
        //bin.preorder(bin.root);
        System.out.println("");
        try{
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

            Binary newbin = new Binary();
            int[] A = new int[1];
            A[0] = 0;
            String[] Array = readFile(in);
            //newbin.root = deserializeBinary(Array, A);
            //newbin.preorder(newbin.root);
            List<List<String>> listList = createMap(levelIn);
            for(List list: listList)
            {
                System.out.println("aron["+list.get(0)+"]->["+list.get(1)+" "+list.get(2)+"]");
            }
            int depth = 0;

            Node root = deserializeBinary2(listList, depth);
            preorder(root);
            //newbin.root = deserializeBinary2(listList, depth);
            //newbin.preorder(newbin.root);
        }
        catch(Exception e){
        }
    }

    //Use Level order to write node to file
    public static void serializeBinary2(Node root, BufferedWriter out1)
    {
        try
        {
            if(root != null)
            {
                Queue<Node> q1 = new LinkedList<Node>();
                Queue<Node> q2 = new LinkedList<Node>();    
                q1.add(root);
                while(q1.peek() != null || q2.peek() != null)
                {
                    while(q1.peek() != null)
                    {
                        String s = "";
                        Node node = q1.remove();
                        s += node.data + " ";
                        if(node.left != null)
                        {
                            s += node.left.data + " ";
                            q2.add(node.left);
                        }
                        else 
                            s += "#" + " ";
                        if(node.right != null)
                        {
                            s += node.right.data + " ";
                            q2.add(node.right);
                        }
                        else
                            s += "#" + " ";

                        s += "\n";
                        out1.write(s);
                    }

                    while(q2.peek() != null)
                    {
                        String s = "";
                        Node node = q2.remove();
                        s += node.data + " ";
                        if(node.left != null)
                        {
                            s += node.left.data + " ";
                            q1.add(node.left);
                        }
                        else 
                            s += "#" + " ";
                        if(node.right != null)
                        {
                            s += node.right.data + " ";
                            q1.add(node.right);
                        }
                        else
                            s += "#" + " ";

                        s += "\n";
                        out1.write(s);
                    }
                }

            } 
        }
        catch(Exception e)
        {
        }
    }

    public static void serializeBinary(Node root, BufferedWriter out)
    {
        try{
            if(root != null){
                out.write(""+root.data);
                out.write(" ");
                serializeBinary(root.left, out);
                serializeBinary(root.right, out);
            }else{
                out.write("#");
                out.write(" ");
            }
        }catch(Exception e){
            System.err.println("Error" + e.getMessage());
        }
    }
    public static List<List<String>> createMap(BufferedReader in)
    {
        List<List<String>> listList = new ArrayList<List<String>>(); 
        try
        {
            String line = null;
            while((line = in.readLine()) != null)
            {
                line = line.trim();
                String[] array = line.split(" ");
                if(array != null && array.length == 3)
                {
                    listList.add(Arrays.asList(array));
                }
            }
        }
        catch(Exception e)
        {
        }
        return listList;
    }
    public static String[] readFile(BufferedReader in){
        String[] Array = null;
        try{
            String str;
            boolean end = false;
            while( (str = in.readLine()) != null && !end){
                System.out.println(str);
                Array = str.split("\\s");
                end = true;
            }
            in.close();
            
            for(int i=0; Array != null && i<Array.length; i++){
                System.out.println("["+Array[i]+"]");
            }
            
        }
        catch(Exception e){
            System.err.println("Error" + e.getMessage());
        }
        return Array;
    }
    public static Node deserializeBinary2(List<List<String>> listList, int depth)
    {
        Node curr = null;
        System.out.println("size=" + listList.size());
        System.out.println("depth=[" + depth+"]");
        if(depth < listList.size())
        {
            curr = new Node(Integer.parseInt(listList.get(depth).get(0)));
            if(listList.get(depth).get(1) != "#")
            {
                curr.left = deserializeBinary2(listList, depth+1); 
            }
            else 
                curr.left = null;

            if(listList.get(depth).get(2) != "#")
            {
                curr.right = deserializeBinary2(listList, depth+1); 
            }
            else
                curr.right = null;
        }
        return curr;
    }
        
    public static Node deserializeBinary(String[] Array, int[] A){
        Node root = null;
        if(Array != null && A[0] < Array.length){
            System.out.println("k="+A[0]+" Node("+Array[A[0]]+")");
            System.out.println("Array["+Array[A[0]]+"]");
            if(!Array[A[0]].equals("#")){
                root = new Node(Integer.parseInt(Array[A[0]]));
                A[0]++;
                root.left = deserializeBinary(Array, A);     
                A[0]++;
                root.right = deserializeBinary(Array, A);     
            }else{
            }
        }else{
            System.out.println("root is null");
        }
        return root;
    }
    public static void preorder(Node root)
    {
        if(root != null)
        {
            System.out.println("preorder-["+root.data+"]");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
