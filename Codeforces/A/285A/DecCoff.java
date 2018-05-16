//285A
//DecCoff

import java.util.Scanner;

public class DecCoff
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        for(int i = n; i > n - k; i--)
            System.out.print(i + " ");

        for(int i = 1; i <= n - k; i++)
            System.out.print(i + " ");
    }
}