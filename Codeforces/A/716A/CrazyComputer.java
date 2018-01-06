//716A
//CrazyComputer

import java.util.*;

public class CrazyComputer
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sec = sc.nextInt();
        int[] time = new int[n];
        for(int i = 0; i < n; i++)
            time[i] = sc.nextInt();
        
        int curWords = 1;
        for(int i = 1; i < n; i++)
            if(time[i] - time[i - 1] <= sec)
                curWords++;
            else
                curWords = 1;
        
        System.out.println(curWords);
    }
}