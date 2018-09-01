
public class Circle
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