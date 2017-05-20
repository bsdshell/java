import classfile.Print;

/**
 * Created by cat on 4/29/17.
 */
public class MyClass {
    int print(){
        return 1;
    }

    public <T> T show(T t){
        Print.pbl(t);
        return t;
    }
    public MyClass2 display(MyClass2 c2){
        c2.print(3);
        c2.setNum(10);
        return c2;
    }
}
