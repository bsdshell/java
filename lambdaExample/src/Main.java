import classfile.Aron;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();
        Random ran = new Random();
        double total = 0.0;
        final int max = 1000000;
        Double[] arr = new Double[max];
        for(int i=0; i<max; i++) {
            double num = ran.nextDouble();
            arr[i] = num;
        }
        List<Double> list = Arrays.asList(arr);
        
        //[ file=lambda.html title=""
        // list sum
        Optional<Double> sum = list.stream().reduce(Double::sum);
        sum.ifPresent(System.out::println);

        Integer[] array = {1, 2, 3, 4};
        List<Integer> listInt = Arrays.asList(array);

        // list filter
        List<Integer> leftList = listInt.stream().filter(x-> x < 3).collect(Collectors.toList());
        List<Integer> rightList = listInt.stream().filter(x-> x > 3).collect(Collectors.toList());
        Aron.printList(leftList);
        Aron.printList(rightList);

        // list forEach
        leftList.forEach(System.out::println);

        // HashMap filter
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 4);
        map.put(2, 5);
        map.put(3, 7);

//      Map<Integer, Integer> newMap = map.entrySet().parallelStream()
//                                                    .filter(e->e.getValue() > 1)
//                                                    .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
        Map<Integer, Integer> newMap = map.entrySet().stream()
                                                     .filter(e->e.getValue() > 1)
                                                     .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
        Aron.printMap(newMap);

        //]

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        Aron.end();
    }
}

