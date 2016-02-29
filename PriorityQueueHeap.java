import java.util.*;

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
        miniHeap.add(new Contact("Johnny", "U.S", 4));
        miniHeap.add(new Contact("Nathan", "U.S", 1));
        miniHeap.add(new Contact("Micheal", "U.S", 6));

        while(!miniHeap.isEmpty()) {
            System.out.println(miniHeap.remove().toString());
        }
    }
}
