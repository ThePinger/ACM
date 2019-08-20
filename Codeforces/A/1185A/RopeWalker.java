//1185A
//RopeWalker

import java.util.*;

public class RopeWalker
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); 
        int b = sc.nextInt();
        int c = sc.nextInt(); 
        int d = sc.nextInt();

        int start = Math.min(a, Math.min(b, c));
        int end = Math.max(a, Math.max(b, c));
        int mid = 0;
        if(a == start)
        {
            if(b == end) mid = c;
            else mid = b;
        }
        else if(a == end)
        {
            if(b == start) mid = c;
            else mid = b;
        }
        else mid = a;

        int moves = 0;
        if(mid - start < d) moves += d - (mid - start);
        if(end - mid < d) moves += d - (end - mid);

        System.out.println(moves);
    }
}