public class Point implements Comparable<Point>{
	int x,y;
	
    public Point(int x, int y) 
    {
		this.x = x;
		this.y = y;
	}
	
    public String toString() 
    {
		return "(" + x + "," + y + ")";
	}

	@Override
    public int compareTo(Point o) 
    {
		if (this.x < o.x) return -1;
		else if (this.x > o.x) return 1;
		else return this.y - o.y;		
	}
}