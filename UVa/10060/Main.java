//10060
//A hole to catch a man

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            double total = 0.0;
            while(n-->0)
            {
                double thickness = sc.nextDouble();
                ArrayList<Point> points = new ArrayList<>();
                while(true)
                {
                    double x = sc.nextDouble();
                    double y = sc.nextDouble();
                    if(!points.isEmpty())
                    {
                        Point tmp = points.get(0);
                        if(tmp.x == x && tmp.y == y)
                        {
                            points.add(tmp);
                            break;
                        }
                    }
                    points.add(new Point(x, y));
                }

                Polygon p = new Polygon(points);
                total += p.area() * thickness;
            }

            double r = sc.nextDouble();
            double t = sc.nextDouble();
            double area = Math.PI * r * r * t;
            pw.println(((int) (total / area)));
        }

        pw.flush();
        pw.close();
    }

    static class Polygon
    {
        ArrayList<Point> points;

        public Polygon(ArrayList<Point> points)
        {
            this.points = points;
        }

        public double area()
        {
            double area = 0.0;
            for(int i = 0; i < this.points.size() - 1; i++)
                area += (this.points.get(i).x - this.points.get(i + 1).x) * (this.points.get(i).y + this.points.get(i + 1).y);
            return Math.abs(area) / 2.0;
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

        public double cross(Vector v)
        {
            return (this.x * v.y) - (this.y * v.x);
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

        public double square(double x)
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
            return new Vector(this, a).cross(new Vector(a, b)) > 0;
        }

        public String toString()
        {
            return this.x + " " + this.y;
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
