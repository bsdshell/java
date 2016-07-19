import java.util.*;
import java.io.*;
import classfile.*;

public class GraphLoopPath{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
    }
    static void test0(){
        Aron.beg();
        Map<Node, Node> map = new HashMap<Node, Node>();

        Set<Node> set = new HashSet<Node>();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n2.next = n3;
        map.put(n1, n2);
        map.put(n2, n4);
        map.put(n3, n4);
        map.put(n2, n1);

        System.out.println("n1, n4=[" + isAPath(n1, n4, map, set) + "]"); 
        System.out.println("n2, n3=[" + isAPath(n2, n3, map, set) + "]"); 
        System.out.println("n1, n2=[" + isAPath(n1, n2, map, set) + "]"); 

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        Map<Node, Node> map = new HashMap<Node, Node>();

        Set<Node> set = new HashSet<Node>();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n2.next = n3;
        map.put(n1, n2);
        map.put(n2, n4);
        map.put(n3, n4);
        map.put(n2, n1);

        System.out.println("isLoop[" + isLoop(n1, map, set) + "]"); 

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        Map<Node, Node> map = new HashMap<Node, Node>();

        Set<Node> set = new HashSet<Node>();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n2.next = n3;
        map.put(n1, n2);
        map.put(n2, n4);
        map.put(n3, n4);

        System.out.println("isLoop[" + isLoop(n1, map, set) + "]"); 

        Aron.end();
    }

    static void test3(){
        Aron.beg();
        Map<Node, Node> map = new HashMap<Node, Node>();

        Set<Node> set = new HashSet<Node>();

        Node n1 = new Node(1);
        Node n2 = new Node(2);

        map.put(n1, n2);
        map.put(n2, n1);

        System.out.println("isLoop[" + isLoop(n1, map, set) + "]"); 

        Aron.end();
    }
    static void test4(){
        Aron.beg();
        Map<Node, Node> map = new HashMap<Node, Node>();

        Set<Node> set = new HashSet<Node>();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n2.next = n3;

        map.put(n1, n2);
        map.put(n3, n1);

        System.out.println("isLoop[" + isLoop(n1, map, set) + "]"); 

        Aron.end();
    }

    //[ file=pathloop.html title=""
    //1, 1
    //
    //1, 4 
    //<1, 2->3>
    //<2, 4>
    //<3, 4>
    //<2, 1>
    //              1 
    //         2        3     
    //              4
    static boolean isAPath(Node sNode, Node dNode, Map<Node, Node> map, Set<Node> set){
        if(sNode != null && dNode != null){
            if(set.contains(sNode)){
                return false;
            }else{
                set.add(sNode);
            }
            if(sNode.data == dNode.data)
                return true;
            else{
                Node curr = map.get(sNode);
                while(curr != null){
                    if(curr.data == dNode.data){
                        return true;
                    }else{
                        return isAPath(curr.next, dNode, map, set);
                    }
                }
            }
        }
        return false;
    }

    static boolean isLoop(Node curr, Map<Node, Node> map, Set<Node> set){
        if(curr != null){
            if(set.contains(curr)){
                return true;
            }else{
                set.add(curr);
                Node child = map.get(curr);
                while(child != null){
                    if(isLoop(child, map, set))
                        return true; 
                    child = child.next;
                }
                set.remove(curr);
            }
        }
        return false;
    }
    //]
} 
