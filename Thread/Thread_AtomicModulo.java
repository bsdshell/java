import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue; 
import java.util.LinkedList; 
import java.util.concurrent.atomic.AtomicInteger;
import classfile.*;
 

// concurrent, thread, atomic integer, atomicinteger  atomic modulo, 
// mod atomic integer
class AtomicModulo{
    AtomicInteger n = new AtomicInteger(0);
    int len;
    public AtomicModulo(int len){
        this.len = len;
    }
    public int increment(){
        return n.incrementAndGet();
    }
    public int modulo(){
        return n.get() % len;
    }
}



public class Thread_AtomicModulo{
    public static void main(String[] args) {
        Print.pbl("Thread_AtomicModulo.java");
    }
}
