import classfile.Aron;
import classfile.Print;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;


// pair apache, tuple apache, pair tuple, tuple pair
public class Main {
    public static void main(String[] args) {
        Print.p("Hello World");
        test0();
    }
    static void test0(){
        Aron.beg();
        Pair<String, String> pair = new ImmutablePair<String, String>("dog", "cat");
        String left = pair.getLeft();
        String right = pair.getRight();

        Print.pbl("left=" + left);
        Print.pbl("right=" + right);
        Print.pbl("key=" + pair.getKey());
        Print.pbl("value=" + pair.getValue());

        Aron.end();
    }
}
