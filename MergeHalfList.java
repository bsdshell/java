package classfile;

import java.io.*;
import java.lang.String;
import java.util.*;

class MergeHalfList{
    public static void main(String args[]) {
    }

    public static SNode mergeHalf(SNode head) {
        SNode curr = head;
        Queue<SNode> q0 = new LinkedList<SNode>();
        Queue<SNode> q1 = new LinkedList<SNode>();
        int count = 0;
        while(curr != null) {
            System.out.println("curr[" + curr.data+"]");
            q1.add(new SNode(curr.data));
            curr = curr.next;
        }

        int halfsize = q1.size()/2;
        int size = q1.size();
        System.out.println("q1size[" + q1.size()+"]");
        System.out.println("q1size/2[" + halfsize +"]");
        for(int i=0; i<= size/2; i++) {
            SNode node = q1.remove();
            System.out.println("node[" + node.data+"] i=[" + i+"]");
            q0.add(new SNode(node.data));
        }

        System.out.println("q0.size[" + q0.size()+"]");
        SNode prevPair = null;
        SNode currPair = null;
        SNode newHead = null;
        while(q0.peek() != null) {
            SNode n0 = q0.remove();
            SNode n1 = null;
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
