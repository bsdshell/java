import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;
interface IItem 
{
    String getName(); 
    float getPrice();
}

class Coca implements IItem 
{
    float price; 
    String name;
    public Coca(String name, float price)
    {
        this.name = name;
        this.price = price;
    }
    public float getPrice()
    {
        return price;
    }
    public String getName()
    {
        return this.name;
    }
}
class Peps implements IItem
{
  float price;
  String name;
  public Peps(String name, float price)
  {
      this.name = name;
      this.price = price;
  }
  public float getPrice()
  {
      return price;
  }
  public String getName()
  {
      return this.name;
  }
}

class VendingMachineSystem
{
    float balance;
    Map<String, LinkedList<IItem>> map = new HashMap<String, LinkedList<IItem>>();
    public VendingMachineSystem()
    {
        this.balance = 0;
    }
    public float getBalance()
    {
        return this.balance;
    }
    public void refill(String key, IItem item)
    {
        Queue<IItem> queue = map.containsKey(key);
        if(queue != null)
        {
            queue.enque(item);
        }
        else
        {
            Queue<IItem> tmpQueue = new LinkedList<IItem>();
            tmpQueue.addLast(item);
            map.put(key,tmpQueue); 
        }
    }
    //key is number string which maps to specific item
    //count is the number of item that user want to order
    //inputTotal is total fund that user inserts to the vendingmachine
    boolean isEnoughtItem(String key, int count) 
    {
        boolean retValue = false;
        Queue<IItem> queue = map.containsKey(key);
        if(queue != null)
        {
            if(count < queue.size())
            {
                retValue = true;
            }
        }
        return retValue;
    }
    int chance(String key, int count, float inputTotal)
    {
        int retValue = -1;
        Queue<IItem> queue = map.containsKey(key);
        if(isEnoughtItem(key, count)) 
        {
            int num = 1;
            int sum = 0;
            while(queue.peek() != null && num <= count)
            {
                IItem item = queue.dequeue();
                sum += item.price()*(num);
                num++;
            }
            if(sum <= inputTotal)
            {
                retValue = (inputTotal - sum);
                balance += sum;
            }
        }
        return retValue;
    }
    boolean widthDraw(String key, int count, float inputTotal) 
    {
        return chance(key, count, inputTotal) >= 0;
    }
}


public class VendingMachine 
{
    public static void main(String[] args)
    {
        System.out.println("VendingMachine");
    }
    
    //Coca, Peps, 7Up
    //Dictionary<List<Object>>
       
}
