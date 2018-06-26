//671A
//Recycling Bottles

import java.util.*;

public class RecyclingBottles
{

    static final double EPS = 1e-9;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Point initA = new Point(sc.nextInt(), sc.nextInt());
        Point initB = new Point(sc.nextInt(), sc.nextInt());
        Point trash = new Point(sc.nextInt(), sc.nextInt());
        
        int n = sc.nextInt();
        double[] distA = new double[n];
        double[] distB = new double[n];
        double[] distT = new double[n];
        double ans = 0.0;
        double minA = Double.MAX_VALUE;
        double minB = Double.MAX_VALUE; 
        PriorityQueue<Pair> a = new PriorityQueue<>();
        PriorityQueue<Pair> b = new PriorityQueue<>();       
        for(int i = 0; i < n; i++)
        {
            Point tmp = new Point(sc.nextInt(), sc.nextInt());
            distA[i] = initA.dist(tmp);
            distB[i] = initB.dist(tmp);
            distT[i] = trash.dist(tmp);
            minA = Math.min(minA, distA[i] - distT[i]);
            minB = Math.min(minB, distB[i] - distT[i]);
            a.add(new Pair(i, distA[i] - distT[i]));
            b.add(new Pair(i, distB[i] - distT[i]));
            ans += 2 * distT[i];
        }
            
        double minAB = Double.MAX_VALUE;
        if(n > 1)
        {
            Pair oneA = a.poll();
            Pair oneB = b.poll();
            Pair twoA = a.poll();
            Pair twoB = b.poll();
            if(oneA.num != oneB.num)
                minAB = oneA.dist + oneB.dist;
            if(oneA.num != twoB.num)
                minAB = Math.min(minAB, oneA.dist + twoB.dist);
            if(twoA.num != oneB.num)
                minAB = Math.min(minAB, twoA.dist + oneB.dist);
        }
        else
            minAB = Math.min(a.poll().dist, b.poll().dist);

        System.out.println(ans + Math.min(minAB, Math.min(minA, minB)));
    }

    static class Pair implements Comparable<Pair>
    {
        int num;
        double dist;

        public Pair(int num, double dist)
        {
            this.num = num;
            this.dist = dist;
        }

        public int compareTo(Pair p)
        {
            if(Math.abs(this.dist - p.dist) < EPS)
                return this.num - p.num;
            return this.dist > p.dist ? 1 : -1;
        }

        public String toString()
        {
            return this.num + " " + this.dist;
        }
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
}