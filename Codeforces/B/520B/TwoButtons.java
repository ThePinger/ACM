//520B
//TwoButtons

import java.util.*;

public class TwoButtons
{

    static int m;
    static int[] dist;

    public static int unweightedSSSP(int start)
    {
        dist = new int[20001];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty())
        {
            int cur = queue.poll();
            if(cur == m) return dist[cur];
            if(cur > m)
            {
                if(dist[cur - 1] == -1)
                {
                    queue.add(cur - 1);
                    dist[cur - 1] = 1 + dist[cur];
                }
            }
            else if(cur == 1)
            {
                if(dist[cur * 2] == -1)
                {
                    queue.add(cur * 2);
                    dist[cur * 2] = 1 + dist[cur];
                }
            }
            else
            {
                if(dist[cur - 1] == -1)
                {
                    queue.add(cur - 1);
                    dist[cur - 1] = 1 + dist[cur];
                }

                if(dist[cur * 2] == -1)
                {
                    queue.add(cur * 2);
                    dist[cur * 2] = 1 + dist[cur];
                } 
            }
        }

        return 0;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(unweightedSSSP(n));
    }
}