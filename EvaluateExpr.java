import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class EvaluateExpr{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
    }
    public static void test0(){
        Aron.beg();
        String str = "( 1 + 2 )";
        int sum = evaluate(str);
        Test.t(sum == 3);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        String str = "( 1 - 2 )";
        int sum = evaluate(str);
        Test.t(sum == -1);
        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        String str = "( 1 - ( 2 - 4 ) )";
        int sum = evaluate(str);
        Test.t(sum == 3);
        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        String str = "( 1 - ( ( 2 - 4 ) + 3 ) )";
        int sum = evaluate(str);
        Test.t(sum == 0);
        Aron.end();
    }
    public static void test10(){
        Aron.beg();
        String str = "12";
        boolean isNum = str.matches("[0-9]+");
        Print.pbl(isNum);

        str = "a12";
        isNum = str.matches("[0-9]+");
        Print.pbl(isNum);
        Aron.end();
    }
    public static int evaluate(String str){
        int sum = 0;
        Stack<Integer> operandStack = new Stack<Integer>(); 
        Stack<String> operatorStack = new Stack<String>(); 

        String[] arr = str.split("\\s+");
        for(String s : arr){
            if(isNumeric(s)){
                operandStack.push(Integer.parseInt(s));
            }else if(s.equals("+") || s.equals("-")){
                operatorStack.push(s);
            }else if(s.equals(")")){
                    if(operatorStack.size() > 0 && operandStack.size() > 1){
                        String op = operatorStack.pop();
                        int right = operandStack.pop();
                        int left  = operandStack.pop();
                        if(op.equals("+")){
                            operandStack.push(left + right);
                        }else if(op.equals("-")){
                            operandStack.push(left - right);
                        }
                        else
                            Print.pbl("Expression Error");
                    }
            }
                
        }
        Aron.printArray(arr);
        return operandStack.peek();
    }
    public static boolean isNumeric(String str){
        return str.matches("[0-9]+");
    }
} 

