//1006A
//Adjacent Replacments

import java.util.*;

public class Replacments
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        while(n-->0)
        {
            int tmp = sc.nextInt();
            System.out.print((tmp % 2 == 0 ? tmp - 1 : tmp) + " ");
        }
    }
}