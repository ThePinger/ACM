//11626
//ConvexHull

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            Point[] points = new Point[n];
            int i = 0;
            while(n-->0)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                char typ = sc.next().charAt(0);
                if(typ == 'Y')
                    points[i++] = new Point(a, b);
            }

            Polygon p = Polygon.convexHull(Arrays.copyOf(points, i));
            pw.println(i);
            for(int j = 0; j < i; j++)
                pw.println(p.points[j].x + " " + p.points[j].y);
        }

        pw.flush();
        pw.close();
    }

    static class Point implements Comparable<Point>
    {
        int x, y;
        static final double EPS = 1e-9;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p)
        {
            if(Math.abs(this.x - p.x) > 0)
                return this.x > p.x ? 1 : -1;
            if(Math.abs(this.y - p.y) > 0)
                return this.y > p.y ? 1 : -1;
            return 0;
        }

        public boolean ccw(Point a, Point b)
        {
            return new Vector(this, a).cross(new Vector(this, b)) > 0 || Math.abs(new Vector(this, a).cross(new Vector(this, b))) < EPS;
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
            return Math.sqrt(sq(this.x) + sq(this.y));
        }

        private double sq(double x)
        {
            return x * x;
        }
    }

    static class Polygon
    {
        Point[] points;
        static final double EPS = 1e-9;

        public Polygon(Point[] points)
        {
            this.points = points;
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
