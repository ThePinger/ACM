//222A
//Shooshuns Sequence

import java.util.ArrayList;
import java.util.Scanner;

public class ShooshunsSeq
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt() - 1;
        int[] freq = new int[100001];
        int[] arr = new int[2 * n];
        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            arr[i] = tmp;
            freq[tmp]++;
        }

        int turns = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++)
        {
            int first = arr[i];
            int toRemove = arr[i + k];
            if(freq[first] == n) 
            {
                flag = true;
                break;
            }

            freq[toRemove]++;
            arr[i + n] = toRemove;
            freq[first]--;
            turns++;
        }
        
        if(flag || freq[arr[n]] == n) System.out.println(turns);
        else System.out.println(-1);
    }
}