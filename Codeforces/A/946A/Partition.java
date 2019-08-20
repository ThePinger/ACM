//946A
//Partition

import java.util.*;

public class Partition
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int b = 0, c = 0; 
        while(n-->0)
        {
            int tmp = sc.nextInt();
            if(tmp < 0) c += tmp;
            else b += tmp;
        }

        System.out.println(b - c);
    }
}