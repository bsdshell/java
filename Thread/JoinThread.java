import classfile.*;

//[ file=jointhread.html title=""
class TestJoin extends Thread{
    public void run(){
        for(int i=0; i<5; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[id=" + getId() + " name=" + getName() + "]["+i+"]");
        }
    }
}

public class JoinThread {
    public static void main(String[] args) {
        test1();
    }
    static void test1(){
        Aron.beg();
        TestJoin t1 = new TestJoin();
        TestJoin t2 = new TestJoin();
        TestJoin t3 = new TestJoin();

        t1.start();
        try{
            t1.join(1500);
        }catch(Exception e){
        }

        t2.start();
        t3.start();

        Aron.end();
    }
}
//]
