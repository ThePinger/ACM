//388A
//Fox and Box Accumulation

import java.util.*;

public class FoxAndBoxAccumulation
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int[] piles = new int[n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(piles[j] <= arr[i])
                {
                    piles[j]++;
                    break;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++)
            if(piles[i] > 0)
                count++;

        System.out.println(count);
    }
}