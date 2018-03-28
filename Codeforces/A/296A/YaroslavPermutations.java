//296A
//Yaroslav Permutations

import java.util.Scanner;

public class YaroslavPermutations
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] freq = new int[1001];
        boolean flag = true;
        
        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            freq[tmp]++;
            if(freq[tmp] > (n + 1) / 2)
                flag = false;
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}