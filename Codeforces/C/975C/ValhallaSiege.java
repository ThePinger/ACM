//975

import java.util.*;

public class ValhallaSiege
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int warriors = sc.nextInt() + 1;
        int minutes  = sc.nextInt();
        long[] strength = new long[warriors];
        long[] order    = new long[minutes];
        
        strength[1] = sc.nextLong();
        for(int i = 2; i < warriors; i++)
            strength[i] = sc.nextLong() + strength[i - 1];

        for(int i = 0; i < minutes; i++)
            order[i] = sc.nextLong();
        
        long sum = 0;
        for(int i = 0; i < minutes; i++)
        {
            sum += order[i];
            int lo = 1;
            int hi = warriors - 1;
            int tmp = 0;
            while(lo <= hi)
            {
                int mid = (lo + hi) / 2;
                if(strength[mid] > sum)
                    hi = mid - 1;
                else
                {
                    lo = mid + 1;
                    tmp = lo;
                }
            }

            if(tmp == warriors)
            {
                sum = 0;
                System.out.println(warriors - 1);
            }
            else if(tmp == 0)
                System.out.println(warriors - 1);
            else
                System.out.println(warriors - tmp);
        }
        
    }
}