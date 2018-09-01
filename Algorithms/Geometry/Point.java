
public class Point implements Comparable<Point>
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