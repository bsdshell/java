import classfile.Print;
import classfile.FileWatcher;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


// http://www.rgagnon.com/javadetails/java-0490.html
public class Main {
    public static void main(String args[]) {
        // monitor a single file
        TimerTask task = new FileWatcher( new File("/Users/cat/myfile/github/java/text/file.txt") ) {
            protected void onChange( File file ) {
                // here we code the action on a change
                System.out.println( "File="+ file.getAbsolutePath() +" have change !" );
            }
        };

        Timer timer = new Timer();
        // repeat the check every second
        timer.schedule( task , new Date(), 2000 );
    }
}
