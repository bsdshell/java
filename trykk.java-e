public static class Point implements Comparable<Point> {
    public double x;
    public double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getDist(){
    	return x*x+y*y;
    }

	public int compareTo(Point o) {
		int c = Double.compare(getDist(), o.getDist());
		if(c == 0){
			c = Double.compare(x, o.x);
			if(c == 0){
				c = Double.compare(y, o.y);
			}
		}
		
		return c;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

public static Point[] kCloest(final Point points[], final int k) {
    //max heap
    final PriorityQueue<Point> kQueue = new PriorityQueue<>(k, Collections.reverseOrder());

    for (int i = 0; i < points.length; i++) {
        if (kQueue.size() < k) {
        	kQueue.add(points[i]);
        } else if (points[i].getDist() < kQueue.peek().getDist()) {
            kQueue.remove();
            kQueue.add(points[i]);
        }
    }

    return kQueue.toArray(new Point[k]);
}
