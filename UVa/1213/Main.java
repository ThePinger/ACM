//1213
//Sum of Different Primes

import java.util.*;

public class Main 
{
    static ArrayList<Integer> primes;
    static int[] isComposite;
    static int[][][] memo;
    static int n, k;

	static void sieve(int N)	// O(N log log N) 
	{
		isComposite = new int[N+1];					
		isComposite[0] = isComposite[1] = 1;			// 0 indicates a prime number
		primes = new ArrayList<Integer>();

		for (int i = 2; i <= N; ++i) 					//can loop till i*i <= N if primes array is not needed O(N log log sqrt(N)) 
			if (isComposite[i] == 0) 					//can loop in 2 and odd integers for slightly better performance
			{
				primes.add(i);
				if(1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)	// j = i * 2 will not affect performance too much, may alter in modified sieve
						isComposite[j] = 1;
			}   
    }

    public static int dp(int curS, int numsU, int idx)
    {

        if(numsU == k)
        {
            if(curS == n)
                return 1;
            return 0;
        }

        if(curS > n)
            return 0;

        if(idx == primes.size())
            return 0;

        if(memo[curS][numsU][idx] != -1)
            return memo[curS][numsU][idx];
        
        int ans = dp(curS + primes.get(idx), numsU + 1, idx + 1);
        ans += dp(curS, numsU, idx + 1);

        return memo[curS][numsU][idx] = ans;
    }
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        primes = new ArrayList<>();
        isComposite = new int[1121];
        sieve(1120);

        int t = 1;
        while(true)
        {
            n = sc.nextInt();
            k = sc.nextInt();
            if(n == 0) break;
            if(t > 1) sb.append("\n");

            memo = new int[n + 1][k][primes.size()];       
            for(int[][] x : memo)
                for(int[] xx : x)
                Arrays.fill(xx, -1);

            sb.append(dp(0, 0, 0));
            t++;
        }
        System.out.println(sb);
    }
}