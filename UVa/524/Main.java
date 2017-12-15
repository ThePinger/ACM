//524
//Prime Number Ring

import java.util.*;

public class Main
{
    static int n;
    static int[] ring;
    static StringBuilder sb;

    public static boolean isPrime(int x)
    {
        for(int i = x - 1 ; i > 1 ; i--)
            if(x % i == 0)
                return false;
        
        return true;
    }

    public static boolean notAvailable(int i, int end)
    {
        for(int j = 0 ;  j < end ; j++)
            if(ring[j] == i)
                return false;
        
        return true;
    }


    public static void getRing(int cur)
    {
        if(cur == n && isPrime(ring[n - 1] + 1))
        {
            sb.append(1);
            for(int i = 1 ; i < n ; i++) sb.append(" " + ring[i]);
            sb.append("\n");
            return;
        }

        for(int i = 2 ; i <= n ; i++)
            if(isPrime(ring[cur-1] + i) && notAvailable(i, cur))
            {
                ring[cur] = i;
                getRing(cur + 1);
            }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        int i = 1;
        while(sc.hasNext())
        {
            n = sc.nextInt();
            ring = new int[n];
            ring[0] = 1;
            sb.append("Case " + i + ":\n");
            getRing(1);
            i++;
            if(sc.hasNext()) sb.append("\n");
        }
        System.out.print(sb);
    }
}