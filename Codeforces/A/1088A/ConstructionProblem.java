//1088A
//ConstructionProblem

import java.util.*;

public class ConstructionProblem
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a = -1;
        int b = -1;

        loop : for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                if(i % j == 0 && i * j > n && i / j < n)
                {
                    a = i;
                    b = j; 
                    break loop;
                }

        System.out.println(a == -1 ? -1 : a + " " + b);
    }
}