import java.util.*;
import java.io.*;
import classfile.*;

//[ file=hashmap1.html title=""
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
//]


public class MyHash{
    public static void main(String[] args) {
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
