//200
//RareOrder

import java.io.*;
import java.util.*;

public class Main
{

    static boolean[] visited;
    static Stack<Integer> topoSort;
    static ArrayList<Integer>[] adjList;

    public static void dfsTopoSort(int cur)
    {
        visited[cur] = true;
        for(int nxt : adjList[cur])
            if(!visited[nxt])
                dfsTopoSort(nxt);
        topoSort.push(cur);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);  

        while(sc.hasNext())
        {
            ArrayList<String> strings = new ArrayList<>();
            while(true)
            {
                String line = sc.next();
                if(line.equals("#")) break;
                strings.add(line);
            }

            visited = new boolean[26];
            topoSort = new Stack<>();
            adjList = new ArrayList[26];

            for(int i = 0; i < 26; i++)
                adjList[i] = new ArrayList<>();

            TreeSet<Integer> chars = new TreeSet<>();
            for(int i = 0; i < strings.size(); i++)
            {
                String cur = strings.get(i);
                loop : for(int j = i + 1; j < strings.size(); j++)
                {
                    String nxt = strings.get(j);
                    for(int k = 0; k < Math.min(cur.length(), nxt.length()); k++)
                    {
                        if(cur.charAt(k) != nxt.charAt(k))
                        {
                            adjList[cur.charAt(k) - 'A'].add(nxt.charAt(k) - 'A');
                            break loop;
                        }
                        chars.add(cur.charAt(k) - 'A');
                        chars.add(nxt.charAt(k) - 'A');
                    }
                }
            }

            while(!chars.isEmpty())
            {
                int tmp = chars.pollFirst();
                if(!visited[tmp])
                    dfsTopoSort(tmp);
            }

            while(!topoSort.isEmpty())
                pw.print((char) (topoSort.pop() + 'A'));
            pw.println();
        }

        pw.flush();
        pw.close();
    }
}
