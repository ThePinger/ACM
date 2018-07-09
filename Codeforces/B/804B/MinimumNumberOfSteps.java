//804B
//MinimumNumberOfSteps

import java.util.*;

public class MinimumNumberOfSteps
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        char[] line = sc.next().toCharArray();
        long ans = 0;
        long b = 0;
        for(int i = line.length - 1; i > -1; i--)
        {
            if(line[i] == 'a')
            {
                ans += b;
                b *= 2;
                ans %= 1000000007;
                b %= 1000000007;
            }
            else b++;
        }

        System.out.println(ans);
    }
}
