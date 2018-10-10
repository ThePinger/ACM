//1059A
//Cashier

import java.io.*;
import java.util.*;

public class Cashier
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int l = sc.nextInt();
        int a = sc.nextInt();

        int breaks = 0;
        int cur = 0;
        while(n-->0)
        {
            int arrive = sc.nextInt();
            int service = sc.nextInt();
            breaks += (arrive - cur) / a;
            cur = arrive + service;
        }

        breaks += (l - cur) / a;
        System.out.println(breaks);
    }
}