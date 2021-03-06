import classfile.Aron;
import classfile.Print;

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

        // list filter  *j_filter* *java_filter* *list_filter*
        List<Integer> leftList = listInt.stream().filter(x-> x < 3).collect(Collectors.toList());
        List<Integer> rightList = listInt.stream().filter(x-> x > 3).collect(Collectors.toList());

        Aron.printList(leftList);
        Aron.printList(rightList);

        // list forEach  *j_foreach*
        leftList.forEach(System.out::println);
        leftList.forEach(x->System.out.println(x));

        // HashMap filter  *j_hashmap_filter*
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 4);
        map.put(2, 5);
        map.put(3, 7);

        Map<Integer, Integer> newMap1 = map.entrySet().parallelStream()
                                                    .filter(e->e.getValue() > 1)
                                                    .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));

        Aron.printMap(newMap1);

        Map<Integer, Integer> newMap2 = map.entrySet().stream()
                                                     .filter(e->e.getValue() > 1)
                                                     .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
        Aron.printMap(newMap2);

        // list of String to list of Integer
        String[] arrStr = {"0", "1", "2", "3"};
        List<String> list1 = Arrays.asList(arrStr);
        List<Integer> strIntList = list1.stream().map(Integer::parseInt).collect(Collectors.toList());
        Aron.printList(strIntList);

        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        boolean ret = list2.stream().anyMatch(s -> s.intValue() > 2);

        List<String> animalList = Arrays.asList("dog", "cow", "cat", "squirrel");
        Aron.printList(animalList);
        String max11 = animalList.stream().max(Comparator.comparing(String::valueOf)).get();
        Print.pbl(max11 + " maxlen=" + max11.length());

        List<String> list4 = Arrays.asList("G","B","F","E");
		String max4 = list4.stream().max(Comparator.comparing(String::valueOf)).get();
		System.out.println("Max:"+ max4);


//        Stream.of("a","bb","aaa","z","b").max(Comparator.comparing(s->s.length()))

        //]

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        List<Integer> list = Arrays.asList(1, 2, 3); 
        List<Integer> left = list.stream().filter(x -> x < 2).collect(Collectors.toList());
        List<Integer> right = list.stream().filter(x -> x > 2).collect(Collectors.toList());
        
        Aron.printList(left);
        Aron.printList(right);

        Aron.end();
    }
}

