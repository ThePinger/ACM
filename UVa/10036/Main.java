//10036
//Divisibility

import java.util.*;

public class Main 
{

    static int numbers, k;
    static int[] values;
    static long[][] memo;

    public static long dp(int idx, int remSum)
    {
        if(idx == numbers)
        {
            if(remSum % k == 0)
                return 1;
            return 0;
        }

        if(memo[idx][remSum + k] != -1)
            return memo[idx][remSum + k];

        long plus = dp(idx + 1, (remSum + (values[idx] % k)) % k);
        long minus = dp(idx + 1, (remSum - (values[idx] % k)) % k);

        if(plus == 1 || minus == 1)
            return memo[idx][remSum + k] = 1;

        return memo[idx][remSum + k] = 0;        
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        
        while(n-->0)
        {
            numbers = sc.nextInt();
            k = sc.nextInt();
            values = new int[numbers];

            for(int i = 0; i < numbers; i++)
                values[i] = sc.nextInt();

            memo = new long[numbers][201];
            for(long[] x : memo)
                Arrays.fill(x, -1);

            long ans = dp(1, values[0] % k);

            if(ans == 1)
                sb.append("Divisible\n");
            else
                sb.append("Not divisible\n");

        }
        System.out.print(sb);
    }
}