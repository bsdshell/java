/**
 * Created by cat on 5/20/17.
 */
public class MyMain {
    MyClass c;
    MyClass2 c2;
    public MyMain(MyClass c, MyClass2 c2){
        this.c = c;
        this.c2 = c2;
    }
    public void run(){
        c2.setNum(22);
        c.display(c2);
    }
}
