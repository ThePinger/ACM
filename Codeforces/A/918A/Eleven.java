//918A
//Eleven

import java.util.*;

public class Eleven
{
    static int[] memo;

    public static int fib(int i)
    {
        if(i < 3) return 1;

        if(memo[i] != -1)
            return memo[i];

        return memo[i] = fib(i - 1) + fib(i - 2);
    }

    public static boolean mem(int x)
    {
        for(int i = 1; i < 1001; i++)
            if(memo[i] == x)
                return true;
        return false;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        memo = new int[1001];
        Arrays.fill(memo, -1);
        fib(1000);

        int i = 1;
        while(n-->0)
        {
            if(mem(i) || i == 1)
                sb.append("O");
            else
                sb.append("o");
            i++;
        }

        System.out.println(sb);

    }
}