//352B
//Jeff and Periods

import java.util.Scanner;

public class JeffPeriods
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
            
        int[] lastApp = new int[100001];
        int[] curDiff  = new int[100001];
        boolean[] valid = new boolean[100001];

        for(int i = 0; i < n; i++)
            if(lastApp[arr[i]] == 0)
            {
                lastApp[arr[i]] = i + 1;
                curDiff[arr[i]] = 0;
                valid[arr[i]] = true;
            }
            else if(curDiff[arr[i]] == 0)
            {
                curDiff[arr[i]] = i + 1 - lastApp[arr[i]];
                lastApp[arr[i]] = i + 1;
            }
            else
            {
                int tmp = i + 1 - lastApp[arr[i]];
                if(curDiff[arr[i]] == tmp)
                    lastApp[arr[i]] = i + 1;
                else valid[arr[i]] = false;
            }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < valid.length; i++)
            if(valid[i])
            {
                count++;
                sb.append(i + " " + curDiff[i] + "\n");
            }

        System.out.println(count);
        System.out.print(sb);
    }
}