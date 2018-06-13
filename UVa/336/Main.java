//336
//A node to far

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main
{

    static int ttl, unreachable;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static void bfs(int start, int n)
    {
        distance = new int[n];
        visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        unreachable--;
        while(!queue.isEmpty())
        {
            int cur = queue.poll();
            for(int nxt : adjList[cur])
            {
                if(!visited[nxt])
                {
                    queue.add(nxt);
                    visited[nxt] = true;
                    distance[nxt] = distance[cur] + 1;
                    if(distance[nxt] <= ttl) unreachable--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = 1;
        
        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            adjList = new ArrayList[n * 2];
            for(int i = 0; i < n * 2; i++)
                adjList[i] = new ArrayList<>();

            int count = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int i = 0; i < n; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int aa, bb;

                if(map.containsKey(a))
                    aa = map.get(a);
                else
                {
                    aa = count++;
                    map.put(a, aa);
                }

                if(map.containsKey(b))
                    bb = map.get(b);
                else
                {
                    bb = count++;
                    map.put(b, bb);
                }

                adjList[aa].add(bb);
                adjList[bb].add(aa);
            }

            while(true)
            {
                int start = sc.nextInt();
                ttl = sc.nextInt();
                unreachable = map.size();

                if(start == 0 && ttl == 0) break;

                if(map.get(start) != null)
                    bfs(map.get(start), n * 2);
                pw.println("Case " + (t++) + ": " + unreachable + " nodes not reachable from node " + start + " with TTL = " + ttl + ".");
            }
        }

        pw.flush();
        pw.close();
    }
}
