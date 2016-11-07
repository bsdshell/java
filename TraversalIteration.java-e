import java.io.*;
import java.lang.String;
import java.util.*;

import classfile.*;

//[ file=inorderiterator.html title=""     
class InorderIterator {
    Node curr;
    Stack<Node> stack = new Stack<Node>();
    public InorderIterator(Node r) {
        this.curr = r;
    }
    public boolean hasNext() {
        if(curr != null || stack.size() > 0)
            return true;
        else
            return false;
    }
    public int next() {
        while(hasNext()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.pop();
                curr = node.right;
                return node.data;
            }
        }
        return -1;
    }
}
//]

class TraversalIteration{

    public static Node prev = null;
    public static void main(String args[]) {
        BST b1 = new BST();
        b1.insert(14);
        b1.insert(15);
        b1.insert(12);
        b1.insert(17);
        b1.insert(19);

        b1.insert(130);
        b1.insert(16);
        b1.insert(10);

        PostOrder(b1.getRoot());
        System.out.println();
        Node cloneRoot = CloneTree(b1.getRoot());

        PostorderDFS(cloneRoot);
        PostorderTwoStacks(cloneRoot);
    }
    //in order traversal using iteration
    public static void InorderIteration(Node r) {
        Stack<Node> st = new Stack<Node>();
        Node curr = r;
        if( curr != null) {
            while(!st.empty() || curr != null) {
                if(curr != null) {
                    st.push(curr);
                    curr = curr.left;
                } else {
                    Node no = st.pop();
                    System.out.println("[" + no.data + "]");
                    curr = no.right;
                }
            }
        }
    }

    
    //[file=postorder1.html title=""
    //postorder recursion
    public static void PostOrder(Node r) {
        if( r != null) {
            PostOrder(r.left);
            PostOrder(r.right);
            System.out.println("[" + r.data + "]");
        }
    }
    //]

    //[ file=postorderite.html title=""
    // postorder with iteration
    public static void postIteration(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while(curr != null || stack.isEmpty() == false) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.peek();
                if(node.isVisited) {
                    System.out.println("[" + node.data + "]");
                    stack.pop();
                } else {
                    node.isVisited = true;
                    curr = node.right;
                }
            }
        }
    }
    //]

    //[ file=twostackite.html title="" 
    //Postorder with two stacks
    public static void PostorderTwoStacks(Node curr) {
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();
        if(curr != null) {
            st1.push(curr);
            while(!st1.empty()) {
                Node node = st1.pop();
                st2.push(node);
                if(node.left != null)
                    st1.push(node.left);
                if(node.right != null)
                    st1.push(node.right);
            }
            while(!st2.empty()) {
                Node node = st2.pop();
                System.out.println("[" + node.data + "]");
            }
        }
    }
    //]

    // clone a binary tree
    // Use postorder traversal
    public static Node CloneTree(Node root) {
        if(root != null) {
            Node left = CloneTree(root.left);
            Node right = CloneTree(root.right);
            Node parent = new Node(root.data);
            parent.left = left;
            parent.right = right;
            return parent;
        }
        return null;
    }

    public static void PostorderDFS(Node r) {
        if( r != null) {
            Stack<Node> st= new Stack<Node>();
            Map<Node, List<Node>> map = new HashMap<Node, List<Node>>();
            st.push(r);
            while(!st.empty()) {
                Node top = st.peek();
                if((top.left == null && top.right == null) || top.isVisited) {
                    Node node = st.pop();
                    System.out.println("[" + node.data + "]");

                } else if((top.left != null || top.right != null) && !top.isVisited) {
                    List<Node> list = new LinkedList<Node>();
                    if(!map.containsKey(top)) {
                        if(top.left != null)
                            list.add(top.left);
                        if(top.right != null)
                            list.add(top.right);
                        map.put(top, list);
                    } else {
                        list = map.get(top);
                    }
                    if(list.size() > 0) {
                        Node node = list.get(0);
                        st.push(node);
                        list.remove(0);
                        if(list.size() == 0) {
                            top.isVisited = true;
                            map.remove(top);
                        }
                    }
                }
            }
        }
    }
    //[ file=preinorder.html title=""
    public static void preorder(Node root) {
        if(root != null) {
            System.out.println("[" + root.data + "]");
            inorder(root.left);
            inorder(root.right);
        }
    }
    public static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.println("[" + root.data + "]");
            inorder(root.right);
        }
    }

    public static void preorderIteration(Node r) {
        Stack<Node> st = new Stack<Node>();
        Node curr = r;
        if( curr != null) {
            while(curr != null || !st.empty()) {
                if(curr != null) {
                    System.out.println("["+curr.data+"]");
                    st.push(curr);
                    curr = curr.left;
                } else {
                    Node node = st.pop();
                    curr = node.right;
                }
            }
        }
        curr = r;
    }

    public static void inorderIteration(Node r) {
        Stack<Node> st = new Stack<Node>();
        Node curr = r;
        if( curr != null) {
            while(curr != null || !st.empty()) {
                if(curr != null) {
                    st.push(curr);
                    curr = curr.left;
                } else {
                    Node node = st.pop();
                    System.out.println("["+curr.data+"]");
                    curr = node.right;
                }
            }
        }
        curr = r;
    }
    //]

}
