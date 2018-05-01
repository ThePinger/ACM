//975B

import java.util.*;

public class Mancala
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[14];
        for(int i = 0; i < 14; i++)
            arr[i] = sc.nextInt();
            
        long max = 0;
        for(int i = 0; i < 14; i++)
        {
            int[] tmp = arr.clone();
            int stones = arr[i];
            tmp[i] = 0;

            int div = stones / 14;
            int rem = stones % 14;

            for(int j = 0; j < 14; j++)
                tmp[j] += div;
            
            int j = i + 1;
            while(rem-->0)
            {
                if(j == 14) j = 0;
                tmp[j]++;
                j++;
            }

            long ans = 0;
            for(int c = 0; c < 14; c++)
                if(tmp[c] % 2 == 0)
                    ans += tmp[c];
            
            max = Math.max(max, ans);
        }

        System.out.println(max);
    }
}