//92A
//Chips

import java.util.Scanner;

public class Chips
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = 1;

        while(true)
        {
            if(start > m) break;
            m -= start;

            if(start == n) start = 1;
            else start++;
        }

        System.out.println(m);
    }
}