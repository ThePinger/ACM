//627
//TheNet

import java.io.*;
import java.util.*;

public class Main
{

    static int start, destination;
    static int[] distance, parent;
    static boolean[] visited;
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

    public static void printPath(int cur)
    {
        if(cur != start) 
            printPath(parent[cur]);
        if(cur == destination)
            pw.println(cur + 1);
        else
            pw.print(cur + 1 + " ");
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext())
        {
            int n = sc.nextInt();

            //if(n == 0) break;

            pw.println("-----");

            adjList = new ArrayList[n];
            for(int i = 0; i < n; i++)
                adjList[i] = new ArrayList<>();

            for(int i = 0; i < n; i++)
            {
                String[] line = sc.next().split(",");
                String first = "";
                String second = "";
                boolean dashFound = false;
                for(int j = 0; j < line[0].length(); j++)
                {
                    if(line[0].charAt(j) == '-')
                        dashFound = true;
                    else if(dashFound)
                        second += line[0].charAt(j);
                    else 
                        first  += line[0].charAt(j);
                }

                int a = Integer.parseInt(first) - 1;
                if(!second.equals(""))
                {
                    int b = Integer.parseInt(second) - 1;
                    adjList[a].add(b);
                }
                for(int j = 1; j < line.length; j++)
                        adjList[a].add(Integer.parseInt(line[j]) - 1);
            }

            int m = sc.nextInt();
            while(m-->0)
            {
                visited = new boolean[n];
                parent  = new int[n];
                distance = new int[n];
                start = sc.nextInt() - 1;
                destination = sc.nextInt() - 1;
                unweightedSSSP(start);
                if(distance[destination] == 0)
                    pw.println("connection impossible");
                else
                    printPath(destination);
            }
        }

        pw.flush();
        pw.close();
    }
}