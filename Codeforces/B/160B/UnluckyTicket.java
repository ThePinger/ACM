//160B
//UnluckyTicket

import java.util.*;

public class UnluckyTicket
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        int[] left = new int[n];
        int[] right = new int[n];
        int rightCount = 0;
        int leftCount  = 0;

        for(int i = 0; i < n; i++)
            left[i] = Character.getNumericValue(s[i]);

        for(int i = 0; i < n; i++)
            right[i] = Character.getNumericValue(s[i + n]);
        
        Arrays.sort(left);
        Arrays.sort(right);
        
        for(int i = 0; i < n; i++)
            if(right[i] > left[i])
                rightCount++;
            else if(right[i] < left[i])
                leftCount++;
                

        if(leftCount == n || rightCount == n) System.out.println("YES");
        else System.out.println("NO");
    }
}