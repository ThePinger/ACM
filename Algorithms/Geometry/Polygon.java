
import java.util.*;

public class Polygon
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
        if(points.length < 3) return false;

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