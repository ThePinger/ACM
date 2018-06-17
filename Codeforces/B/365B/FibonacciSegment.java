//365B
//FibonacciSegment

import java.util.*;

public class FibonacciSegment
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            
        int max = 0;
        int count = 0;
        int start = 0;
        int maxStart = 0;
        for(int i = 2; i < n; i++)
        {
            if(arr[i] == arr[i - 1] + arr[i - 2])
                count++;
            else
            {
                if(max < count)
                {
                    max = count;
                    start = maxStart;
                }
                count = 0;  
                maxStart = i + 1;              
            }

            if(max < count)
            {
                max = count;
                start = maxStart;
            }
        }

        System.out.println(n == 1 ? 1 : max + 2);
    }
}