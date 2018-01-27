//118B
//Present from Lena

import java.util.*;

public class Present
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = n; i > -1; i--)
        {
            for(int j = 0; j < i; j++)
                System.out.print("  ");
            
            for(int j = 0; j <= n - i; j++)
                if(j == 0 && j == n - i)
                    System.out.print(j);
                else
                    System.out.print(j + " ");

            for(int j = n - i - 1; j > -1; j--)
                if(j == 0)    
                    System.out.print(j);
                else
                    System.out.print(j + " ");

            System.out.println();
        }

        for(int i = 1; i <= n; i++)
        {
            for(int j = 0; j < i; j++)
                System.out.print("  ");
            
            for(int j = 0; j <= n - i; j++)
                if(j == 0 && j == n - i)
                    System.out.print(j);
                else
                    System.out.print(j + " ");

            for(int j = n - i - 1; j > -1; j--)
                if(j == 0)    
                    System.out.print(j);
                else
                    System.out.print(j + " ");

            System.out.println();
        }
    }
}