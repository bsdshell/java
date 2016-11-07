import java.util.*;

public class IntersectionList {
    public static void main(String[] args) {
        test0();
        test1();
    }

    static  void test0() {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(Arrays.asList(1, 4, 4, 3, 2));
        lists.add(Arrays.asList(1, 3, 1, 9, 4));
        lists.add(Arrays.asList(1, 6, 3, 2, 2));
        List<Integer> retList = intersection(lists);

        for(Integer n : retList) {
            System.out.println(n);
        }
    }

    static  void test1() {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(Arrays.asList(1, 4, 4, 3, 2));
        lists.add(Arrays.asList(6));
        lists.add(Arrays.asList(1, 6, 3, 2, 2));
        List<Integer> retList = intersection(lists);

        for(Integer n : retList) {
            System.out.println(n);
        }
    }

    //[ file=intersectionlist.html title=""
    public static List<Integer> intersection(List<List<Integer>> lists) {
        List<Integer> retList = new ArrayList<Integer>();
        if(lists != null) {
            Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

            for (int i = 0; i < lists.size(); i++) {
                List<Integer> list = lists.get(i);

                for (Integer n : list) {
                    Set<Integer> set = map.get(n);
                    if (set != null) {
                        set.add(i);
                        map.put(n, set);
                    } else {
                        Set<Integer> nSet = new HashSet<Integer>();
                        nSet.add(i);
                        map.put(n, nSet);
                    }
                }
            }
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                Integer n = entry.getKey();
                Set<Integer> set = map.get(n);
                if (set.size() == lists.size())
                    retList.add(n);
            }
        }
        return retList;
    }
    //]
}
