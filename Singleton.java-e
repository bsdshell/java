import classfile.*;

class Single{
}

class Foo{
    private volatile Single single;
    public synchronized Single getSingle(){
        if(single == null)
            single = new Single();

        return single;
    }

}

public class Singleton{
    public static void main(String[] args){
        Foo f = new Foo();
        f.getSingle();
    }
}
