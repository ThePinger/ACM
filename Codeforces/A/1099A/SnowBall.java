//1099A
//SnowBall

import java.util.*;

public class SnowBall
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int u1 = sc.nextInt();
        int d1 = sc.nextInt();
        int u2 = sc.nextInt();
        int d2 = sc.nextInt();

        while(h > 0)
        {
            w += h;
            if(h == d1)
                w = Math.max(0, w - u1);
            else if(h == d2)
                w = Math.max(0, w - u2);
            h--;
        }

        System.out.println(w);
    }
}