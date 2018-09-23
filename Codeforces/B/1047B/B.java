//1047B
//Cover Points

import java.util.*;

public class B
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        int max = 0;
        while(n-->0)
            max = Math.max(max, sc.nextInt() + sc.nextInt());

        System.out.println(max);
    }
}