import java.lang.Integer;
import java.lang.String;
import java.util.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Stream;

public class JavaDataStructure 
{
    public static void main(String[] args)
    {
        System.out.println("Java Data Structure");

        //[file=data-structure.html title=""
        int[] array     = {1, 2, 3};
        int[][]  array2 = {{1, 2, 3},
                           {4, 5, 6}};
        // ArrayList
        ArrayList<String> alist = new ArrayList<String>(); 
        alist.add("dog");
        alist.add("cat");

        // list of list, ArrayList 2D
        ArrayList<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
        list2d.add(alist);

        // List
        List<String> list = new ArrayList<String>();
        list.add("eloberate");
        list.add("continue");
        list.add("continuous");

        // Vector
        Vector<String> vector = new Vector<String>();
        vector.add("jobs");
        vector.add("career");
        vector.add("motivation");
        vector.add("ambition");

        // LinkedList
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);

        // Queue
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.remove();
        if(queue.peek() == 2)
            System.out.println("top element is :" + 2);  

        // LinkedBlockingDeque
        // blocking, use lock in the implementation
        Deque<String> blockingDeque = new LinkedBlockingDeque<String>();
        blockingDeque.addFirst("first");
        blockingDeque.addLast("last");

        // ConcurrentLinkedDeque
        // non-blocking
        Deque<String> concurrentDeque = new ConcurrentLinkedDeque<String>();
        concurrentDeque.addFirst("first");
        concurrentDeque.addLast("last");

        // HashMap
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("cat", 1);
        map.put("dog", 2);

        String key = "cat";
        Integer value = map.get(key);
        if(value != null){
            value = map.get(key);
            System.out.println("key=" + key + " value=" + value); 
        }

        if(map.containsKey(key))
            System.out.println("map contains key=" + key); 

        // java, init list, java initialize list, List as Value in HashMap
        Map<String, List<String>> mapList = new HashMap<String, List<String>>();
        mapList.put("1", Arrays.asList("dog", "cat", "cow"));
        mapList.put("2", Arrays.asList("C++", "Java", "Haskell"));
        mapList.put("3", Arrays.asList("Scala", "Python", "Ruby"));

        for(Map.Entry<String, List<String>> entry: mapList.entrySet()){
            String myKey = entry.getKey();
            List<String> myList = entry.getValue();
            for(String elem: myList){
                System.out.println("myKey=" + myKey + " list=" + elem); 
            }
        }

        if(mapList.containsKey("key")){
            System.out.println("contains key");
        }

        // hashtable
        Map<String, String> table = new Hashtable<String, String>();
        table.put("key", "value");
        table.put("nonull", "nonull");
        for(Map.Entry<String, String> entry : table.entrySet()){
            System.out.println("[" + entry.getKey() + " " + entry.getValue() + "]");
        }

        List<String> list = mapList.get("key");
        int size = mapList.size();
        if(mapList.containsValue("1")){
            System.out.println("contains value");
        }

        List<String> mylist =  mapList.values();
        for(String str:mylist){
            System.out.println("str=" + str);
        }


        // iterate set, for set, for hashset, loop set,   HashSet
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2));
        Integer item = 1;
        if(set.contains(item))
            System.out.println("set contains element:" + 1);


        for(Integer n : set){
            System.out.println("n=:" + n);
        }

        set.remove(item);
        int size = set.size();
        System.out.println("size =" + set.size()); 

        // iterate set
        for(Integer elem: set){
            System.out.println("for elem:=" + elem); 
        }

        // set to array
        Integer[] array = (Integer[]) set.toArray(new Integer[set.size()]);
        for(Integer n: array){
            System.out.println("n=:" + n);
        }

        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println("Iterator elem:=" + iterator.next()); 
        }

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();
        List<String> list3 = new Stack<String>();
        List<String> list4 = new Vector<String>();
        Queue<String> queue = new ArrayList<String>();
        Queue<String> queue2 = new PriorityQueue<String>();
        //]
    }
}
