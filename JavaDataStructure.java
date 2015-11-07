import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class JavaDataStructure 
{
    public static void main(String[] args)
    {
        System.out.println("Java Data Structure");

        //[file=data-structure.html title=""
        int[] array = {1, 2, 3}; 
        int[][]  array2 = {{1, 2, 3},
                           {4, 5, 6}};
        // ArrayList
        ArrayList<String> alist = new ArrayList<String>(); 
        alist.add("dog");
        alist.add("cat");

        // ArrayList 2D
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

        // List as Value in HashMap
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

        // HashSet
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2));
        Integer item = 1;
        if(set.contains(item))
            System.out.println("set contains element:" + 1); 

        set.remove(item);
        int size = set.size();
        System.out.println("size =" + set.size()); 

        for(Integer elem: set){
            System.out.println("for elem:=" + elem); 
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println("Iterator elem:=" + iterator.next()); 
        }

        //]
    }
}
