//239A
//TwoBagsOfPotatoes

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwoBagsOfPotatoes
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int k = sc.nextInt();
        int n = sc.nextInt();
        
        int maxX = n - y;
        if(maxX < 1 || k > n) System.out.println(-1);
        else
        {
            int start = (y - (y % k) + k) - y;
            if(start < 0 || start > maxX) System.out.println(-1);
            else
            {
                for(int i = start; i <= maxX; i += k)
                    System.out.print(i + " ");
                System.out.println();
            }
        }
    }
}