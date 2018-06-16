//383
//Shipping Routes

import java.io.*;
import java.util.*;

public class Main
{

    static int[] distance, parent;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;

    public static void unweightedSSSP(int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
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
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("SHIPPING ROUTES OUTPUT");
        pw.println();

        int t = sc.nextInt();
        for(int c = 1; c <= t; c++)
        {
            pw.println("DATA SET  " + c);
            pw.println();

            int n = sc.nextInt();
            int m = sc.nextInt();
            int r = sc.nextInt();

            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            TreeMap<String, Integer> map = new TreeMap<>();
            for(int i = 0; i < n; i++)
                map.put(sc.next(), i);

            for(int i = 0; i < m; i++)
            {
                int a = map.get(sc.next());
                int b = map.get(sc.next());
                adjList[a].add(b);
                adjList[b].add(a);
            }

            while(r-->0)
            {
                distance = new int[n];
                visited = new boolean[n];
                int shipment = sc.nextInt();
                int start = map.get(sc.next());
                int destination = map.get(sc.next());
                unweightedSSSP(start);
                if(distance[destination] == 0)
                    pw.println("NO SHIPMENT POSSIBLE");
                else
                    pw.println("$" + (shipment * distance[destination] * 100));
            }

            pw.println();
        }
        
        pw.println("END OF OUTPUT");
        pw.flush();
        pw.close();
    }
}