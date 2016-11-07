import classfile.*;

class RunnableThread implements Runnable {
    String name;
    public void run() {
        Foo f = Foo.getInstance();
        Print.pb(f.getNum());
    }
}

final class Foo{
    private static volatile Foo single;
    private static int num = 0;
    private Foo(){
    }

    public synchronized static Foo getInstance(){
        if(single == null){
            single = new Foo();
            Print.pb("an Object is created first time");
        }
        else{
            Print.p("an Object has been created");
        }
        return single;
    }
    public int getNum(){
        return num;
    }
}
   
public class Singleton{
    public static void main(String[] args){
        test1();
    }
    
    static void test1(){
        Aron.beg();
        for(int i=0; i<10; i++) {
            Thread t1 = new Thread(new RunnableThread());
            t1.start();
        }
        Aron.end();
    }
}
