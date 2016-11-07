import java.util.*;

class Pair{
    public String name;
    public Pair(String name){
        this.name = name;
    }
}

class PairCompare implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        return p1.name.compareToIgnoreCase(p2.name); 
    }
}

public class UniquePair{
    public static void main(String[] args){
        List<Pair> list = new ArrayList<Pair>();
        list.add(new Pair("dog"));
        list.add(new Pair("god"));
        list.add(new Pair("abc"));

        Collections.sort(list, new PairCompare());

        for(Pair p : list){
            System.out.println("[" + p.name + "]");
        }
    }
}
