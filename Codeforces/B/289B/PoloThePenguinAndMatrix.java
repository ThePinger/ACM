//289B
//Polo the Penguin and Matrix

import java.util.*;

public class PoloThePenguinAndMatrix
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n * m];
        int[] possmoves = new int[n * m];
        
        for(int i = 0; i < n * m; i++)
            arr[i] = sc.nextInt();

        int moves = Integer.MAX_VALUE;
        for(int i = 0; i < n * m; i++)
        {
            boolean flag = true;        
            for(int j = i + 1; j < n * m; j++)
            {
                int abs = Math.abs(arr[j] - arr[i]);
                int div = abs / d;
                if(i == j) continue;
                else if(div * d == abs)
                {
                    possmoves[i] += div;
                    possmoves[j] += div;
                }
                else flag = false;
            }

            if(flag)
                moves = Math.min(possmoves[i], moves);
            else 
            {
                moves = Integer.MAX_VALUE;
                break;
            }
        }

        if(moves == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(moves);
    }
}