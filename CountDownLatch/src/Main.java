import classfile.Aron;
import classfile.Print;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

class IntensiveWork extends Thread implements Runnable{
    private final CountDownLatch latch;
    private final ConcurrentLinkedQueue<Double> queue;
    public IntensiveWork(CountDownLatch latch, ConcurrentLinkedQueue<Double> queue){
        this.latch = latch;
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.add(Aron.calculatePI(10000000));

        Aron.threadInfo(this);
        latch.countDown();
    }
}

class MicroService extends Thread implements Runnable{
    private final CountDownLatch latch;
    public MicroService(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            latch.await();
            //Thread.sleep(1000);
            Aron.calculatePI(10000000);
            Aron.threadInfo(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        test0();
        test1();
    }

    static void test0() {
        Aron.beg();
        Aron.threadInfo();
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i <5 ; i++) {
            Thread t = new Thread(new MicroService(latch));
            t.start();
        }

        latch.countDown();

        Aron.end();
    }

    static void test1() {
        Aron.beg();
        int numThread = 100;
        Aron.threadInfo();
        ConcurrentLinkedQueue<Double> queue = new ConcurrentLinkedQueue();
        CountDownLatch latch = new CountDownLatch(numThread);

        for (int i = 0; i <numThread ; i++) {
            Thread t = new Thread(new IntensiveWork(latch, queue));
            t.start();
        }

        try {
            latch.await();
            Print.pbl("q.size=" + queue.size());
            Print.pbl("do something else");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Aron.end();
    }
}
