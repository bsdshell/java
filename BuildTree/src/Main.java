
import classfile.Aron;
import classfile.BST;
import classfile.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        test0_BuidTree();
        test0_left();
        test0_right();
    }

    //[ file=buildtree1.html title=""
    public static Node buildTree(List<Integer> oPreOrder, List<Integer> oInorder) {
        if(oPreOrder.size() > 0 || oInorder.size() > 0) {
            Node parent = new Node(oPreOrder.get(0));

            ArrayList<Integer> inLeft = (ArrayList<Integer>) left(oInorder, oPreOrder);
            ArrayList<Integer> inRight = (ArrayList<Integer>) right(oInorder, oPreOrder);

            parent.left = buildTree(oPreOrder.subList(1, inLeft.size() + 1), inLeft);
            parent.right = buildTree(oPreOrder.subList(inLeft.size() + 1, oPreOrder.size()), inRight);
            return parent;
        }
        return null;
    }
    //]

    public  static void test0_BuidTree() {
        Aron.beg();
        List<Integer> preList = new LinkedList<Integer>(Arrays.asList(5, 3, 1, 4, 7, 6, 8));
        List<Integer> inList = new  LinkedList<Integer>(Arrays.asList(1, 3, 4, 5, 6, 7, 8));

        Node root = buildTree(preList, inList);
        Aron.inorder(root);

        Aron.end();
    }

    public  static void test0_left() {
        Aron.beg();
        List<Integer> preList = new LinkedList<Integer>(Arrays.asList(5, 3, 1, 4, 7, 6, 8));
        List<Integer> inList = new  LinkedList<Integer>(Arrays.asList(1, 3, 4, 5, 6, 7, 8));
        List<Integer> list = left(inList, preList);
        Aron.printList(list);

        Aron.end();
    }
    public  static void test0_right() {
        Aron.beg();
        List<Integer> preList = new LinkedList<Integer>(Arrays.asList(5, 3, 1, 4, 7, 6, 8));
        List<Integer> inList = new  LinkedList<Integer>(Arrays.asList(1, 3, 4, 5, 6, 7, 8));
        List<Integer> list = right(inList, preList);
        Aron.printList(list);

        Aron.end();
    }

    public static List<Integer> left(List<Integer> list2, List<Integer> list1){
        List<Integer> list = new ArrayList<Integer>();
        if(list1.size() > 0){
            for(Integer n : list2){
                if(n < list1.get(0))
                    list.add(n);
            }
        }
        return list;
    }

    public static List<Integer> right(List<Integer> list2, List<Integer> list1){
        List<Integer> list = new ArrayList<Integer>();
        if(list1.size() > 0){
            for(Integer n : list2){
                if(n > list1.get(0))
                    list.add(n);
            }
        }
        return list;
    }
}
