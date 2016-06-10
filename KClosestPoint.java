import java.util.*;

// priority heap compareto compareTo heapify heap
//[ file=kclosest.html title=""
// Runtime: (n*logk)
class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}

class Distance implements Comparable<Distance>{
    Point ref;
    Point point;
    public Distance(Point ref, Point point){
        this.ref = ref;
        this.point = point;
    }

    private double norm(){
        double normRef = (point.x - ref.x)*(point.x - ref.x) +  
                         (point.y - ref.y)*(point.y - ref.y);
        return normRef;
    }
    public int compareTo(Distance d){
        if(this.norm() > d.norm())
            return 1;
        else if(this.norm() == d.norm() )
            return 0;
        else 
            return -1;

    }
    public String toString(){
        return "["+ point.x +"]["+ point.y +"]";
    }
}

public class KClosestPoint {
    public static void main(String[] args) {
        test1();
    }
    public static void test1() {

        Point ref = new Point(1, 1);
        Set<Point> set = new HashSet<Point>(); 
        set.add(new Point(20, 20));
        set.add(new Point(2, 2));
        set.add(new Point(10, 10));
        set.add(new Point(2, 4));

        PriorityQueue<Distance> queue = new PriorityQueue<Distance>();
        for(Point pt : set){
            queue.add(new Distance(ref, pt)); 
        }
        int k = 3;
        while(k > 0){
            System.out.println(queue.remove().toString());
            k--;
        }
    }
}
//]
