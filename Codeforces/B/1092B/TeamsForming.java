//1092B
//TeamsForming

import java.util.*;

public class TeamsForming
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(n-->0) pq.add(sc.nextInt());

        int ans = 0;
        while(!pq.isEmpty())
            ans += Math.abs(pq.poll() - pq.poll());

        System.out.println(ans);
    }
}