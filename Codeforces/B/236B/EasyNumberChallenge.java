//236B
//EasyNumberChallenge

import java.util.*;

public class EasyNumberChallenge
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] divisors = new int[1000001];
        
        for(int i = 1; i < divisors.length; i++)
            for(int j = i; j < divisors.length; j += i)
                divisors[j]++;

        long ans = 0;
        for(int i = 1; i <= a; i++)
            for(int j = 1; j <= b; j++)
                for(int k = 1; k <= c; k++)
                    ans += divisors[i * j * k] % 1073741824;

        System.out.println(ans);
    }
}