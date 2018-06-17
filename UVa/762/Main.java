//762
//We Ship Cheap

import java.io.*;
import java.util.*;

public class Main
{

    static int start, destination;
    static int[] distance, parent;
    static String[] locations;
    static boolean[] visited;
    static TreeMap<String, Integer> map;
    static ArrayList<Integer>[] adjList;
    static PrintWriter pw = new PrintWriter(System.out);

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
                    parent[nxt] = cur;
                    distance[nxt] = distance[cur] + 1;
                }
            }
        }
    }

    public static String printPath(int cur)
    {
        if(cur == start) return locations[cur];
        String s = printPath(parent[cur]);
        pw.println(s + " " + locations[cur]);
        return locations[cur];
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        
        while(sc.hasNext())
        {
            int n = sc.nextInt();

            if(t++ != 1) pw.println();

            map = new TreeMap<>();
            locations = new String[n * 2];
            adjList = new ArrayList[n * 2];
            for(int i = 0; i < n * 2; i++)
                adjList[i] = new ArrayList<>();

            int count = 0;
            for(int i = 0; i < n; i++)
            {
                String a = sc.next();
                String b = sc.next();
                int aa, bb;

                if(map.containsKey(a))
                    aa = map.get(a);
                else
                {
                    aa = count++;
                    map.put(a, aa);
                    locations[aa] = a;
                }

                if(map.containsKey(b))
                    bb = map.get(b);
                else
                {
                    bb = count++;
                    map.put(b, bb);
                    locations[bb] = b;
                }

                adjList[aa].add(bb);
                adjList[bb].add(aa);
            }

            String a = sc.next();
            String b = sc.next();
            if(!map.containsKey(a) || ! map.containsKey(b))
                pw.println("No route");
            else
            {
                start = map.get(a);
                destination = map.get(b);
                visited = new boolean[n * 2];
                parent  = new int[n * 2];
                distance = new int[n * 2];
                unweightedSSSP(start);
                if(distance[destination] == 0)
                    pw.println("No route");
                else
                    printPath(destination);
            }
        }

        pw.flush();
        pw.close();
    }
}