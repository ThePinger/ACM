//478
//Points in Figures: Rectangles, Circles, Triangles

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        ArrayList<Figure> figures = new ArrayList<>();
        while(true)
        {
            char typ = sc.next().charAt(0);

            if(typ == '*') break;

            if(typ == 'r')
            {
                Point[] pts = new Point[5];
                pts[0] = pts[4] = new Point(sc.nextDouble(), sc.nextDouble());
                pts[2] = new Point(sc.nextDouble(), sc.nextDouble());
                pts[1] = new Point(pts[0].x, pts[2].y);
                pts[3] = new Point(pts[2].x, pts[0].y);

                figures.add(new Figure(new Polygon(pts)));
            }
            else if(typ == 't')
            {
                Point[] pts = new Point[3];
                pts[0] = new Point(sc.nextDouble(), sc.nextDouble());
                pts[1] = new Point(sc.nextDouble(), sc.nextDouble());
                pts[2] = new Point(sc.nextDouble(), sc.nextDouble());

                figures.add(new Figure(Polygon.convexHull(pts)));
            }
            else
                figures.add(new Figure(new Circle(new Point(sc.nextDouble(), sc.nextDouble()), sc.nextDouble())));
        }

        int t = 1;
        while(true)
        {
            double a = sc.nextDouble();
            double b = sc.nextDouble();

            if(a == 9999.9 && b == 9999.9) break;

            Point p = new Point(a, b);
            boolean flag = false;
            for(int i = 0; i < figures.size(); i++)
            {
                if(figures.get(i).type && figures.get(i).polygon.insidePolygon(p))
                {
                    pw.println("Point " + t + " is contained in figure " + (i + 1));
                    flag = true;
                }
                else if(!figures.get(i).type && figures.get(i).circle.insideCircle(p))
                {
                    pw.println("Point " + t + " is contained in figure " + (i + 1));     
                    flag = true;  
                }             
            }

            if(!flag) pw.println("Point " + t + " is not contained in any figure");
            t++;
        }

        pw.flush();
        pw.close();
    }

    static class Figure
    {
        boolean type;
        Circle circle;
        Polygon polygon;

        public Figure(Polygon polygon)
        {
            this.polygon = polygon;
            type = true;
        }

        public Figure(Circle circle)
        {
            this.circle = circle;
            type = false;
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

    static class Circle
    {
        double radius;
        Point center;
        static final double EPS = 1e-9;

        public Circle(Point center, double radius)
        {
            this.radius = radius;
            this.center = center;
        }

        public boolean insideCircle(Point p)
        {
            return square(center.x - p.x) + square(center.y - p.y) < square(radius);
        }

        private double square(double x)
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