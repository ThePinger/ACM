
public class LineSegment
{
    Point p, q;
    static final double EPS = 1e-9;

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