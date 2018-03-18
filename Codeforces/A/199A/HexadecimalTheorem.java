//199A
//Hexadecimal Theorem

import java.util.Arrays;
import java.util.Scanner;

public class HexadecimalTheorem
{

    static int n, n1, n2, n3;
    static int[] fib;

    public static void getNums(int i, int a1, int a2, int a3)
    {
        if(a3 != -1 || i == 51)
        {
            if(a3 != -1 && a1 + a2 + a3 == n)
            {
                n1 = a1;
                n2 = a2;
                n3 = a3;
            }
            return;
        }

        if(a1 == -1)
        {
            getNums(i, fib[i], a2, a3);
            getNums(i + 1 , fib[i], a2, a3);
        }
        else if(a2 == -1)
        {
            getNums(i, a1, fib[i], a3);
            getNums(i + 1 , a1, fib[i], a3);
        }
        else 
        {
            getNums(i, a1, a2, fib[i]);
            getNums(i + 1 , a1, a2, fib[i]);
        }
        getNums(i + 1, a1, a2, a3);
    }

    public static int fib(int i)
    {
        if(i < 3) return 1;
        if(fib[i] != -1) return fib[i];
        return fib[i] = fib(i - 1) + fib(i - 2);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        fib = new int[51];
        Arrays.fill(fib, -1);
        fib[0] = 0;
        fib[1] = fib[2] = 1;
        fib(50);

        getNums(0, -1, -1, -1);
        if(n1 == -1) System.out.println("I'm too stupid to solve this problem");
        else System.out.println(n1 + " " + n2 + " " + n3);
    }
}