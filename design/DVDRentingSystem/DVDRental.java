import java.lang.Math;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
interface Item 
{
    public String getID();
    public String getName();
    public void setName(String name);
}

class DVD implements Item
{
    String name;
    String genres;
    String date;
    String description;
    String id;
    boolean inStock;
    public DVD(String name, String genres, String date, String description, String id, boolean inStock)
    {
        this.name = name;
        this.genres = genres;
        this.date = date;
        this.description = description;
        this.id = id;
        this.inStock = inStock;
    }
    public void returnDVD(boolean inStock)
    {
    }
    public void rentOut(boolean inStock)
    {
    }
    public String getID()
    {
        return "";
    }
    public String getName()
    {
        return "";
    }
    public void setName(String name)
    {
    }
}

class Node
{
    String id;
    Item item;
}
class ActionDVD implements Item
{
    String name;
    String id;
    public ActionDVD()
    {
        Random random = new Random(100);
        this.id = "" + random.nextInt()%1000;  
    } 
    public ActionDVD(String name, float price)
    {
        Random random = new Random(100);
        this.id = "" + random.nextInt()%1000;  
    }
    public String getID()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}


class DramaDVD implements Item
{
    String name;
    String id;
    public DramaDVD()
    {
        Random random = new Random(100);
        this.id = "" + random.nextInt()%1000;  
    }
    public DramaDVD(String name, float price)
    {
        Random random = new Random(100);
        this.id = "" + random.nextInt()%1000;  
    }
    public String getID()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

}

class ComedyDVD implements Item
{
    String name;
    String genres;
    String id;
    public ComedyDVD()
    {
        Random random = new Random(100);
        this.id = "" + random.nextInt()%1000;  
    }
    public ComedyDVD(String name, String genres, float price)
    {
        Random random = new Random(100);
        this.id = "" + random.nextInt()%1000;  
    }
    public String getID()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}

class RentalSystem2
{
    public RentalSystem2()
    {
    }
}
class RentalSystem
{
    Map<String, List<Item>> map = new HashMap<String, List<Item>>();
    public RentalSystem()
    {
        List<Item> listItem = new LinkedList<Item>();
        map.put("action", listItem);
        map.put("comedy", listItem);
        map.put("drama", listItem);
        //map.put("Action", new );
    }
    public void Refill(String key, Item item)
    {
        List<Item> listItem = map.get(key);
        if(listItem != null)
        {
            listItem.add(item);
        }
    }
    public void returnItem(String key, Item item)
    {
        List<Item> listItem = map.get(key);
        if(listItem != null)
        {
            listItem.add(item);
        }
    }
    public void rentOut(Item item)
    {
        
    }
    public void returnItem(String id)
    {
    }
    public List<Item> search(String name)
    {
        return null;
    }
}

// Operation: search(), topN(), return(), rent(), mostPopular(), outOfStock() newRelease()  addNewDVD()

public class DVDRental 
{
    public static void main(String[] args)
    {
        System.out.println("DVD Rental System");
    }
}
