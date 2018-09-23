//1047A
//Little C Loves 3 I

import java.util.*;

public class A
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if((n - 2) % 3 == 0)
            System.out.println("1 2 " + (n - 3));
        else 
            System.out.println("1 1 " + (n - 2));
    }
}