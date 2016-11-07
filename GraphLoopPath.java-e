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
        test5();
        test6();
        test7();
        test8();
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

    static void test5(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
        }; 
        int height = arr2d.length;
        int width = arr2d[0].length;
        int source = 0;
        int destination = 3;
        System.out.println("True[" + isPathMatrix(source, destination, arr2d, height, width) + "]"); 

        Aron.end();
    }

    static void test6(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
        }; 
        int height = arr2d.length;
        int width = arr2d[0].length;
        int source = 0;
        int destination = 1;
        System.out.println("True[" + isPathMatrix(source, destination, arr2d, height, width) + "]"); 

        Aron.end();
    }

    static void test7(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
        }; 
        int height = arr2d.length;
        int width = arr2d[0].length;
        int source = 1;
        int destination = 2;
        System.out.println("False[" + isPathMatrix(source, destination, arr2d, height, width) + "]"); 

        Aron.end();
    }

    static void test8(){
        Aron.beg();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        List<Integer> list = new ArrayList<Integer>(); 

        int[][] arr2d = {
            {0, 2, 7, 0},
            {0, 0, 0, 4},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
        }; 
        int height = arr2d.length;
        int width = arr2d[0].length;
        int source = 0;
        int destination = 3;
        int min = Integer.MAX_VALUE;
        System.out.println("min path[" + minPathMatrix(source, destination, list, min, arr2d, height, width) + "]"); 

        Aron.end();
    }
    static void test9(){
        Aron.beg();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        List<Integer> list = new ArrayList<Integer>(); 

        int[][] arr2d = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},

            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
        }; 

        int height = arr2d.length;
        int width = arr2d[0].length;
        int source = 0;
        int destination = 3;
        int min = Integer.MAX_VALUE;
        System.out.println("min path[" + minPathMatrix(source, destination, list, min, arr2d, height, width) + "]"); 

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

    static boolean isPathMatrix(int s, int d, int[][] arr, int height, int width){
        if(arr != null && s < height){
            if(s == d)
                return true;
            else{
                for(int i=0; i< width; i++){
                    if(arr[s][i] == 1){
                        return isPathMatrix(i, d, arr, height, width); 
                    }
                }
            }
        }
        return false;
    }

    static int maxSumBin(Node root, int sum, int max){
        if(root != null){
            if(root.left == null && root.right == null){
                return Math.max(sum + root.data, max);
            }else{
                int lmax = maxSumBin(root.left, sum + root.data);
                int rmax = maxSumBin(root.right, sum + root.data);

                return Math.max(lmin, rmin);
            }
        }
        return 0;
    }

    static int maxSumBin2(Node root){
        if(root != null){
            return Math.max(maxSumBin2(root.left), maxSumBin2(root.right)) + root.data;
        }
        return 0;
    }

    static int minPathMatrix(int s, int d, List<Integer> list, int min, int[][] arr, int height, int width){
        if(arr != null && s < height){
            if(s == d){
                int sum = 0;
                for(Integer n : list)
                    sum += n;
                min = Math.min(sum, min);
            }
            else{
                for(int i=0; i< width; i++){
                    if(arr[s][i] > 0){
                        list.add(arr[s][i]);
                        min = minPathMatrix(i, d, list, min, arr, height, width); 

                        if(list.size() > 0)
                            list.remove(list.size()-1);
                    }

                }
            }
        }
        return min;
    }
    //]
} 
