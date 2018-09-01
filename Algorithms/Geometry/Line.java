
public class Line
{
    double a, b, c;
    static final double EPS = 1e-9;

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

