//766C
//MahmoudMessage

import java.util.*;

public class MahmoudMessage
{
    static int n, maxSub;
    static int[] maxL;
    static char[] string;
    static int[][] memo;

    public static boolean isOk(int end, int start)
    {
        int curL = end - start;
        for(int i = start; i < end; i++)
            if(maxL[string[i] - 'a'] < curL)
                return false;
        return true;
    }

    public static int substrings(int idx, int start)
    {
        if(idx == n)
            return 1;

        if(memo[idx][start] != -1)
            return memo[idx][start];


        int ways = 0;
        if(!isOk(idx + 1, start))
        {
            maxSub = Math.max(maxSub, idx - start);                        
            ways = substrings(idx + 1, idx);
        }
        else
        {
            maxSub = Math.max(maxSub, idx - start + 1);            
            ways = substrings(idx + 1, start);
            ways += substrings(idx + 1, idx);
        }

        return memo[idx][start] = ways % 1000000007;
    }

    public static int minSubstrings(int idx, int start)
    {
        if(idx == n)
            return 0;

        if(memo[idx][start] != -1)
            return memo[idx][start];


        int append = (int) 1e9; 
        int newSub = (int) 1e9;
        if(!isOk(idx + 1, start))
            newSub = 1 + minSubstrings(idx + 1, idx);
        else
        {
            append = minSubstrings(idx + 1, start);
            newSub = 1 + minSubstrings(idx + 1, idx);
        }

        return memo[idx][start] = Math.min(append, newSub);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        string = sc.next().toCharArray();
        maxL = new int[26];
        memo = new int[n][n + 1];

        for(int[] xx : memo)
            Arrays.fill(xx, -1);

        for(int i = 0; i < 26; i++)
            maxL[i] = sc.nextInt();

        System.out.println(substrings(1, 0));

        if(n == 1)
            System.out.println(1);
        else
            System.out.println(maxSub);

        for(int[] xx : memo)
            Arrays.fill(xx, -1);

        System.out.println(1 + minSubstrings(1, 0));
    }
}