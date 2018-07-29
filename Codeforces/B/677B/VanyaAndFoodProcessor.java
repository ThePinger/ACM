//677B
//VanyaAndFoodProcessor

import java.util.*;

public class VanyaAndFoodProcessor
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int rem = 0;
        long count = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] + rem > h)
            {
                count++;
                rem = 0;
            }

            count += (arr[i] + rem) / k;
            rem = (arr[i] + rem) % k;
        }

        if(rem > 0) count++;

        System.out.println(count);
    }
}