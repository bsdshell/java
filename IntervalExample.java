import java.util.*;
import java.io.*;
import classfile.*;

class Entry{
    public String key;
    public Object value;
    public Entry next;
    public Entry(String key, Object value){
        this.key = key;
        this.value = value;
    }
}

class Hash{
    public Entry[] arr;
    public int max;
    public int count = 0;
    public Hash(int max){
        this.max = max;
        arr = new Entry[max];
    }

    public Node get(String key){
        int hash = key.hashCode() % max;
        return (Node)arr[hash].value;
    }
    public void delete(String key){
        if(key != null){
            int hash = key.hashCode() % max;
            Entry curr = arr[hash];
            if(curr != null){
                Entry prev = null;
                while(curr != null){
                    if(curr.key == key)
                        break;
                    else{
                        prev = curr;
                        curr = curr.next;
                    }
                }
                if(prev == null){
                    arr[hash] = curr.next;
                    count--;
                }else{
                    if(curr != null){
                        prev.next = curr.next;
                        count--;
                    }
                }
            }
        }
    }
    public void put(String key, Node node){
        if(count < max){
            int hash = key.hashCode() % max;
            Entry curr = arr[hash];
            if(curr == null){
                arr[hash] = new Entry(key, node);
                count++;
            }
            else{
                Entry prev = null;
                while(curr != null){
                    if(curr.key.equals(key)){
                        // Replace with new value
                        curr.value = node;
                        break;
                    }
                    else{
                        prev = curr;
                        curr = curr.next;
                    }
                }
                // No key is found
                if(curr == null){
                    prev.next = new Entry(key, node);
                    count++;
                }
            }
        }
        
    }
}


class Interval implements Comparable<Interval> {
    int startTime;
    int endTime;
    public Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public int compareTo(Interval v) {
        return startTime - v.startTime;
    }
}


//[ file=inorderiterator.html title=""     
class InorderIterator {
    Node curr;
    Stack<Node> stack = new Stack<Node>();
    public InorderIterator(Node r) {
        this.curr = r;
    }
    public boolean hasNext() {
        if(curr != null || stack.size() > 0)
            return true;
        else
            return false;
    }
    public int next() {
        while(hasNext()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.pop();
                curr = node.right;
                return node.data;
            }
        }
        return -1;
    }
}
//]

