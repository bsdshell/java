import java.util.*;
import java.io.*;
import classfile.*;

public class connectLevelOrder{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        BST bst = Aron.createBin(); 
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(bst.root, level, isLeaf);
        Ut.l();
        Node head = levelLink(bst.root);
        Aron.printSLL(head);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        BST bst = Aron.createBin(); 
        levelOrderLink(bst.root);
        Print.pbl(bst.root.left.next.data);
        Aron.end();
    }

    // connect each *levelorder*, connect level order, link levelorder
    public static void levelOrderLink(Node r){
        Queue<Node> q1 = new LinkedList<>(); 
        Queue<Node> q2 = new LinkedList<>(); 
        if(r != null){
            q1.add(r);
            while(q1.size() > 0 || q2.size() > 0){
                Node prev = null;
                while(q1.size() > 0){
                    Node curr = q1.poll();
                    if( prev != null)
                        prev.next = curr;
                    prev = curr;
                    if(curr.left != null)
                        q2.add(curr.left);
                    if(curr.right != null)
                        q2.add(curr.right);
                }

                prev = null;
                while(q2.size() > 0){
                    Node curr = q2.poll();
                    if( prev != null)
                        prev.next = curr;
                    prev = curr;
                    if(curr.left != null)
                        q1.add(curr.left);
                    if(curr.right != null)
                        q1.add(curr.right);
                }
            }
        }
    }


    // connect all node in level order *levelorder*
    public static Node levelLink(Node r){
        Node head = null;
        if( r != null){
            Queue<Node> queue = new LinkedList<>(); 
            queue.add(r);
            Node prev = null;
            while(queue.size() > 0){
                Node curr = queue.poll();
                if(prev != null)
                    prev.next = curr;
                else
                    head = prev = curr;

                prev = curr;

                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return head;
    }
} 

