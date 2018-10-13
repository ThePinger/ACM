//1033C
//PermutationGame

import java.util.*;

public class PermutationGame
{

    static int n;
    static int[] numToIdx, arr;
    static Boolean[][] memo;
    static ArrayList<Integer>[] adjList;

    public static boolean dp(int idx, int turn)
    {
        if(memo[idx][turn] != null)
            return memo[idx][turn];

        boolean result = false;
        for(int nxt : adjList[idx])
            result |= !dp(nxt, turn == 1 ? 0 : 1);

        return memo[idx][turn] = result;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = i + arr[i]; j < n; j += arr[i])
                if(arr[i] < arr[j])
                    adjList[i].add(j);

            for(int j = i - arr[i]; j > -1; j -= arr[i])
                if(arr[i] < arr[j])
                    adjList[i].add(j);
        }

        memo = new Boolean[n][2];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append(dp(i, 0) ? "A" : "B");

        System.out.println(sb);
    }
}