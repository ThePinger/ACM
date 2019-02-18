//233B
//NonSquare Equation

import java.util.*;

public class NonSquareEquation 
{
    public static int sumDigits(int x)
    {
        int sum = 0;
        while(x > 0)
        {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static long equation(int x)
    {
        return (1l * x * x) + (1l * x * sumDigits(x));
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        for(int b = 0; b <= 81; b++)
        {
            int a = 1;
            long c = -n;
            double x = Math.max((-b + Math.sqrt((b * b) - (4 * a * c))) / (2.0 * a), 
                                (-b - Math.sqrt((b * b) - (4 * a * c))) / (2.0 * a));

            if((int) x == x && sumDigits((int) x) == b && equation((int) x) == n)
            {
                System.out.println((int) x);
                return;
            }
        }

        System.out.println(-1);
    }
}