import classfile.Aron;
import classfile.Print;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// wait and notify example
public class Main{
    private final static Logger LOGGER = Aron.logInit(Main.class.getName(), "/Users/cat/myfile/github/java/text/Logging3.txt");
    private static SimpleFormatter formatterTxt = new SimpleFormatter();

    public static void main(String[] args){
        ThreadB b = new ThreadB(LOGGER);
        b.start();

        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");

                LOGGER.info("logging it");
                LOGGER.info(Aron.threadInfo(b));

                b.wait();
                Print.pbl("get notified");
                Aron.threadInfo(b);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread{
    int total;
    Logger LOGGER;
    public ThreadB(){}
    public ThreadB(Logger LOGGER){
        this.LOGGER = LOGGER;
    }
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<5; i++){
//                Aron.threadInfo(this);
                LOGGER.info(Aron.threadInfo(this));
                try{
                    Thread.sleep(1000);  // sleep two seconds
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                total += i;
            }
            notify();
//            Aron.threadInfo(this);
        }
    }
}
