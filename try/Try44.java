
import classfile.Aron;
import classfile.BST;
import classfile.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 4:00
public class Try44{
    public static void main(String[] args) {
        test0_subtract();
        test1_subtract();
        test2_subtract();
        test3_subtract();
    }

    static void test0() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7);
        Aron.inorder(b1.root);

        Aron.end();
    }

    public static Node buildTree(List<Integer> oPreOrder, List<Integer> oInorder) {
        if(oPreOrder.size() > 0 || oInorder.size() > 0) {
            Node parent = new Node(oPreOrder.get(0));
            ArrayList<Integer> inLeft = new ArrayList<Integer>();
            ArrayList<Integer> inRight = new ArrayList<Integer>();

            ArrayList<Integer> preLeft = new ArrayList<Integer>();
            ArrayList<Integer> preRight = new ArrayList<Integer>();

            split(inLeft, inRight, preLeft, preRight, oPreOrder, oInorder);

            int subLen = oInorder.size() - inRight.size();
            parent.left = buildTree(preLeft, oInorder.subList(0, subLen));
            parent.right = buildTree(preRight, oInorder.subList(subLen + 1, oInorder.size()));
            return parent;
        }
        return null;
    }
    public static void split(ArrayList<Integer> inLeft, ArrayList<Integer> inRight, ArrayList<Integer> preLeft, ArrayList<Integer> preRight, List<Integer> preorder, List<Integer> inorder) {
        if(preorder.size() > 0) {
            for(Integer n : inorder) {
                if(n < preorder.get(0)) {
                    inLeft.add(n);
                } else if(n > preorder.get(0)) {
                    inRight.add(n);
                }
            }
            preorder.remove(0);
            subtract(preorder, inLeft, preRight);
            subtract(preorder, inRight, preLeft);
        }
    }
    public static void subtract(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        if(list1.size() > 0) {

            for(Integer n : list1) {
                boolean found = false;
                for(Integer n1: list2) {
                    if(n.equals(n1)) {
                        found = true;
                        break;
                    }
                }
                if(!found)
                    list3.add(n);
            }
        }
    }
    public  static void test0_subtract() {
        Aron.beg();
        List<Integer> preList = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> inList = new LinkedList<Integer>(Arrays.asList(2));
        ArrayList<Integer> list = new ArrayList<Integer>();
        subtract(preList, inList, list);
        Aron.printList(list);

        Aron.end();
    }
    public  static void test1_subtract() {
        Aron.beg();
        List<Integer> preList = new LinkedList<Integer>(Arrays.asList(5, 3, 1, 4, 7, 6, 8));
        List<Integer> inList = new LinkedList<Integer>(Arrays.asList(1, 3, 4));
        ArrayList<Integer> list = new ArrayList<Integer>();
        subtract(preList, inList, list);
        Aron.printList(list);

        Aron.end();
    }

    public  static void test2_subtract() {
        Aron.beg();
        List<Integer> preList = new LinkedList<Integer>(Arrays.asList(5, 3, 1, 4, 7, 6, 8));
        List<Integer> inList = new LinkedList<Integer>(Arrays.asList(7, 6, 8));
        ArrayList<Integer> list = new ArrayList<Integer>();
        subtract(preList, inList, list);
        Aron.printList(list);

        Aron.end();
    }
    public  static void test3_subtract() {
        Aron.beg();
        List<Integer> preList = new LinkedList<Integer>(Arrays.asList(5, 3, 1, 4, 7, 6, 8));
        List<Integer> inList = new  LinkedList<Integer>(Arrays.asList(1, 3, 4, 5, 6, 7, 8));
        Node root = buildTree(preList, inList);
        Aron.inorder(root);

        Aron.end();
    }

}
