//11284
//Shopping Trip

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static double[][] memo;
    static double[][] distance;
    static ArrayList<Edge> diff;
    static ArrayList<Edge>[] adjList;

    public static void dijkstra(int start)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        Arrays.fill(distance[start], Double.MAX_VALUE);

        while(!pq.isEmpty())
        {
            Edge cur = pq.poll();
            if(cur.cost > distance[start][cur.node]) continue;
            for(Edge nxt : adjList[cur.node])
            {
                if(nxt.cost + cur.cost < distance[start][nxt.node])
                {
                    distance[start][nxt.node] = nxt.cost + cur.cost;
                    pq.add(new Edge(nxt.node, distance[start][nxt.node]));
                }
            }
        }
    }

    public static boolean visited(int idx, int mask)
    {
        return ((1 << idx) & mask) == (1 << idx);
    }

    public static double dp(int cur, int mask)
    {
        if(mask + 1 == 1 << diff.size())
            return - distance[cur][0];

        if(memo[cur][mask] != Double.MIN_VALUE)
            return memo[cur][mask];

        double max = - distance[cur][0];
        for(int i = 0; i < diff.size(); i++)
        {
            if(visited(i, mask))
                continue;
            Edge tmp = diff.get(i);
            max = Math.max(max, tmp.cost - distance[cur][tmp.node] + dp(tmp.node, mask | (1 << i)));
        }

        return memo[cur][mask] = max;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            n = sc.nextInt() + 1;
            int m = sc.nextInt();

            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < m; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                double c = sc.nextDouble();
                adjList[a].add(new Edge(b, c));
                adjList[b].add(new Edge(a, c));
            }

            distance = new double[n][n];        
            for(int i = 0; i < n; i++)
                dijkstra(i);

            int p = sc.nextInt();
            diff = new ArrayList<>();
            loop : for(int i = 0; i < p; i++)
            {
                int a = sc.nextInt();
                double c = sc.nextDouble();
                for(int j = 0; j < diff.size(); j++)
                {
                    Edge tmp = diff.get(j);
                    if(tmp.node == a)
                    {
                        tmp.cost += c;
                        continue loop;
                    }
                }
                diff.add(new Edge(a, c));
            }

            memo = new double[n][1 << p];
            for(double[] x : memo)
                Arrays.fill(x, Double.MIN_VALUE);

            double ans = dp(0, 0);
            if(ans < 1e-9)
                pw.println("Don't leave the house");
            else
                pw.printf("Daniel can save $%.2f\n", ans);
        }

        pw.flush();
        pw.close();
    }

    static class Edge implements Comparable<Edge>
    {
        int node;
        double cost;

        public Edge(int node, double cost)
        {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Edge e)
        {
            if(Math.abs(this.cost - e.cost) < 1e-9)
                return this.node - e.node;
            return this.cost < e.cost ? -1 : 1;
        }
    }    
}
