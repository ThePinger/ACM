//832A
//Sticks

import java.util.*;

public class Sticks
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        System.out.println((n / k) % 2 == 0 ? "NO" : "YES");
    }
}