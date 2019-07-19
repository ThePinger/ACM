import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class H {

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++)
		{
			if(i > 1) pw.println();
			
			int nPolygonPoints = sc.nextInt();
			int nCheckPoints = sc.nextInt();
			
			Point[] polygonPoints = new Point[nPolygonPoints];
			Point[] checkPoints = new Point[nCheckPoints];
			
			for(int j = 0; j < nPolygonPoints; j++)
				polygonPoints[j] = new Point(sc.nextInt(), sc.nextInt());
			
			for(int j = 0; j < nCheckPoints; j++)
				checkPoints[j] = new Point(sc.nextInt(), sc.nextInt());
			
			Polygon polygon = Polygon.convexHull(polygonPoints);
			
			pw.println("Case " + i);
			for(int j = 0; j < polygon.points.length; j++)
				pw.println((int) polygon.points[j].x + " " + (int) polygon.points[j].y);
			
			for(int j = 0; j < checkPoints.length; j++)
				pw.println((int) checkPoints[j].x + " " + (int) checkPoints[j].y + " is " + (polygon.insidePolygon(checkPoints[j]) ? "unsafe!" : "safe!"));
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Polygon
	{
	    Point[] points;
	    static final double EPS = 1e-9;

	    public Polygon(Point[] points)
	    {
	        this.points = points;
	    }

	    public double area()
	    {
	        double area = 0.0;
	        for(int i = 0; i < this.points.length - 1; i++)
	            area += (this.points[i].x - this.points[i + 1].x) * (this.points[i].y + this.points[i + 1].y);
	        return Math.abs(area) / 2.0;
	    }

	    public double perimeter()
	    {
	        double perimeter = 0.0;
	        for(int i = 0; i < this.points.length - 1; i++)
	            perimeter += this.points[i].dist(this.points[i + 1]);
	        return perimeter;
	    }

	    public boolean isConvex()
	    {
	        if(points.length < 3) return false;

	        boolean direction = points[points.length - 2].ccw(points[0], points[1]);
	        for(int i = 1; i < points.length - 1; i++)
	            if(points[i - 1].ccw(points[i], points[i + 1]) != direction)
	                return false;
	        return true;
	    }

	    public boolean insidePolygon(Point p)
	    {
	        double angle = 0;
	        for(int i = 0; i < points.length - 1; i++)
	            if(p.ccw(points[i], points[i + 1]))
	                angle += p.angle(points[i], points[i + 1]);
	            else angle -= p.angle(points[i], points[i + 1]);
	        return Math.abs(Math.abs(angle) - (2 * Math.PI)) < EPS;
	    }

	    public static Polygon convexHull(Point[] points)
	    {
	        Arrays.sort(points);
	        Stack<Point> stack = new Stack<>();
	        for(int i = 0; i < points.length; i++)
	        {
	            while(stack.size() > 1)
	            {
	                Point top = stack.pop();
	                Point sec = stack.pop();
	                if(sec.ccw(top, points[i]))
	                {
	                    stack.push(sec);
	                    stack.push(top);
	                    break;
	                }
	                else stack.push(sec);
	            }
	            stack.push(points[i]);
	        }

	        stack.pop();
	        int start = stack.size();
	        for(int i = points.length - 1; i > -1; i--)
	        {
	            while(stack.size() - start > 1)
	            {
	                Point top = stack.pop();
	                Point sec = stack.pop();
	                if(sec.ccw(top, points[i]))
	                {
	                    stack.push(sec);
	                    stack.push(top);
	                    break;
	                }
	                else stack.push(sec);
	            }
	            stack.push(points[i]);
	        }

	        Point[] polygon = new Point[stack.size()];
	        for(int i = polygon.length - 1; i > -1; i--)
	            polygon[i] = stack.pop();
	        
	        return new Polygon(polygon);
	    }
	}
	

	static class Point implements Comparable<Point>
	{
	    double x, y;
	    static final double EPS = 1e-9;

	    public Point(double x, double y)
	    {
	        this.x = x;
	        this.y = y;
	    }

	    public int compareTo(Point p)
	    {
	        if(Math.abs(this.x - p.x) > EPS)
	            return this.x > p.x ? 1 : -1;
	        if(Math.abs(this.y - p.y) > EPS)
	            return this.y > p.y ? 1 : -1;
	        return 0;
	    }

	    private double square(double x)
	    {
	        return x * x;
	    }

	    public double dist(Point p)
	    {
	        return Math.sqrt(square(this.x - p.x) + square(this.y - p.y));
	    }

	    public boolean isBetween(Point p, Point q)
	    {
	        return this.x < Math.max(p.x, q.x) + EPS && this.x + EPS > Math.min(p.x, q.x) &&
	                this.y < Math.max(p.y, q.y) + EPS && this.y + EPS > Math.min(p.y, q.y); 
	    }

	    public boolean ccw(Point a, Point b)
	    {
	        return new Vector(this, a).cross(new Vector(this, b)) > 0;
	    }

	    public double angle(Point a, Point b)
	    {
	        Vector aa = new Vector(this, a);
	        Vector bb = new Vector(this, b);
	        return Math.acos(aa.dot(bb) / (aa.norm() * bb.norm()));
	    }

	    public String toString()
	    {
	        return this.x + " " + this.y;
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
	        return Math.sqrt(square(this.x) + square(this.y));
	    }

	    private double square(double x)
	    {
	        return x * x;
	    }
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}

}
