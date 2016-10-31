import classfile.*;

class StopWatch {
    private long startTime = 0;
    private long stopTime = 0;

    public void StopWatch(){
    }


    public void start() {
        this.startTime = System.currentTimeMillis();
    }


    public void diff() {
        stopTime = System.currentTimeMillis();
        long diffTime = (stopTime - startTime);

        Print.pbl(" startTime= [" + startTime + "] ");
        Print.pbl(" stopTime = [" + stopTime + "] ");
        Print.pbl(" diff     = [" + diffTime + "] ");

    }
}

public class Main{
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        sw.start();
        for(int i=0; i < 100; i++)
            System.out.println(i);
        sw.diff();

    }
}
