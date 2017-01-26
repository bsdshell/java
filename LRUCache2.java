import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;


// gx /Library/WebServer/Documents/zsurface/image/lrucache.png
// LRU cache, least recent used cache, lru cache new
// In memory catche.
// e.g. memcache 
//
//
// insert - if the key is in the map, remove the node from the list
//          update the map with new node, append the node to the list
// 
//          if the list is full, remove the oldest node, and append
//          the new node to the list, and update the map with new node
//  
//          update the map with new key/node
//          update the map with new key/node
// 
class RNode{
    String key;
    String data;
    public RNode(String key, String data){
        this.key = key;
        this.data = data;
    }
}
class LRUCacheNew {
    int max;
    int count;
    List<RNode> list = new ArrayList<RNode>(); 
    Map<String, RNode> map = new HashMap<String, RNode>(); 
    public LRUCacheNew(int max){
        this.max = max;
        count = 0;
    }
    public  RNode get(String key){
        RNode node = map.get(key);
        if(node != null){
            list.remove(node);
            list.add(node);
        }
        return node;
    }

    // gx /Library/WebServer/Documents/zsurface/image/lrucache.png
    public void insert(String key, RNode node){
        RNode vnode = map.get(key);
        if(vnode != null){
            // vnode is in the list
            map.remove(vnode.key);
            list.remove(vnode);
            map.put(key, node);
            list.add(node);
        }else{
            // vnode is not in the list
            if(count < max){
                map.put(key, node);
                list.add(node);
                count++;
            }else{
                if(max > 0){
                    list.remove(0);
                    map.put(key, node);
                    list.add(node);
                }
            }
        }
    }
    public void print(){
        for(RNode node : list){
            Print.pb(node.key + " " + node.data);
        }
    }
}

public class LRUCache2{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        LRUCacheNew lru = new LRUCacheNew(3);
        RNode n1 = new RNode("k1", "data1");
        RNode n2 = new RNode("k2", "data2");
        RNode n3 = new RNode("k3", "data3");
        RNode n4 = new RNode("k4", "data4");

        lru.insert(n1.key, n1);
        lru.insert(n2.key, n2);
        lru.insert(n3.key, n3);

        lru.print();

        Ut.l();
        lru.insert(n4.key, n4);

        lru.print();
        
        Aron.end();
    }
    public static void test1(){
        Aron.beg();

        LRUCacheNew lru = new LRUCacheNew(3);
        RNode n1 = new RNode("k1", "data1");
        RNode n2 = new RNode("k2", "data2");
        RNode n3 = new RNode("k3", "data3");
        RNode n4 = new RNode("k2", "data4");
        RNode n5 = new RNode("k1", "data5");

        lru.insert(n1.key, n1);
        lru.insert(n2.key, n2);
        lru.insert(n3.key, n3);

        
        lru.print();

        Ut.l();
        lru.insert(n4.key, n4);
        Print.pb("insert k2  data4");
        lru.print();
        Ut.l();
        lru.insert(n5.key, n5);
        Print.pb("insert k1  data5");
        lru.print();

        Aron.end();
    }
} 

