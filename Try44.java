import java.util.*;
import java.io.*;
import classfile.*;
public class Try44{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();
        Map<String, SNode> map = new HashMap<String, SNode>(); 
        SNode n1 = new SNode(1);
        SNode n2 = new SNode(2);
        SNode n3 = new SNode(3);
        n1.next = n2;
        n2.next = n3;

        map.put("1", n1);
        Aron.printSLL(n1);

        map.put("1", new SNode(1));
        SNode nn = map.get("1");

        Aron.printSLL(nn);


        Aron.end();
    }
} 
