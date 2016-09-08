import java.util.*;
import java.io.*;
import classfile.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 

//[ file=eightqueen.html title=""
class Queen{
    List<Move> list = new ArrayList<>();

    class Move{
        public int c;
        public int r;
        public Move(int c, int r){
            this.c = c;
            this.r = r;
        }
    }

    // int c = 0;
    public void queenSolver(int c){
        final int len = 8;
        if(c == len){
            for(Move m:list){
                Print.p("[" + m.c + "," + m.r + "]");
            }
            Ut.l();
        }else{
            for(int r=0; r<len; r++){
                if(isValidMove(c, r)){
                    list.add(new Move(c, r));
                    queenSolver(c+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    public boolean isValidMove(int c, int r){
        for(Move m : list){
            if(m.r == r || Math.abs(m.c - c) == Math.abs(m.r - r))
                return false;
        }
        return true;
    }
}
//]

public class EightQueen{
    public static void main(String[] args) {
        test0();
        test1();
    }
    
    static void test0(){
        Aron.beg();
        Queen q = new Queen();
        int c = 0;
        q.queenSolver(c);
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        Aron.end();
    }
}

