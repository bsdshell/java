import java.util.*;
import java.io.*;
import classfile.*;

class GNode{
    int data;
    GNode next;
}

class Graph{
    private Map<GNode, GNode> map = new HashMap<GNode, GNode>();
    private Set<GNode> set = new HashSet<GNode>();
    public Graph(){
    }
    public void addNode(GNode node){
        set.add(node);
    }
    public void deleteNode(GNode node){
        set.remove(node);
        GNode curr = map.get(node);
        if(curr != null){
           map.put(curr, null);
        }
    }
    public void addEdge(GNode fromNode, GNode toNode){
        GNode curr = map.get(fromNode);        
        if(curr != null){
            while(curr.next != null ){
                curr = curr.next;
            }
            curr.next = toNode;
        }
    }

    public void removeEdge(){
    }

    public List<GNode> adjacentNode(GNode node){
        List<GNode> list = new ArrayList<GNode>(); 
        GNode curr = map.get(node);

        while(curr != null){
            list.add(curr);
            curr = curr.next;
        }
        return list; 
    }
}

public class MyGraph{
    public static void main(String[] args) {
    }
    static void test0(){
        Aron.beg();
        Aron.end();
    }
} 
