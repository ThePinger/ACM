import java.util.*;

public class SnowBlower
{
	
	static final double EPS = 1e-9;
	
	public static double square(double x)
	{
		return x * x;
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int i = 0;
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		Point[] points = new Point[n];
		while(n-->0)
		{
			int xx = sc.nextInt();
			int yy = sc.nextInt();
			max = Math.max(max, Math.sqrt(square(x - xx) + square(y - yy)));
			min = Math.min(min, Math.sqrt(square(x - xx) + square(y - yy)));
			points[i++] = new Point(xx, yy);
		}
		
		Line[] lines = new Line[points.length];
		for(i = 0; i < lines.length; i++)
			if(i + 1 == lines.length)
				lines[i] = new Line(points[i], points[0]);
			else lines[i] = new Line(points[i], points[i + 1]);
		
		for(i = 0; i < lines.length; i++)
		{
			Line tmp;
			if(lines[i].a == 0)
				tmp = new Line(1, 0, -x);
			else if(lines[i].b == 0)
				tmp = new Line(0, 1, -y);
			else
			{
				double slope = - 1.0 / - lines[i].a;
				tmp = new Line(- slope, 1, slope * x - y);
			}
				
			Point p = tmp.intersect(lines[i]);
			if(p.isBetween(lines[i].p, lines[i].q))
				min = Math.min(min, Math.sqrt(square(x - p.x) + square(y - p.y)));
		}
		
		System.out.println(Math.PI * square(max) - Math.PI * square(min));
	}

	static class Point
	{
		double x, y;
		
		public Point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}
		
	    public boolean isBetween(Point p, Point q)
	    {
	        return this.x < Math.max(p.x, q.x) + EPS && this.x + EPS > Math.min(p.x, q.x) &&
	                this.y < Math.max(p.y, q.y) + EPS && this.y + EPS > Math.min(p.y, q.y); 
	    }
	}
	
	static class Line
	{
		double a, b, c;
		Point p, q;
		
		public Line(double a, double b, double c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		public Line(Point p, Point q)
		{
	        if(Math.abs(p.x - q.x) < EPS)
	        {
	            this.a = 1.0;
	            this.b = 0.0;
	            this.c = -p.x;
	        }
	        else
	        {
	            this.a = - ((p.y - q.y) / (p.x - q.x));
	            this.b = 1.0;
	            this.c = - (this.a * p.x + p.y); 
	        }
	        this.p = p;
	        this.q = q;
		}
		
		public Point intersect(Line l)
	    {
	        double x = ((this.b * l.c) - (this.c * l.b)) /  ((this.a * l.b) - (this.b * l.a));
	        double y;

	        if(this.b < EPS)
	            y = - (l.a * x + l.c) / l.b;
	        else
	            y = - (this.a * x + this.c) / this.b;
	        
	        return new Point(x, y);
	    }
	}
}