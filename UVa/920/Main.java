//920
//Sunny Mountains

import java.io.*;
import java.text.DecimalFormat;
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
            int n = sc.nextInt();
            Point[] arr = new Point[n];
            for(int i = 0; i < n; i++)
                arr[i] = new Point(sc.nextInt(), sc.nextInt());

            Arrays.sort(arr);
            double distance = 0.0;
            for(int i = 0; i < n - 1; i++)
            {
                double maxPoint = Integer.MIN_VALUE;
                for(int j = i + 1; j < n; j++)
                    maxPoint = Math.max(maxPoint, arr[j].y);

                if(maxPoint < arr[i].y)
                {
                    Line l = new Line(arr[i], arr[i + 1]);
                    Point intersect = new Point(l.getX(maxPoint), maxPoint);
                    distance += intersect.dist(arr[i]);
                }
            }

            DecimalFormat df = new DecimalFormat("0.00");
            pw.println(df.format(Math.round(distance * 100) / 100.0));
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
}