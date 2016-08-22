import java.util.*;
import java.io.*;
import classfile.*;

class Interval implements Comparable<Interval> {
    int start;
    int end;
    int data;
    public Interval(int start, int end, int data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }
    public int compareTo(Interval e) {
        if(e != null) {
            return start - e.start;
        }
        throw new IllegalArgumentException("e must not be null");
    }
    public String toString() {
        return "[" + start + "][" + end + "][" + data + "]";
    }
}
public class Try102 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(); 
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test7();
    }
    static void test0() {
        Aron.beg();
        Queue<Interval> queue = new PriorityQueue<Interval>();
        Interval ter1 = new Interval(1, 4, 10);
        Interval ter2 = new Interval(4, 4, 2);
        Interval ter3 = new Interval(2, 8, 10);
        queue.add(ter1);
        queue.add(ter2);
        queue.add(ter3);
        while(!queue.isEmpty()) {
            Print.p(queue.poll());
        }
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        int[] arr = {1, 2, 3}; 
        int lo = 0;
        int hi = arr.length - 1;
        Node r = buildTree(arr, lo, hi);

        Aron.inorder(r);
        Aron.line();
        Aron.levelOrder(r);

        Aron.end();
    } 
    static void test2(){
        Aron.beg();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 
        int lo = 0;
        int hi = arr.length - 1;
        Node r = buildTree(arr, lo, hi);

        Aron.inorder(r);
        Aron.line();
        Aron.levelOrder(r);

        Aron.end();
    } 

    static void test3(){
        Aron.beg();
        int[] arr = {1, 2, 3, 4}; 
        int lo = 0;
        int hi = arr.length - 1;
        Node r = buildTree2(arr, lo, hi);

        Aron.inorder(r);
        Aron.line();
        Aron.levelOrder(r);

        Aron.end();

        String str;
        str.getBytes(int srcBegin, int srcEnd, byte dst[], int dstBegin) 
        str.compareTo(String anotherString) 
        str.compareTo(String anotherString) 
        str.getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) 
        str.getBytes(int srcBegin, int srcEnd, byte dst[], int dstBegin) 
        str.indexOf(int ch)
        str.charAt(int index)
        str.concat(String str) 
    } 
    static void test4(){
        Aron.beg();
        int[] arr = {1, 2, 3, 4}; 
        int lo = 0;
        int hi = arr.length - 1;
        Test.t(bs(arr, lo, hi, 2));
        Test.f(bs(arr, lo, hi, 9));
        Test.t(bs(arr, lo, hi, 1));
        Test.f(bs(arr, lo, hi, 0));
        StringBuffer st = new StringBuffer();
        
        

        Aron.end();
    } 

    static void test5(){
        Aron.beg();
        int[] arr = {1}; 
        int lo = 0;
        int hi = arr.length - 1;
        Test.t(bs(arr, lo, hi, 1));
        Test.f(bs(arr, lo, hi, 2));
        Test.f(bs(arr, lo, hi, 9));
        Test.f(bs(arr, lo, hi, 0));

        Aron.end();
    } 

    static void test7(){
        Aron.beg();

        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(18);

        Aron.levelOrder(bst.root);
        Aron.line();
        pretty(bst.root);

        Aron.end();
    } 

    public static Node buildTree(int[] arr, int lo, int hi){
        Node parent = null;
        if(arr != null && lo <= hi){
            int m = (lo  + hi)/2;
            parent = new Node(arr[m]);
            parent.left = buildTree(arr, lo, m-1);
            parent.right = buildTree(arr, m+1, hi);
        }
        return parent;
    }
    public static Node buildTree2(int[] arr, int lo, int hi){
        if(arr != null){
            if(lo == hi)
                return new Node(arr[lo]);
            else {
                int m = (lo  + hi)/2;
                Node l = buildTree2(arr, lo, m);
                Node r = buildTree2(arr, m+1, hi);
                int s = 0;
                if(l != null)
                    s += l.data;
                if(r != null)
                    s += r.data;
                
                Node parent = new Node(s);
                parent.left = l;
                parent.right = r;
                return parent;
            }
        }else
            return null;
    }
    public static boolean bs(int[] arr, int lo, int hi, int k){
        if(arr != null && lo <= hi){
            int m = (lo + hi)/2;
            if(k < arr[m]){
                return bs(arr, lo, m-1, k);
            }else if(k > arr[m]){
                return bs(arr, m+1, hi, k);
            }else
                return true;
        }
        return false;
    }
    public static void pretty(Node r){
        int level = Aron.level(r);
        List<Queue<Node>> list = Aron.prettyLevel(r, level);
        for(Queue<Node> q: list){
            Print.pb(q.size());
        } 
    }
}
