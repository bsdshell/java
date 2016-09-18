import java.util.*;
import java.io.*;
import classfile.*;

public class TryExcel {
    public static void main(String[] args) {
        test0();
        test_excelHeaderToNumber();
        test_atoInt();
        test0_decimalToBinary();
    }
    public static void test0() {
        Aron.beg();
        int num = Aron.excelHeaderToNumber("A");
        Test.t(num == 1);

        num = Aron.excelHeaderToNumber("Z");
        Test.t(num == 26);

        num = Aron.excelHeaderToNumber("AZ");
        Test.t(num == 52);
        Aron.end();
    }
    public static void test_excelHeaderToNumber() {
        Aron.beg();
        String str = Aron.numberToExcelHeader(1);
        Test.t(str, "A");

        str = Aron.numberToExcelHeader(26);
        Test.t(str, "Z");


        str = Aron.numberToExcelHeader(27);
        Test.t(str, "AA");

        str = Aron.numberToExcelHeader(52);
        Test.t(str, "AZ");

        str = Aron.numberToExcelHeader(53);
        Test.t(str, "BA");
        Aron.end();
    }

    
    static void test_atoInt(){
        Aron.beg();
        int num = Aron.atoInt("0");
        Test.t(num, 0);
        
        num = Aron.atoInt("1");
        Test.t(num, 1);
        
        num = Aron.atoInt("9");
        Test.t(num, 9);

        num = Aron.atoInt("101");
        Test.t(num, 101);


        Aron.end();
    } 


    static void test0_decimalToBinary(){
        Aron.beg();
        String str = Aron.decimalToBinary(0);
        Test.t(str, "0");

        str = Aron.decimalToBinary(1);
        Test.t(str, "1");

        str = Aron.decimalToBinary(10);
        Test.t(str, "1010");

        Aron.end();
    }


}

