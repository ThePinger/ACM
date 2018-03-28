//242B
//BigSegment

import java.util.Scanner;
import java.util.TreeSet;

public class BigSegment
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        Pair[] arr = new Pair[n]; 
        int idx = -1;
        int maxX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;  

        for(int i = 0; i < n; i++)
        {
            arr[i] = new Pair(sc.nextInt(), sc.nextInt());
            if(arr[i].x <= maxX && arr[i].y >= maxY)
            {
                maxX = arr[i].x;
                maxY = arr[i].y;
                idx = i + 1;
            }
        }

        boolean flag = true;
        for(int i = 0; i < n; i++)
        {
            if(arr[i].x >= maxX && arr[i].y <= maxY)
                continue;
            flag = false;
            break;
        }

        if(flag) System.out.println(idx);
        else System.out.println(-1);
    }

    static class Pair
    {
        int x, y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}