package com.company;

import java.util.*;



public final class Aron {

    //TODO: Need to fix the Node issue
    
    /*
    public static void inorder(Node curr) {
		if(curr != null) {
			inorder(curr.left);
			System.out.print(curr.data + " ");
			inorder(curr.right);
		}
    }

    public static void preorder(Node curr) {
        if(curr != null) {
			System.out.print(curr.data + " ");
			preorder(curr.left);
			preorder(curr.right);
		}
    }

    public static void postorder(Node curr) {
        if(curr != null) {
            postorder(curr.left);
            postorder(curr.right);
            System.out.print("["+curr.data+"]");
        }
    }
    */

    public static List<Integer> allPrimes(int num){
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);

        for(int n=3; n<=num; n++){
            boolean isPrime = true;
            for(int j=0; j<list.size() && isPrime; j++){
                if(list.get(j) < n && n % list.get(j) == 0)
                   isPrime = false; 
            }
            if(isPrime)
                list.add(n);
        }
        return list;
    }

    public static List<Integer> geneNPrime(int numPrime){
        List<Integer> list = new ArrayList<Integer>();
        if(numPrime == 0)
            return list;

        list.add(2);
        int num = 3;
        int count = 1;
        while(count < numPrime ){
            boolean isPrime = true;
            for(int i=0; i<list.size() && isPrime; i++){
                if(num % list.get(i) == 0)
                    isPrime = false;
            }    
            if(isPrime){
                list.add(num);
                count++;
            }
            num++;
        }
        return list;
    }

    
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray2D(int[][] arr) {
        if(arr != null) {
            for(int c=0; c<arr.length; c++) {
                for(int r=0; r<arr[0].length; r++) {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void printList(List<Integer> list) {
        for(Object item : list){
            System.out.println(item);
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {
        if(arr != null) {
            for(int r=0; r<arr.length; r++) {
                System.out.print("["+arr[r]+"]");
            }
            System.out.println();
        }
    }
    public static void printTable(int[][] arr) {
        if(arr != null) {
            for(int c=0; c<arr.length; c++) {
                for(int r=0; r<arr[0].length; r++) {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void reverse(int[] arr) {
        if( arr != null) {
            int len = arr.length;
            int tmp = 0;
            for(int i=0; i<len/2; i++) {
                tmp = arr[i];
                arr[i] = arr[len-1-i];
                arr[len-1-i] = tmp;
            }
        }
    }

        
    public static void writeFile(String fullFile) {
    }

    public static List<String> readFile(String fullFile) {
        return null;
    }
}
