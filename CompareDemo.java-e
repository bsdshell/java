import java.util.*;

// Comparable
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

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

}


// Comparator
class LexicographicComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}

class AgeComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge() == 0? 0 : p1.getAge() < p2.getAge() ? -1 : 1;
    }
}



public class CompareDemo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Person> listPerson = new ArrayList<Person>(
            Arrays.asList(
                new Person("David", 20),
                new Person("Ann", 19),
                new Person("Michael", 18),
                new Person("Sunny", 6)
            )
        );

        Collections.sort(listPerson, new LexicographicComparator());
        Collections.sort(listPerson, new AgeComparator());
        for(Person p: listPerson) {
            System.out.println(p.getName() + " " + p.getAge());
        }
        List<Contact> listContact = new ArrayList<Contact>(
            Arrays.asList(
                new Contact("David", "Mountain View", 20),
                new Contact("Ann", "Palo Alto", 19),
                new Contact("Michael", "RedWood City", 26)
            )
        );

        System.out.println();
        Collections.sort(listContact);
        for(Contact c: listContact) {
            System.out.println(c.name + " " + c.addr + " " + c.age);
        }
    }
}
