import java.io.*;
import classfile.*;

class MultiplyLongInt
{
	public static void main(String args[])
	{
        test1();
        test2();
        test3();
        test4();
        test5();
        test1_multiplynew();
        test2_multiplynew();
        test3_multiplynew();

	}
    //[file=multiplynew.html title=""     
    public static int[] multiplynew(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = len1 + len2;
        int[][] arr = new int[len1][len1+len2];

        for(int i=len2-1; i >= 0; i--){
            int carry = 0;
            int j=0;
            for(j=len1-1; j >= 0; j--){
                int shiftLeft = i + 1;
                arr[i][j + shiftLeft] = (arr1[j]*arr2[i] + carry) %10;
                carry = (arr1[j]*arr2[i]+carry) / 10;
            }
            arr[i][(i+1)+j] = carry;
        }

        int[] total = new int[len];
        int carry = 0;
        for(int j=len-1; j >= 0; j--){
            int s=0;
            for(int i=0; i < len2; i++){
                s += arr[i][j];
            }
            total[j] = (s + carry) % 10;
            carry = (s + carry)/10;
        }
        return total;
    }
    //]

    //[file=multiplylong.html title="multiply long integer"
    public static int[] multiply(int[] arr1, int[] arr2) {
        if(arr1 != null && arr2 != null && arr1.length > 0 && arr2.length > 0) {
            int len1 = arr1.length;
            int len2 = arr2.length;
            Reverse(arr1);        
            Reverse(arr2);
            int[][] array = new int[len1][len1+len2];

            for(int i=0; i<len1; i++) {
                int carrying = 0;
                int j=0;
                for(j=0; j<len2; j++) {
                    int t = arr1[i]*arr2[j] + carrying;
                    array[i][j + i] = t % 10;
                    carrying = t / 10;
                }
                array[i][j + i] = carrying;
            }

            int[] total = new int[len1+len2];
            int carrying = 0;
            for(int i=0; i<len1 + len2; i++) {
                int s = 0;
                for(int j=0; j < len1; j++) {
                    s += array[j][i];
                }
                total[i] = (s + carrying) % 10; 
                carrying = (s + carrying) / 10;
            }
            Reverse(total);
            return total;
        }
        return null;
    }

    public static void Reverse(int[] A) {
        if(A != null) {
            int len = A.length;
            for(int i=0; i<len/2; i++) {
                int tmp = A[i];
                A[i] = A[len-1-i];
                A[len-1-i] = tmp;
            }
        }
    }
    //]
    

    static void test1(){
        Aron.beg();
		int[] A = {9, 9, 9};
		int[] B = {9, 0, 9};
		int[] S = multiply(A, B);
        Aron.printArray(S);
        Aron.end();
    }
    static void test2(){
        Aron.beg();
		int[] A = {9, 9, 9};
		int[] B = {9, 9, 9};
		int[] S = multiply(A, B);
        Aron.printArray(S);

        Aron.end();
    }
    static void test3(){
        Aron.beg();
		int[] A = {9};
		int[] B = {9, 9, 9};
		int[] S = multiply(A, B);
        Aron.printArray(S);

        Aron.end();
    } 

    static void test4(){
        Aron.beg();
		int[] A = {9};
		int[] B = {1};
		int[] S = multiply(A, B);
        Aron.printArray(S);

        Aron.end();
    } 

    static void test5(){
        Aron.beg();
		int[] A = {9, 9};
		int[] B = {9};
		int[] S = multiply(A, B);
        Aron.printArray(S);
        Aron.end();
    } 

    static void test1_multiplynew(){
        Aron.beg();
        int[] A = {9, 9};
		int[] B = {9};
		int[] S = multiplynew(A, B);
        Aron.printArray(S);

        Aron.end();
    }

    static void test2_multiplynew(){
        Aron.beg();
		int[] A = {1};
		int[] B = {9};
	    int[] S = multiplynew(A, B);
        Aron.printArray(S);

        Aron.end();
    }

    static void test3_multiplynew(){
        Aron.beg();
		int[] A = {0};
		int[] B = {0};
	    int[] S = multiplynew(A, B);
        Aron.printArray(S);
        Print.p(0*0);

        Aron.end();
    }
    static void test4_multiplynew(){
        Aron.beg();
		int[] A = {9};
		int[] B = {9};
		int[] S = multiplynew(A, B);
        Aron.printArray(S);

        Aron.end();
    }
}
