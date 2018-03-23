//214A
//System of Equations

import java.util.Scanner;

public class SystemOfEquations
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int pairs = 0;
        for(int a = 0; a <= n; a++)
        {
            int b = n - (a * a);
            if(a + (b * b) == m && b > -1)
                pairs++;
        }

        System.out.println(pairs);
    }
}