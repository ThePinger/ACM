//706A
//BeruTaxi

import java.util.*;

public class BeruTaxi
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int n = sc.nextInt();
        double min = Double.MAX_VALUE;

        while(n-->0)
        {
            int xi = sc.nextInt();
            int yi = sc.nextInt();
            double sp = sc.nextInt();
            double tmp = Math.pow(x - xi, 2) + Math.pow(y - yi, 2);
            tmp = Math.sqrt(tmp);
            min = Math.min(min, tmp / sp);
        }

        System.out.println(min);
    }
}