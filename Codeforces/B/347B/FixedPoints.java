//347B
//FixedPoints

import java.util.*;

public class FixedPoints
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int fx = 0;
        int max = 0;
        for(int i = 0; i < n; i++)
            if(arr[i] == i)
                fx++;
            else if(arr[arr[i]] == i)
                max = 2;
            else max = Math.max(max, 1);
        
        System.out.println(fx + max);
    }
}