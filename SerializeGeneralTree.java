import java.util.*;
import java.io.*;
import classfile.*;

public class SerializeGeneralTree{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        String file = "./text/try.txt";
        
        try{
            Node r = Aron.createGeneralTree();
            Aron.inorderGeneralTree(r);
            Ut.l();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            serializeGeneralTree(r, bw);
            bw.close();
            
            List<String> list = Aron.readFileOneLineSplit(file);
            Aron.printlnList(list);

            Ut.l();
            Node dr = deserializeGeneralTree(list);
            Aron.inorderGeneralTree(dr);
        }catch(IOException e){
        }
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }

    public static void serializeGeneralTree(Node r, BufferedWriter bw){
        if(r != null){
            try{
            bw.write(r.data + " ");
            for(Node n : r.list)
                serializeGeneralTree(n, bw);

            bw.write(" # ");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    // use one stack to deserialize general tree
    public static Node deserializeGeneralTree(List<String> list){ 
        Stack<Node> stack = new Stack<>();
        for(String s : list){
            if(!s.equals("#")){
                Node n = new Node(s);
                stack.push(n);
            }else{
                if(stack.size() > 1){
                    Node top = stack.pop();
                    stack.peek().list.add(top);
                }
            }
        }
        return stack.peek();
    }
} 

