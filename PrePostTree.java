import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;

import classfile.*;

           
//         4
//      2     5
//    1   3
//    pre [4 2 1 3 5]
//    post[1 3 2 5 4]
//
//[test0]
//--------------------------------------------------------------------------
//[4][2][1][3][5]
//--------------------------------------------------------------------------
//[1][3][2][5][4]
//--------------------------------------------------------------------------
//----------------------------------------------------------------------------------------
public class PrePostTree{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();
        List<Integer> preList = Arrays.asList(4, 2, 1, 3, 5);
        List<Integer> postList = Arrays.asList(1, 3, 2, 5, 4);

        Node r = buildTreePrePost(preList, postList);
        Aron.preorder(r);
        Ut.l();
        Aron.postorder(r);
        Ut.l();
        Aron.end();
    }

//pre order [r][left][right]
//post order[left][right][r]

// [1, 2, 3, 4]
    public static Node buildTreePrePost(List<Integer> preList, List<Integer> postList) {
        Node parent = null;
        if(preList != null || postList != null) {
            if(preList.size() == postList.size() && preList.size() > 0) {
                parent = new Node(preList.get(0));
                List<Integer> subPreList = preList.subList(1, preList.size());
                List<Integer> subPostList = postList.subList(0, postList.size()-1);
                if(subPreList.size() == subPostList.size() && subPreList.size() > 0) {
                    Integer subRoot = subPreList.get(0);
                    List<Integer> leftPostList  = postLeft(subPostList, subRoot);
                    List<Integer> rightPostList = postRight(subPostList, subRoot);
                    List<Integer> leftPreList   = preLeft(subPreList, rightPostList);
                    List<Integer> rightPreList  = preRight(subPreList, leftPostList);
                    parent.left = buildTreePrePost(leftPreList, leftPostList);
                    parent.right = buildTreePrePost(rightPostList, rightPostList);
                }
            }
        }
        return parent;
    }
    public static List<Integer> preRight(List<Integer> list, List<Integer> leftList) {
        List<Integer> rightList = new ArrayList<Integer>(); 
        Set<Integer> set = new HashSet<Integer>(leftList);
        for(Integer n: list){
            if(!set.contains(n)){
                rightList.add(n);
            }
        }
        return rightList;
    }
    public static List<Integer> preLeft(List<Integer> list, List<Integer> rightList) {
        List<Integer> leftList = new ArrayList<Integer>(); 
        Set<Integer> set = new HashSet<Integer>(rightList);
        for(Integer n: list){
            if(!set.contains(n)){
                leftList.add(n);
            }
        }
        return leftList;
    }

    public static List<Integer> postRight(List<Integer> list, Integer r) {
        List<Integer> rightList = new ArrayList<Integer>(); 
        boolean equal = false;
        for(Integer n : list) {
            if(equal)
                rightList.add(n);

            if(n.intValue() == r.intValue())
                equal = true;
        }
        return rightList;
    }
    public static List<Integer> postLeft(List<Integer> list, Integer r) {
        List<Integer> leftList = new ArrayList<Integer>(); 
        for(Integer n : list) {
            if(n.intValue() != r.intValue())
                leftList.add(n);
        }
        return leftList;
    }
}