public class IntervalExample {
    public static void main(String[] args) {
        test0_InorderIterator();
        test1_InorderIterator();
        test2_InorderIterator();
        test3_InorderIterator();
        test00_hash();
        test01_hash();
        test02_hash();
        test03_hash();
        test04_hash();
        test05_hash();
        test06_hash();
        test07_hash();
        test08_hash();
        test09_hash();
        test010_hash();
        test011_hash();
        test012_hash();
    }
    static void test0_InorderIterator(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
//        bst.insert(5);
//        bst.insert(15);
        InorderIterator ite = new InorderIterator(bst.root);
        while(ite.hasNext()){
            Print.p(ite.next());
        }

        Aron.end();
    }
    static void test1_InorderIterator(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        InorderIterator ite = new InorderIterator(bst.root);
        while(ite.hasNext()){
            Print.p(ite.next());
        }

        Aron.end();
    }
    static void test2_InorderIterator(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        InorderIterator ite = new InorderIterator(bst.root);
        while(ite.hasNext()){
            Print.p(ite.next());
        }

        Aron.end();
    }
    static void test3_InorderIterator(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(1);
        bst.insert(15);
        InorderIterator ite = new InorderIterator(bst.root);
        while(ite.hasNext()){
            Print.p(ite.next());
        }

        Aron.end();
    }
    // 4:17
    static int[] multiple(int[] arr) {
        int[] tmpArray = null;
        if(arr != null) {
            int len = arr.length;
            tmpArray = new int[len];
            for(int i=0; i<len; i++) {
                int m = 1;
                for(int j=0; j<len; j++) {
                    if(i != j) {
                        m *= arr[j];
                    }
                }
                tmpArray[i] = m;
            }
        }
        return tmpArray;
    }
    // prefix and suffix
    // abc = [a, bc], [ab, c], [abc, ""]
    static List<String> prefixSuffix(String str) {
        List<String> list = new ArrayList<String>();
        if(str != null) {
            int len = str.length();
            for(int i=0; i<len; i++) {
                String prefix = str.substring(0, i+1);
                String suffix = str.substring(i+1, len);
                list.add(prefix);
                list.add(suffix);
            }

        }
        return list;
    }
    static void test2() {
        Aron.beg();
        String str = "abc";
        prefixSuffix(str);
        Aron.end();
    }
    //  4:14 - 5:20
    static void inorder(Node r) {
        if(r != null) {
            inorder(r.left);
            Print.p(r.data);
            inorder(r.right);
        }
    }
    static void inorderIterator(Node r) {
        Stack<Node> stack = new Stack<Node>();
        Node curr = r;
        while(curr != null || stack.size() > 0) {
            if(curr != null) {
                stack.push(r);
                curr = r.left;
            } else {
                Node p = stack.pop();
                Print.p(p.data);
                curr = p.right;
            }
        }
    }
    // 5:20 - 5:34
    static void preorder(Node r) {
        if(r != null) {
            Print.p(r.data);
            preorder(r.left);
            preorder(r.right);
        }
    }
    static void preorderIterator(Node r) {
        Stack<Node> stack = new Stack<Node>();
        Node curr = r;
        while(curr != null || stack.size() > 0) {
            if(curr != null) {
                Print.p(curr.data);
                stack.push(curr);
                curr = curr.left;
            } else {
                Node p = stack.pop();
                curr = p.right;
            }
        }
    }
    // 5:35 - 5:42
    static void postorder(Node r) {
        if( r != null) {
            postorder(r.left);
            postorder(r.right);
            Print.p(r.data);
        }
    }
    // use two stacks
    static void postorderIterator(Node r) {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        if(r != null) {
            stack1.push(r);
            while(stack1.size() > 0) {
                Node node = stack1.pop();
                if(node.left != null)
                    stack1.push(node.left);

                if(node.right != null)
                    stack1.push(node.right);

                stack2.push(node);
            }
            while(stack2.size() > 0) {
                Print.p(stack2.pop().data);
            }
        }
    }

    static void test1() {
        Aron.beg();
        int[] arr = {1, 2, 3, 4};
        int[] array = multiple(arr);
        Aron.printArray(arr);
        Aron.printArray(array);

        Aron.end();
    }


    // test1 [1]
    // test2 [1, 2]
    // test3 [2, 1]
    // test4 [3, 1, 2]
    // test5 [2, 3, 1]
    public static int findMaxIndex(int[] arr, int lo, int hi) {
        if(arr != null) {
            if(arr[lo] < arr[hi] || lo == hi)
                return hi;
            else {
                int mid = (lo + hi)/2;
                if(arr[lo] < arr[mid])
                    return findMaxIndex(arr, mid, hi);
                else
                    return findMaxIndex(arr, lo, mid);
            }
        }
        return -1;
    }
    
