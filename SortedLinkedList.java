package JavaLib.classfile; 

import classfile.*;

public class SortedLinkedList{
    public Node insert(Node node, int n){
        Node head = node;
        Node curr = node; 
        Node prev = null; 
        while(curr != null && n > curr.data){
            prev = curr;
            curr = curr.next;
        }

        if(curr != null){
            if(prev != null){
                // 3, [2]<-[4]  >  [2]<-{3}<-[4]
                prev.next = new Node(n);
                prev.next.next = curr;
            }else{
                // {1} [2] > {1}<-[2]
                head = new Node(n);
                head.next = curr;
            }
        }else{
            // [2] {3}  > [2]<-{3}
            if(prev != null){
                prev.next = new Node(n);
            }else{
                // {3}
                head = new Node(n);
            }
        }
        return head;
    }
} 
