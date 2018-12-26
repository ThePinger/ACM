//1092A
//UniformString

import java.util.*;

public class UniformString
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int i = 0;
            while(n-->0)
            {
                System.out.print((char) ('a' + i));
                i++;
                i %= k;
            }
            System.out.println();
        }
    }
}