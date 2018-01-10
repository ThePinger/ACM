//459A
//Pashmak and Garden

import java.awt.Point;
import java.util.*;

public class PashmakGarden
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Point p1 = new Point(sc.nextInt(), sc.nextInt());
        Point p2 = new Point(sc.nextInt(), sc.nextInt());
        
        if(p1.x == p2.x)
        {
            int tmpx = p1.x + Math.abs(p1.y - p2.y);
            if(tmpx + Math.abs(p1.y - p2.y) > 1000) 
                tmpx = p1.x - Math.abs(p1.y - p2.y);
            int tmpy = Math.min(p1.y, p2.y) + Math.abs(p1.y - p2.y);

            Point px = new Point(tmpx, Math.min(p1.y, p2.y));
            Point py = new Point(px.x, tmpy);

            if((px.x > 1000 || px.x < -1000) || (px.y > 1000 || px.y < -1000) || (py.x > 1000 || py.x < -1000) || (py.y > 1000 || py.y < -1000))
                System.out.println(-1);
            else
                System.out.println(px.x + " " + px.y + " " + py.x + " " + py.y);
        }
        else if(p1.y == p2.y)
        {
            int tmpx = p1.y + Math.abs(p1.x - p2.x);
            if(tmpx + Math.abs(p1.x - p2.x) > 1000) 
                tmpx = p1.y - Math.abs(p1.x - p2.x);
            int tmpy = Math.min(p1.x, p2.x) + Math.abs(p1.x - p2.x);

            Point px = new Point(Math.min(p1.x, p2.x), tmpx);
            Point py = new Point(tmpy, px.y);

            if((px.x > 1000 || px.x < -1000) || (px.y > 1000 || px.y < -1000) || (py.x > 1000 || py.x < -1000) || (py.y > 1000 || py.y < -1000))
                System.out.println(-1);
            else
                System.out.println(px.x + " " + px.y + " " + py.x + " " + py.y);
        }
        else
        {
            Point px = new Point(p2.x, p1.y);
            Point py = new Point(p1.x, p2.y);
            if(Math.abs(p1.x - p2.x) == Math.abs(p1.y - p2.y))
                System.out.println(px.x + " " + px.y + " " + py.x + " " + py.y);
            else
                System.out.println(-1);            
        }
    }
}