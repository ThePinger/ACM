import java.util.*;

public class Turn
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Point a = new Point(sc.nextInt(), sc.nextInt());
		Point b = new Point(sc.nextInt(), sc.nextInt());
		Point c = new Point(sc.nextInt(), sc.nextInt());
		
		double angle = a.angle(b, c) * 180 / Math.PI;
		if(angle == 90.0)
		{
			if(a.ccw(b, c))
				System.out.println("LEFT");
			else
				System.out.println("RIGHT");
		}
		else System.out.println("TOWARDS");
	}
	
	static class Point
	{
		int x, y;
		
		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public double angle(Point a, Point b)
		{
			Vector aa = new Vector(this, a);
			Vector bb = new Vector(a, b);
			return Math.acos(aa.dot(bb) / (aa.norm() * bb.norm()));
		}
		
	    public boolean ccw(Point a, Point b)
	    {
	        return new Vector(this, a).cross(new Vector(this, b)) > 0;
	    }
	}
	
	static class Vector
	{
		double x, y;
		
		public Vector(Point a, Point b)
		{
			this.x = a.x - b.x;
			this.y = a.y - b.y;
		}
		
		public double dot(Vector v)
		{
			return (this.x * v.x) + (this.y * v.y);
		}
		
		public double cross(Vector v)
	    {
	        return (this.x * v.y) - (this.y * v.x);
	    }
		
		public double norm()
		{
			return Math.sqrt((x * x) + (y * y));
		}
	}
}