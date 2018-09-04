//344B
//SimpleMolecules

import java.util.*;

public class SimpleMolecules
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int one = 0, two = 0, thr = 0;
        while(true)
        {

            if(a == 0 && b == 0 && c == 0) break;
            if(a == 0 && b == 0 && c != 0)
            {
                a = -1;
                break;
            }
            if(a == 0 && b != 0 && c == 0)
            {
                a = -1;
                break;
            }
            if(a != 0 && b == 0 && c == 0) 
            {
                a = -1;
                break;
            }

            if(a >= b && a >= c)
            {
                if(b > 0)
                {
                    b--;
                    a--;
                    one++;
                }

                if(c > 0)
                {
                    c--;
                    a--;
                    thr++;
                }
            }
            else if(b >= a && b >= c)
            {   
                if(a > 0)
                {
                    a--;
                    b--;
                    one++;
                }

                if(c > 0)
                {
                    c--;
                    b--;
                    two++;
                }
            }
            else
            {
                if(a > 0)
                {
                    a--;
                    c--;
                    thr++;
                }

                if(b > 0)
                {
                    b--;
                    c--;
                    two++;
                }
            }
        }

        System.out.println(a == -1 ? "Impossible" : one + " " + two + " " + thr);
    }
}