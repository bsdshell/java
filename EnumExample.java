import java.util.*;
import java.io.*;
import classfile.*;

// <enum>enum class example</enum>
// *j_enum_example* *jenum_example*
enum MyType {
    NUM(3),
    ROW(4);
    int value;
    MyType(int value) {
        this.value=value;
    }
    int Value() {
        return this.value;
    }
}

enum DAY{
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

public class EnumExample {
    public static void main(String[] args) {
        test0();
        test1();
    }
    static void test0(){
        Aron.beg();
        Print.pbl("NUM=" + MyType.NUM.Value());
        Print.pbl("NUM=" + MyType.ROW.Value());
        Aron.end();
    }
    static void test1(){
        Aron.beg();

        getDay(DAY.SUNDAY);
        getDay(DAY.MONDAY);

        Aron.end();
    }
    public static void getDay(DAY day){
        if (day == DAY.SUNDAY){
            Print.pbl("sunday");
        }else if( day == DAY.MONDAY){
            Print.pbl("monday");
        }

    }
}
