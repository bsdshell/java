import java.io.*;
import java.lang.String;
import java.util.*;

class Item{
    String name;
    double price;
}
                     
class VendorMachine {
    Map<String, List<Item>> map = new Hashmap<String, List<Item>>();
    double total;
    public VendorMachine(){
    }

    public Item buy(double cash, String key){
        List<Item> list = map.get(key);
        if(list != null){
            if(cash > list[list.size()-1].price){
                Item item = list.remove();
                if(list.isEmpty())
                    map.remove(key);
            }
        }
        return item;
    }
    public double change(double cash, Item item){
        if(item != null){
            return cash - item.price;
        }
        return 0;
    }
}


public class Hello
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        test99();
    }
    public static void test99() {
        Queue<String> q1 = new LinkedList<String>();
        Queue<String> q2 = new LinkedList<String>();
        q1 = q2;
    }

}
