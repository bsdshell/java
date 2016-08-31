import java.util.*;
import java.io.*;
import classfile.*;

public class Try44{
    public static void main(String[] args) {
        test0();
    }
    
    static void test0(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 
        Aron.inorder(b1.root);

        Aron.end();
    }
} 
