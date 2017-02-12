import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.locks.ReentrantLock;

// reentrantlock example, ReentrantLock example,
// what are the difference between ReentrantLock and synchronized
public class ReentrantLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        final ReentrantLock lock = new ReentrantLock();

        class Worker implements Runnable {
            private String name;
            Worker(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                lock.lock();
                try {
                    if (lock.isHeldByCurrentThread())
                        System.out.printf("Thread %s has entered its critical section.%n", name);
                    System.out.printf("Thread %s is performing work for 2 seconds.%n", name);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                    System.out.printf("Thread %s has finished working.%n", name);
                }
                finally {
                    lock.unlock();
                }
            }
        }

        
        for(int i=0; i<10; i++){
            executor.execute(new Worker(i + ""));
        } 

        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        executor.shutdownNow();
    }
}

