//191
//Intersection

import java.io.*;
import java.util.*;

public class Main
{

    static final double EPS = 1e-9;

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            Point start = new Point(sc.nextInt(), sc.nextInt());
            Point end   = new Point(sc.nextInt(), sc.nextInt());
            Point rectStart = new Point(sc.nextInt(), sc.nextInt());
            Point rectEnd   = new Point(sc.nextInt(), sc.nextInt());

            if(rectEnd.x < rectStart.x)
            {
                Point tmp = rectStart;
                rectStart = rectEnd;
                rectEnd   = tmp;
            }
            else if(rectEnd.x == rectStart.x && rectEnd.y > rectStart.y)
            {
                Point tmp = rectStart;
                rectStart = rectEnd;
                rectEnd   = tmp;
            }

            LineSegment l = new LineSegment(start, end);
            LineSegment rectOne = new LineSegment(rectStart, new Point(rectEnd.x, rectStart.y));
            LineSegment rectTwo = new LineSegment(new Point(rectEnd.x, rectStart.y), rectEnd);
            LineSegment rectThr = new LineSegment(rectEnd, new Point(rectStart.x, rectEnd.y));
            LineSegment rectFor = new LineSegment(new Point(rectStart.x, rectEnd.y), rectStart);

            if(l.intersect(rectOne) || l.intersect(rectTwo) || l.intersect(rectThr) || l.intersect(rectFor) || (start.isBetween(rectStart, rectEnd) && end.isBetween(rectStart, rectEnd)))
                pw.println("T");
            else
                pw.println("F");
        }

        pw.flush();
        pw.close();
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
                y = - (l.a * x + l.c);
            else
                y = - (this.a * x + this.c);
            
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
    }
}