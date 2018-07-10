//109
//SCUD Busters

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        ArrayList<Polygon> polygons = new ArrayList<>();

        while(true)
        {
            int n = sc.nextInt();

            if(n == -1) break;

            Point[] points = new Point[n];
            for(int i = 0; i < n; i++)
                points[i] = new Point(sc.nextInt(), sc.nextInt());

            polygons.add(Polygon.convexHull(points));
        }

        double area = 0.0;
        boolean[] damaged = new boolean[polygons.size()];
        while(sc.hasNext())
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point pt = new Point(x, y);
            for(int i = 0; i < polygons.size(); i++)
                if(!damaged[i] && polygons.get(i).insidePolygon(pt))
                {
                    damaged[i] = true;
                    area += polygons.get(i).area();
                }
        }

        pw.printf("%.2f\n", area);
        pw.flush();
        pw.close();
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
            return new Vector(this, a).cross(new Vector(this, b)) > 0 || Math.abs(new Vector(this, a).cross(new Vector(this, b))) < EPS;
        }

        public double angle(Point a, Point b)
        {
            Vector aa = new Vector(this, a);
            Vector bb = new Vector(this, b);
            return Math.acos(aa.dot(bb) / (aa.norm() * bb.norm()));
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
            if(points.length < 4) return false;

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
}