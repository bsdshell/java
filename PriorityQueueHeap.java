import java.util.*;

// priority heap compareto compareTo heapify heap
//[ file=priorityheap.html title=""
class Contact implements Comparable<Contact> {
    String name;
    String addr;
    int    age;
    public Contact(String name, String addr, int age) {
        this.name = name;
        this.addr = addr;
        this.age = age;
    }

    //Minimum heap
    public int compareTo(Contact c) {
        return this.age - c.age;
        //Maximum heap
        //return -(this.age - c.age);
    }

    public String toString() {
        return "["+name+"]["+addr+"]["+age+"]";
    }
}

public class PriorityQueueHeap {
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {
        System.out.println("Minimum/Maximum Heap PriorityQueue");
        PriorityQueue<Contact> miniHeap = new PriorityQueue<Contact>();
        miniHeap.add(new Contact("David", "U.S", 3));
        miniHeap.add(new Contact("John", "U.S", 4));
        miniHeap.add(new Contact("Johnny", "U.S", 2));
        miniHeap.add(new Contact("Nathan", "U.S", 1));

        int k = 3;
        while(k > 0) {
            System.out.println(miniHeap.remove().toString());
            k--;
        }
    }
}
//]
