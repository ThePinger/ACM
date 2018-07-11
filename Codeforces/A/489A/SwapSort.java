//489A
//SwapSort

import java.util.*;

public class SwapSort
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];    
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            int idx = i;
            int min = arr[i];
            for(int j = i + 1; j < n; j++)
            {
                if(arr[j] < min)
                {
                    min = arr[j];
                    idx = j;
                }
            }
            if(idx != i)
            {
                arr[idx] = arr[i];
                arr[i] = min;
                count++;
                sb.append(i + " " + idx + "\n");
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}