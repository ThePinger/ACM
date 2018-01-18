//233A
//Perfect Permutation

import java.util.*;

public class PerfectPermutation
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n % 2 != 0)
            System.out.println(-1);
        else
        {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++)
                if(i % 2 == 0)
                    sb.append(i - 1 + " ");
                else
                    sb.append(i + 1 + " ");
            System.out.println(sb);
        }
        
    }
}