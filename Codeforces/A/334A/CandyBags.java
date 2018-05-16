//334A
//CandyBags

import java.util.*;

public class CandyBags
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] taken = new boolean[n + 1][(n * n) + 1];
        
        int j = 1;
        boolean inc = true;
        for(int i = 1; i <= (n * n); i++)
        {   
            taken[j][i] = true;
            if(j == n || (j == 1 && i != 1))
            {
                if(i == n * n) break;

                taken[j][i + 1] = true;

                if(inc) j--;
                else j++;

                i++;
                inc = !inc;
            }
            else if(inc)
                j++;
            else 
                j--;
        }

        for(int i = 1; i <= n; i++)
        {
            for(int c = 1; c <= (n * n); c++)
                if(taken[i][c])
                    System.out.print(c + " ");
            System.out.println();
        }
    }

}