//498A
//CrazyTown

import java.util.*;

public class CrazyTown
{

    static final double EPS = 1e-9;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Point home = new Point(sc.nextInt(), sc.nextInt());
        Point univ = new Point(sc.nextInt(), sc.nextInt());
        
        int n = sc.nextInt();
        int count = 0;
        LineSegment ls = new LineSegment(home, univ);
        while(n-->0)
        {
            Line l = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt());
            if(ls.intersect(l))
                count++;
        }

        System.out.println(count);
    }

    static class Point implements Comparable<Point>
    {
        double x, y;

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

        public String toString()
        {
            return this.x + " " + this.y;
        }
    }

    static class Line
    {
        double a, b, c;

        public Line(double a, double b, double c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Line(Point p1, Point p2)
        {
            if(Math.abs(p1.x - p2.x) < EPS)
            {
                this.a = 1.0;
                this.b = 0.0;
                this.c = -p1.x;
            }
            else
            {
                this.a = - ((p1.y - p2.y) / (p1.x - p2.x));
                this.b = 1.0;
                this.c = - (this.a * p1.x + p1.y); 
            }
        }

        public boolean isParallel(Line l)
        {
            return Math.abs(this.a - l.a) < EPS && Math.abs(this.b - l.b) < EPS;
        }

        public boolean isSame(Line l)
        {
            return this.isParallel(l) && Math.abs(this.c - l.c) < EPS;
        }

        public double getX(double y)
        {
            return - (this.b * y + this.c) / this.a;
        }

        public Point intersect(Line l)
        {
            if(isParallel(l)) return null;

            double x = ((this.b * l.c) - (this.c * l.b)) /  ((this.a * l.b) - (this.b * l.a));
            double y;

            if(this.b < EPS)
                y = - (l.a * x + l.c) / l.b;
            else
                y = - (this.a * x + this.c) / this.b;
            
            return new Point(x, y);
        }
    }

    static class LineSegment
    {
        Point p, q;

        public LineSegment(Point p, Point q)
        {
            this.p = p;
            this.q = q;
        }

        public boolean intersect(LineSegment ls)
        {
            Line l1 = new Line(this.p, this.q);
            Line l2 = new Line(ls.p, ls.q);

            if(l1.isParallel(l2))
            {
                if(l1.isSame(l2))
                    return this.p.isBetween(ls.p, ls.q)   || this.q.isBetween(ls.p, ls.q) ||
                           ls.p.isBetween(this.p, this.q) || ls.q.isBetween(this.p, this.q);
                return false;
            }

            Point intersect = l1.intersect(l2);
            return intersect.isBetween(this.p, this.q) && intersect.isBetween(ls.p, ls.q);
        }

        public boolean intersect(Line l)
        {
            Line l1 = new Line(this.p, this.q);
            Point intersect = l1.intersect(l);
            if(intersect == null) return false;
            return intersect.isBetween(this.p, this.q);
        }
    }
}