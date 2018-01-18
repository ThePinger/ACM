//60A
//Where Are My Flakes

import java.util.*;

public class WhereAreMyFlakes
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int boxes = sc.nextInt();
        int hints = sc.nextInt();
        int[] vis = new int[boxes + 1];

        int checks = 0;
        int cur = -1;
        if(hints == 0)
            System.out.println(boxes);
        else
        {
            
            int lo = 1;
            int hi = boxes;
            while(hints-->0)
            {
                sc.next();
                sc.next();
                String direction = sc.next();
                sc.next();
                int next = sc.nextInt();

                if(next < lo)
                {
                    if(direction.equals("left"))
                    {
                        hi = -1;
                        lo = 0;
                        break;
                    }
                    continue;
                }
                if(next > hi)
                {
                    if(direction.equals("right"))
                    {
                        hi = -1;
                        lo = 0;
                        break;
                    }
                    continue;
                }

                if(direction.equals("left"))
                    hi = next - 1;
                else
                    lo = next + 1;    
            }

            if(hi - lo + 1 == 0) System.out.println(-1);
            else System.out.println(hi - lo + 1);
        }
    }
}