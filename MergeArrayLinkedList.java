import java.util.*;

public class MergeArrayLinkedList 
{
    public static void main(String[] args)
    {
        System.out.println("merge array and merge linkedlist");
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr = null; 
        if(arr1 == null)
            return arr2;
        else if(arr2 == null)
            return arr1;
        else {
            int len1 = arr1.length;
            int len2 = arr2.length;
            arr = new int[len1+len2];
            int inx1 = 0;
            int inx2 = 0;
            int k=0;

            while(inx1 < len1 || inx2 < len2) {
                if(inx1 >= len1) {
                    arr[k] = arr1[inx2];
                    inx2++;
                }
                else if(inx2 >= len2) {
                    arr[k] = arr2[inx1];
                    inx1++;
                }
                else {
                    if(arr1[inx1] < arr2[inx2]) {
                        arr[k] = arr1[inx1];
                        inx1++;
                    }
                    else if(arr1[index] == arr2[inx]){
                        arr[k] = arr1[inx1];
                        k++;
                        inx1++;
                        arr[k] = arr2[inx2];
                        k++;
                        inx2++;
                    }
                    else {
                        arr[k] = arr2[inx2];
                        inx2++;
                    }
                }
                k++;
            }
        }
        return arr;
    }
    public static Node mergeList(Node s1, Node s2)
    {
        Node curr = null;
        Node head = curr;
        while( s1 != null || s2 != null)
        {
            if(s1 == null)
            {
                if(curr == null)
                   head = curr = s2;
                else
                {
                    curr.next = s2;
                    curr = curr.next;
                }
                s2 = s2.next;
            }
            else if(s2 == null)
            {
                if(curr == null)
                    head = curr = s1;
                else
                {
                    curr.next = s1;
                    curr = curr.next;
                }
                s1 = s1.next;
            }
            else
            {
                if(s1.data < s2.data)
                {
                    if(curr == null)
                        head = curr = s1;
                    else
                    {
                        curr.next = s1;
                        curr = curr.next;
                    }
                    s1 = s1.next;
                }
                else
                {
                    if( curr == null)
                        head = curr = s2;
                    else
                    {
                        curr.next = s2;
                        curr = curr.next;
                    }
                    s2 = s2.next;
                }
            }
        }
        return head;
    }
}
