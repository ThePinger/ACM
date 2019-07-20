//416C
//BookingSystem

import java.util.*;

public class BookingSystem
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Pair[] guests = new Pair[n];
        for(int i = 0; i < n; i++)
            guests[i] = new Pair(i, sc.nextInt(), sc.nextInt());

        int k = sc.nextInt();
        int[] tables = new int[k];
        for(int i = 0; i < k; i++)
            tables[i] = sc.nextInt();

        Arrays.sort(guests);

        int count = 0;
        int money = 0;
        int[] matched = new int[n];
        Arrays.fill(matched, -1);
        boolean[] taken = new boolean[k];
        for(int i = n - 1; i > -1; i--)
        {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int j = 0; j < k; j++)
            {
                if(tables[j] >= guests[i].x && !taken[j] && tables[j] < min)
                {
                    min = tables[j];
                    idx = j;
                }
            }
            
            if(idx != -1)
            {
                count++;
                money += guests[i].y;
                matched[guests[i].idx] = idx;
                taken[idx] = true;
            }
        }

        System.out.println(count + " " + money);
        for(int i = 0; i < n; i++)
            if(matched[i] != -1)
                System.out.println((i + 1) + " " + (matched[i] + 1));
    }

    static class Pair implements Comparable<Pair>
    {
        int idx, x, y;

        public Pair(int idx, int x, int y)
        {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair p)
        {
            if(this.y == p.y)
                return this.x - p.x;
            return this.y - p.y;
        }
    }
}