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

import classfile.*;

public class JavaDataStructure {
    public static void main(String[] args) {
        System.out.println("Java Data Structure");

        //[file=data-structure.html title=""
        // map, list, linkedlist, HashMap, HashTable, queue, stack
        //
        int[] array     = {1, 2, 3};
        int[][]  array2 = {{1, 2, 3},
            {4, 5, 6}
        };
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

        // Vector is old data structure in Java, use List instead
        // Vector is not synchronized
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

        // non-blocking, non blocking, nonblocking queue
        // ConcurrentLinkedDeque, concurrent queue concurrentqueue
        Deque<String> concurrentDeque = new ConcurrentLinkedDeque<String>();
        concurrentDeque.addFirst("first");
        concurrentDeque.addLast("last");

        // HashMap can have null for [k, v]
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("cat", 1);
        map.put("dog", 2);

        String key = "cat";
        Integer value = map.get(key);
        if(value != null) {
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

        for(Map.Entry<String, List<String>> entry: mapList.entrySet()) {
            String myKey = entry.getKey();
            List<String> myList = entry.getValue();
            for(String elem: myList) {
                System.out.println("myKey=" + myKey + " list=" + elem);
            }
        }

        if(mapList.containsKey("key")) {
            System.out.println("contains key");
        }

        // HashTable can't have [k, v] to be null
        Map<String, String> table = new Hashtable<String, String>();
        table.put("key", "value");
        table.put("nonull", "nonull");
        for(Map.Entry<String, String> entry : table.entrySet()) {
            System.out.println("[" + entry.getKey() + " " + entry.getValue() + "]");
        }

        List<String> mylist = mapList.get("dog");
        int size = mapList.size();
        if(mapList.containsValue("1")) {
            System.out.println("contains value");
        }

        for(String str : mylist) {
            System.out.println("str=" + str);
        }

        // iterate set, for set, for hashset, loop set,   HashSet
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2));
        Integer item = 1;
        if(set.contains(item))
            System.out.println("set contains element:" + 1);


        for(Integer n : set) {
            System.out.println("n=:" + n);
        }

        set.remove(item);
        int size1 = set.size();
        System.out.println("size1 =" + set.size());

        // iterate set
        for(Integer elem: set) {
            System.out.println("for elem:=" + elem);
        }

        // set to array
        Integer[] array1 = (Integer[]) set.toArray(new Integer[set.size()]);
        for(Integer n: array1) {
            System.out.println("n=:" + n);
        }

        List<Integer> list4 = new ArrayList<>(); 
        Integer[] array4 = (Integer[]) list4.toArray();

        Integer[] arr5 = {1, 2, 3};
        List<Integer> list5 = Arrays.asList(arr5);

        // list to iterator
        List<Integer> list8 = new ArrayList<Integer>();
        list8.add(1);
        list8.add(2);
        Iterator<Integer> ite = list8.iterator();
        while(ite.hasNext()) {
            System.out.println("[" + ite.next() + "]");
        }

        // double ended queue, deck
        Deque<Node> queue1 = new ArrayDeque<Node>();
        queue1.add(new Node(1));
        queue1.add(new Node(2));
        System.out.println("size[" + queue1.size() + "]");
        queue1.poll();
        System.out.println("size[" + queue1.size() + "]");

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();
        List<String> list3 = new Stack<String>();
        List<String> list6 = new Vector<String>();
        Queue<String> queue2 = new LinkedList<String>();
        Queue<String> queue3 = new PriorityQueue<String>();
        Map<String, String> mymap = new HashMap<String, String>();
        Map<String, String> mymap1 = new Hashtable<String, String>();
        Map<String, String> mymap2 = new LinkedHashMap<String, String>();

        //]
    }
}
