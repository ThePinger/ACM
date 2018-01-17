//80A
//Panoramix Prediction

import java.util.*;

public class PanoramixPrediction
{

    public static boolean isPrime(int y)
    {
        for(int i = 2; i < y - 1; i++)
            if(y % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(!isPrime(y))
        {
            System.out.println("NO");
            return;
        }

        y--;
        while(y > 2)
        {
            if(isPrime(y)) break;
            y--;    
        }

        if(y == x) System.out.println("YES");
        else System.out.println("NO");
    }
}