import java.util.*;
import java.io.*;
import classfile.*;

// 4:22, 5:41, 6:19
// Least Recent Used Cache
//

//[ file=simpleLRU.html title=""
class LNode {
    String key;
    Object data;
    public LNode(String key, Object data) {
        this.data = data;
        this.key = key;
    }
}

class LRU {
    final int max;
    int count;
    LinkedList<LNode> list = new LinkedList<LNode>();
    Map<String, LNode> map = new HashMap<String, LNode>();

    public LRU(int max) {
        this.max = max;
        this.count = 0;
    }
    public void insert(String key, LNode node) {
        LNode value = map.get(key);
        if(value != null) {
            list.remove(value);
            list.addLast(node);
            map.put(key, node);
        } else {
            if(count < max) {
                map.put(key, node);
                list.addLast(node);
                count++;
            }else{
                LNode reNode = list.removeFirst();
                list.addLast(node);
                map.remove(reNode.key);
                map.put(key, node);
            }
        }
    }
    public void remove(String key) {
        if(count > 0 && map.containsKey(key)){
            LNode node = map.get(key);
            if(node != null){
                list.remove(node);
                map.remove(key);
                count--;
            }
        }
    }

    public void print(){
        for(Map.Entry<String, LNode> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " , " + entry.getValue().data + "]");
        } 
        Aron.line();

        for(LNode node : list){
            System.out.println("["+ node.data + "]");
        }
    }
}
//]

public class SimpleLRU{
    public static void main(String[] args) {
        test0();
        test1();
    }
    static void test0() {
        Aron.beg();
        LRU lru = new LRU(3);
        String k1 = "dog";
        String k2 = "cat";
        String k3 = "cow";
        LNode node1 = new LNode(k1, "Excuse, Technical, Technician, Torch");
        LNode node2 = new LNode(k2, "This is typical excuse for being late");
        LNode node3 = new LNode(k3, "Please elaborate your question, please clarify your intention, The wound will heal up");

        lru.insert(k1, node1);
        lru.insert(k2, node2);
        lru.insert(k3, node3);

        lru.print();

        Aron.end();
    }
    static void test1() {
        Aron.beg();
        LRU lru = new LRU(3);
        String k1 = "dog";
        String k2 = "cat";
        String k3 = "cow";
        String k4 = "pig";

        LNode node1 = new LNode(k1, "First, Excuse, Technical, Technician, Torch");
        LNode node2 = new LNode(k2, "Second, This is typical excuse for being late");
        LNode node3 = new LNode(k3, "Third, Please elaborate your question, please clarify your intention, The wound will heal up");
        LNode node4 = new LNode(k4, "Fourth, Injuring 100 people and wounding 20 people in the bombing near the market in Thailand");

        lru.insert(k1, node1);
        lru.insert(k2, node2);
        lru.insert(k3, node3);
        lru.insert(k4, node4);

        lru.print();

        Aron.end();
    }
}

