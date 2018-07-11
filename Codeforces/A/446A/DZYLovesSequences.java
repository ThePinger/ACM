//446A
//DZYLovesSequences

import java.util.*;

public class DZYLovesSequences
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        if(n == 1)
        {
            System.out.println(1);
            return;
        }

        int[] left = new int[n];
        Arrays.fill(left, 1);
        for(int i = 1; i < n; i++) 
            if(arr[i] > arr[i - 1])
                left[i] += left[i - 1];

       int[] right = new int[n];
       Arrays.fill(right, 1);
       for(int i = n - 2; i > -1; i--)
            if(arr[i] < arr[i + 1])
                right[i] += right[i + 1];

        int max = Math.max(right[1] + 1, left[n - 2] + 1);
        for(int i = 1; i < n - 1; i++)
        {
            if(arr[i - 1] + 1 < arr[i + 1])
                max = Math.max(max, left[i - 1] + right[i + 1] + 1);
            max = Math.max(max, left[i - 1] + 1);
            max = Math.max(max, right[i + 1] + 1);
        }

        System.out.println(n == 2 ? 2 : max);
    }
}