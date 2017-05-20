import classfile.Print;

/**
 * Created by cat on 5/20/17.
 */
public class MyClass2 {
    int num;
    public int print(Object o){
        Print.pbl(o);
        return 1;
    }
    public void setNum(int num){
        this.num = num;
    }
}
