import java.util.*;

class Node {
    char ch;
    public Node(char ch) {
        this.ch = ch;
    }
}

// get first non duplicated char from a stream
// use HashMap and Double LinkedList
public class FirstOccurCharFromStream {
    public static void main(String[] args) {
        System.out.println("Find the first occurrence character from a stream");
        String str = "kkc";
        char ch = FirstOccurrence(str);
        System.out.println("ch=["+ch+"]");
    }
    public static char FirstOccurrence(String str) {
        char ret = 0;
        List<Node> list = new LinkedList<Node>();
        if(str != null) {
            Map<Integer, Node> map = new HashMap<Integer, Node>();
            int len = str.length();
            for(int i=0; i<len; i++) {
                char ch = str.charAt(i);
                if(map.containsKey((int)ch)) {
                    Node node = map.get((int)ch);
                    if(node != null) {
                        list.remove(node);
                        map.put((int)ch, null);
                    }
                } else {
                    Node node = new Node(ch);
                    map.put((int)ch, node);
                    list.add(node);
                }
            }
        }
        if(list.size() > 0)
            ret = list.get(0).ch;
        return ret;
    }
}
