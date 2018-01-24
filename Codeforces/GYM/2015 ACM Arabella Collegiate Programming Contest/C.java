
import java.util.*;
import java.io.*;


public class C
{

    static int memory, appSize, n;
    static int[] nums;
    static int[][] memo;

    public static int dp(int curApp, int spaceUsed)
    {
        if(curApp == n)
        {
            if(spaceUsed + appSize <= memory)
                return 0;
            return (int) 1e9;
        }

        if(memo[curApp][spaceUsed] != -1)
            return memo[curApp][spaceUsed];

        int remove = 1 + dp(curApp + 1, spaceUsed - nums[curApp]);
        int leave  = dp(curApp + 1, spaceUsed);

        return memo[curApp][spaceUsed] = Math.min(remove, leave);
    }

    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();

        while(t-->0)
        {
            memory = sc.nextInt();
            appSize = sc.nextInt();
            n = sc.nextInt();
            
            nums = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++)
            {
                nums[i] = sc.nextInt();
                sum += nums[i];
            }

            memo = new int[n][memory + 1];
            for(int[] x :memo)
                Arrays.fill(x, -1);

            pw.println(dp(0, sum));
        }    
        pw.flush();
        pw.close();
    }
}