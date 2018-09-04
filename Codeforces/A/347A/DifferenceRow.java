//347A
//DifferenceRow

import java.util.*;

public class DifferenceRow
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        Arrays.sort(arr);

        int tmp = arr[0];
        arr[0] = arr[n - 1];
        arr[n - 1] = tmp;

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}