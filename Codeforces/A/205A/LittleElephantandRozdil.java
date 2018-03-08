//205A
//Little Elephant and Rozdil

import java.util.*;

public class LittleElephantandRozdil
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = -1;
        int freq = 0;
        int min = Integer.MAX_VALUE;
        int[] cities = new int[n];
        for(int i = 0; i < n; i++)
        {
            cities[i] = sc.nextInt();
            if(cities[i] == min)
                freq++;
            else if(cities[i] < min)
            {
                freq = 1;
                idx  = i + 1;
                min  = cities[i];
            }
        }

        if(freq != 1) System.out.println("Still Rozdil");
        else System.out.println(idx);
    }
}
