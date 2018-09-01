
public class Vector
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
        return Math.sqrt(square(this.x) + square(this.y));
    }

    private double square(double x)
    {
        return x * x;
    }
}