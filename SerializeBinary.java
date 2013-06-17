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
    public void inorder(Node root)
    {
        if(root != null){
            inorder(root.left);
            System.out.println("inorder["+root.data+"]");
            inorder(root.right);
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
        bin.insert(5);
        bin.insert(15);
        bin.insert(1);
        bin.insert(7);
        bin.insert(12);
        bin.insert(20);
        bin.preorder(bin.root);
        System.out.println("------");
        try{
            FileWriter fstream = new FileWriter("out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
             
            serializeBinary(bin.root, out); 
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("out.txt"));	

            Binary newbin = new Binary();
            int[] A = new int[1];
            A[0] = 0;
            String[] Array = readFile(in);
            newbin.root = deserializeBinary(Array, A);
            newbin.preorder(newbin.root);
        }
        catch(Exception e){
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
}
