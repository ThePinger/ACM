//363B
//Fence

import java.util.Scanner;

public class Fence
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        
        arr[0] = sc.nextInt();
        for(int i = 1; i < n; i++)
            arr[i] = sc.nextInt() + arr[i - 1];

        int min = arr[k - 1];
        int idx = 1;
        for(int i = 1; i <= n - k; i++)
            if(arr[i + k - 1] - arr[i - 1] < min)
            {
                min = arr[i + k - 1] - arr[i - 1];
                idx = i + 1;
            }

        System.out.println(idx);
    }
}