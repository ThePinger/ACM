//476A

import java.util.*;

public class Stairs
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        int m = sc.nextInt();
        int min = (int) 1e9;

        for(int y = 0 ; y < stairs + 1; y++)
        {
            int x = stairs - (2 * y);
            if(x > -1 && (x + y) % m == 0 && (x + y) < min)
                min = x + y;
        }

        if(min < (int) 1e9) System.out.println(min);
        else System.out.println(-1);
    }
}