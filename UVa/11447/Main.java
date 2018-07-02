//11447
//Resivoir Logs

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
            int n = sc.nextInt();
            Point[] arr = new Point[n + 1];
            for(int i = 0; i < n; i++)
                arr[i] = new Point(sc.nextInt(), sc.nextInt());
            arr[n] = arr[0];

            Polygon p = new Polygon(arr);
            int width = sc.nextInt();
            double percent = sc.nextDouble();
            double spent = sc.nextDouble();
            double rain = sc.nextDouble();
            double volume = p.area() * width;

            double cur = volume * (percent / 100.0);
            if(cur + EPS < spent)
            {
                pw.print("Lack of water. ");
                cur = 0.0;
            }
            else cur -= spent;
            
            cur += rain;
            if(volume + EPS < cur)
            {
                pw.print("Excess of water. ");
                percent = 100.0;
            }
            else percent = (cur / volume) * 100.0;
            
            pw.println("Final percentage: " + (int) Math.floor(percent) + "%");
        }

        pw.flush();
        pw.close();
    }

    static class Point
    {
        double x, y;

        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static class Polygon
    {
        Point[] points;

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
    }
}