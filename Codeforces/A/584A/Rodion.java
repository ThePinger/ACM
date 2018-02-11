//584A
//Olesya and Rodion

import java.util.*;

public class Rodion
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String s = "";

        if(t == 10 && n > 1)
        {
            while(s.length() < n - 1)
                s += 1;
            s += 0;
        }
        else
            while(s.length() < n) s += t;

        if(s.length() > n) System.out.println(-1);
        else System.out.println(s);
    }
}