    static void test00_hash(){
        Aron.beg();
        Hash hash = new Hash(4);
        hash.put("a", new Node(1));
        Node node = (Node)hash.get("a");

        Test.f(node, null);
        Test.f(node, new Node(3));
        Test.t(node, new Node(1));

        Aron.end();
    }
    static void test01_hash(){
        Aron.beg();
        Hash hash = new Hash(4);
        hash.put("a", new Node(1));
        hash.put("a", new Node(2));
        Node node = (Node)hash.get("a");
        Test.t(node, new Node(2));

        Aron.end();
    }
    static void test02_hash(){
        Aron.beg();
        Hash hash = new Hash(4);
        hash.put("a", new Node(1));
        hash.put("b", new Node(2));
        hash.put("c", new Node(3));
        hash.put("e", new Node(4));
        Node node = (Node)hash.get("a");
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                curr = curr.next;
            }
            Aron.line();
        }

        Aron.end();
    }
    static void test03_hash(){
        Aron.beg();
        Hash hash = new Hash(4);
        hash.put("a", new Node(1));
        hash.put("b", new Node(2));
        hash.put("c", new Node(3));
        hash.put("e", new Node(4));
        hash.put("e", new Node(5));
        Node node = (Node)hash.get("a");
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                curr = curr.next;
            }
            Aron.line();
        }

        Aron.end();
    }
    static void test04_hash(){
        Aron.beg();
        Hash hash = new Hash(4);
        hash.put("a", new Node(1));
        hash.delete("a");
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                curr = curr.next;
            }
        }

        Aron.end();
    }
    static void test05_hash(){
        Aron.beg();
        Hash hash = new Hash(4);
        hash.put("a", new Node(1));
        hash.put("b", new Node(2));
        hash.delete("a");
        List<Integer> list = new ArrayList<Integer>(); 
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                list.add(n.data);
                curr = curr.next;
            }
        }
        Test.t(list.size(), 1);
        Test.t(list.get(0), 2);

        Aron.end();
    }
    static void test06_hash(){
        Aron.beg();
        Hash hash = new Hash(2);
        hash.put("a", new Node(1));
        hash.put("bba", new Node(2));
        List<Integer> list = new ArrayList<Integer>(); 
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                list.add(n.data);
                curr = curr.next;
            }
        }
        hash.delete("a");

        list = new ArrayList<Integer>(); 
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                list.add(n.data);
                curr = curr.next;
            }
        }
        Test.t(list.size(), 1);
        Test.t(list.get(0), 2);

        Aron.end();
    }
    static void test07_hash(){
        Aron.beg();
        Hash hash = new Hash(2);
        hash.put("a", new Node(1));
        hash.put("bba", new Node(2));
        List<Integer> list = new ArrayList<Integer>(); 
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                list.add(n.data);
                curr = curr.next;
            }
        }
        hash.delete("bba");

        list = new ArrayList<Integer>(); 
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                list.add(n.data);
                curr = curr.next;
            }
        }
        Test.t(list.size(), 1);
        Test.t(list.get(0), 1);

        Aron.end();
    }
    static void test08_hash(){
        Aron.beg();
        Hash hash = new Hash(2);
        hash.put("a", new Node(1));
        hash.put("bba", new Node(2));
        List<Integer> list = new ArrayList<Integer>(); 
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                list.add(n.data);
                curr = curr.next;
            }
        }
        hash.delete("bba");
        hash.delete("a");

        list = new ArrayList<Integer>(); 
        for(Entry curr : hash.arr){
            while(curr != null){
                Node n = (Node)curr.value;
                Print.pb(n.data);
                list.add(n.data);
                curr = curr.next;
            }
        }
        Test.t(list.size(), 0);

        Aron.end();
    }
    static void test09_hash(){
        Aron.beg();
        Hash hash = new Hash(2);
        hash.put("a", new Node(1));
        hash.put("b", new Node(2));
        Test.t(hash.count, 2);

        Aron.end();
    }
    static void test010_hash(){
        Aron.beg();
        Hash hash = new Hash(2);
        hash.put("a", new Node(1));
        Test.t(hash.count, 1);

        Aron.end();
    }
    static void test011_hash(){
        Aron.beg();
        Hash hash = new Hash(2);
        hash.put("a", new Node(1));
        hash.put("b", new Node(1));
        hash.put("c", new Node(1));
        Test.t(hash.count, 3);

        Aron.end();
    }
    static void test012_hash(){
        Aron.beg();
        Hash hash = new Hash(3);
        hash.put("a", new Node(1));
        hash.put("b", new Node(1));
        hash.put("c", new Node(1));
        Test.t(hash.count, 3);

        Aron.end();
    }
}
