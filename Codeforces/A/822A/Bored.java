//822A
//Bored With Life

import java.util.*;

public class Bored
{

    public static int factorial(int x)
    {
        return x == 1 ? 1 : x * factorial(x - 1);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(factorial(Math.min(a, b)));
    }
}