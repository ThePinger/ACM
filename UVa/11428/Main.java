//11428
//Cubes

import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while(true)
        {
            int n = sc.nextInt();
            if(n == 0) break;
            if(t > 1) sb.append("\n");

            int x = -1;
            int y = -1;

            for(int xx = 2; xx < n + 1; xx++)
            {
                int cube = xx * xx * xx;
                int yy = cube - n;
                if(yy <= 0) continue;

                yy = (int) Math.cbrt(yy);
                int cubeY = yy * yy * yy;
                if(cube - cubeY == n)
                {
                    x = xx;
                    y = yy;
                    break;
                }
            }

            if(x == -1)
                sb.append("No solution");
            else
                sb.append(x + " " + y);
            t++;
        }
        System.out.println(sb);
    }
}