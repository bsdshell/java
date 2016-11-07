package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;

class MergeHalfList{
    public static void main(String args[]) {
    }

    public static Node mergeHalf(Node head) {
        Node curr = head;
        Queue<Node> q0 = new LinkedList<Node>();
        Queue<Node> q1 = new LinkedList<Node>();
        int count = 0;
        while(curr != null) {
            System.out.println("curr[" + curr.data+"]");
            q1.add(new Node(curr.data));
            curr = curr.next;
        }

        int halfsize = q1.size()/2;
        int size = q1.size();
        System.out.println("q1size[" + q1.size()+"]");
        System.out.println("q1size/2[" + halfsize +"]");
        for(int i=0; i<= size/2; i++) {
            Node node = q1.remove();
            System.out.println("node[" + node.data+"] i=[" + i+"]");
            q0.add(new Node(node.data));
        }

        System.out.println("q0.size[" + q0.size()+"]");
        Node prevPair = null;
        Node currPair = null;
        Node newHead = null;
        while(q0.peek() != null) {
            Node n0 = q0.remove();
            Node n1 = null;
            if(q1.peek() != null) {
                n1 = q1.remove();
                System.out.println("q1[" + n1.data+"]");
            }

            n0.next = n1;
            currPair = n0;

            if(prevPair!= null)
                prevPair.next.next = currPair;
            else
                newHead = currPair;
            prevPair = currPair;
        }
        return newHead;
    }
}
