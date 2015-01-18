import java.util.*;

class AddRemoveRandomClass
{
   Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
   int lastIndex;
   int max;
   int[] array;
   public AddRemoveRandomClass(int max)
   {
       lastIndex= 0;
       this.max = max;
       array = new int[max];
   }
   public void add(Integer num)
   {
       if(!map.containsKey(num) && lastIndex < max)
       {
           map.put(num, lastIndex);
           array[lastIndex] = num;
           lastIndex++;
       }
   }
   public void remove(int num)
   {
       Integer value = null;
       if((value = map.get(num)) != null)
       {
            map.remove(num);
            map.put(array[lastIndex], value);
            array[value] = array[lastIndex];
            lastIndex--;
       }
   } 
   public Integer getRandom()
   {
       if(lastIndex > 0)
       {
           Random ran = new Random(); 
           int index = ran.nextInt(lastIndex);
           return array[index];
       }
       else 
       {
           return -1;
       }
   }
   public void print()
   {
       for(int i=0; i < lastIndex; i++)
       {
            System.out.println("["+i+"]=["+array[i]+"]");
       }
   }
}

public class AddRemoveRandom 
{
				public static void main(String[] args)
				{
                    AddRemoveRandomClass stuff = new AddRemoveRandomClass(100);
                    stuff.add(20);
                    stuff.add(40);
                    stuff.add(2);
                    stuff.add(0);
                    stuff.print();
                    stuff.remove(40);
                    stuff.remove(2);
                    stuff.remove(0);
                    stuff.remove(20);
                    System.out.println();
                    stuff.print();
                    System.out.println("random=" + stuff.getRandom());
				}
}
