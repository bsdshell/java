import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import classfile.*;

class CoinChange{
    Integer curr_total;
    Integer curr_bill;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> list = new ArrayList<Integer>();;
    
    public CoinChange(){
        curr_total = 0;
        curr_bill = 0;
        list.add(25);
        list.add(10);
        list.add(5);
        list.add(1);

        map.put(25, 10);
        map.put(10, 10);
        map.put(5, 10);
        map.put(1, 10);
    }
    public void insertBill(Integer bill){
        if(bill > 25){
            curr_bill = bill;
        }
    }
    public Map<Integer, Integer> withDraw(){
        Map<Integer, Integer> retMap = new HashMap<Integer, Integer>();
                for(Integer coin : list){
                    if(curr_bill > 0){
                    int quotient = curr_bill / coin;
                    if(quotient > 0){
                        Integer numCoins = map.get(coin);
                        if(quotient <= numCoins){
                            curr_bill = curr_bill - quotient*coin;
                            retMap.put(coin, quotient);
                            map.put(coin, numCoins - quotient);
                        }
                    }
            }
        }
        if(curr_bill == 0)
            return retMap;
        else
            return null;
    }
}
public class CoinMachine{
    public static void main(String[] args){
        test0();
        test1();
        test2();
    }
    
    static void test0(){
        Aron.beg();
        CoinChange cc = new CoinChange();
        cc.insertBill(54);
        Map<Integer, Integer> map = cc.withDraw();
        if(map != null){

           for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                System.out.println("[" + entry.getKey() + " " + entry.getValue() + "]");
           }
        }
        Aron.end();
    }

    static void test1(){
        Aron.beg();
        CoinChange cc = new CoinChange();
        cc.insertBill(1);
        Map<Integer, Integer> map = cc.withDraw();
        if(map != null){

           for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                System.out.println("[" + entry.getKey() + " " + entry.getValue() + "]");
           }
        }
        Aron.end();
    }
    static void test2(){
        Aron.beg();
        CoinChange cc = new CoinChange();
        cc.insertBill(103);
        Map<Integer, Integer> map = cc.withDraw();
        if(map != null){

           for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                System.out.println("[" + entry.getKey() + " " + entry.getValue() + "]");
           }
        }
        Aron.end();
    }
}
