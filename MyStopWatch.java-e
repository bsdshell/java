import classfile.*;

class StopWatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    public void StopWatch(){
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }
    

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
        long elapsed = ((System.currentTimeMillis() - startTime) / 1000000);
        Print.pbl(elapsed);
        Print.pbl("startTime=" + startTime);
        Print.pbl("stopTime=" + stopTime);
        Print.pbl("diff=" + (startTime - stopTime));
    }

    //elaspsed time in milliseconds
    public long getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = (System.currentTimeMillis() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }

    public void diff() {
        Print.pbl(getElapsedTime());
    }

    //elaspsed time in seconds
    public long getElapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        } else {
            elapsed = ((stopTime - startTime) / 1000);
        }
        return elapsed;
    }
}

public class MyStopWatch {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        for(int i=0; i < 100; i++)
            System.out.println(i);
        sw.stop();
        Print.pbl(sw.getElapsedTimeSecs());
    }
}

