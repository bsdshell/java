import java.util.concurrent.*;
import java.util.*;

public class CallableDemo{
    public CallableDemo(){
        System.out.println("Create callable Demo");
        ExecutorService service = Executors.newFixedThreadPool(10);

        List<MyCallable> futureList = new ArrayList<MyCallable>();
        for ( int i=0; i<12; i++){
            MyCallable myCallable = new MyCallable((long)i);
            futureList.add(myCallable);
        }

        System.out.println("Start");
        try{
            List<Future<Long>> futures = service.invokeAll(futureList);  
            for(Future<Long> future : futures){
                try{
                    System.out.println("future.isDone = " + future.isDone());
                    //System.out.println("future: call ="+future.get());
                }
                catch(Exception err1){
                    err1.printStackTrace();
                }
            }
        }catch(Exception err){
            err.printStackTrace();
        }
        service.shutdown();
    }

    class MyCallable implements Callable<Long>{
        Long id = 0L;
        public MyCallable(Long val){
            this.id = val;
        }

        // similar to run() method in Runnable
        // override call()
        public Long call(){
            int a=4, b = 0;
            System.out.println("a/b:"+(a/b));
            return id;
        }
    }
    public static void main(String args[]){
        CallableDemo demo = new CallableDemo();
    }
}
