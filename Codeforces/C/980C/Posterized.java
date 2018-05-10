//980C
//Posterized

import java.util.Arrays;
import java.util.Scanner;

public class Posterized
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] groups = new int[256];
        int[] arr = new int[n];
        
        Arrays.fill(groups, -1);

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
        {
            int cur = arr[i];
            if(groups[cur] == -1)
            {
                int start = Math.max(0, cur - k + 1);
                if(groups[start] == -1)
                {
                    for(int j = start; j <= cur; j++)
                        groups[j] = start;
                }
                else if(cur - groups[start] + 1 > k)
                {
                    int newStart = -1;
                    for(int j = start; j < cur; j++)
                        if(groups[j] != groups[start])
                        {
                            newStart = j;
                            break;
                        }
                    
                    if(newStart == -1)
                        groups[cur] = cur;
                    else
                    {
                        for(int j = newStart; j <= cur; j++)
                            groups[j] = newStart;
                    }
                }
                else
                {
                    for(int j = start; j <= cur; j++)
                        groups[j] = groups[start];
                }
            }
        }

        for(int i = 0; i < n; i++)
            System.out.print(groups[arr[i]] + " ");
        System.out.println();
    }
}