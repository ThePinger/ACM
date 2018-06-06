//10731
//Test

import java.io.*;
import java.util.*;

public class Main
{

    static int dfsCounter, scc;
    static int[] dfs_num, dfs_low;
    static boolean[] visited, inStack;
    static Stack<Integer> stack;
    static PriorityQueue<String> output;
    static ArrayList<Integer>[] adjList;

    public static void tarjanSCC(int cur)
    {
        stack.push(cur);
        visited[cur] = true;
        inStack[cur] = true;
        dfs_num[cur] = dfs_low[cur] = dfsCounter++;

        for(int nxt : adjList[cur])
        {
            if(!visited[nxt])
            {
                tarjanSCC(nxt);
                dfs_low[cur] = Math.min(dfs_low[cur], dfs_low[nxt]);
            }
            else if(inStack[nxt])
                dfs_low[cur] = Math.min(dfs_low[cur], dfs_num[nxt]);            
        }

        if(dfs_num[cur] == dfs_low[cur])
        {
            scc++;
            PriorityQueue<Character> pq = new PriorityQueue<>();
            while(true)
            {
                int child = stack.pop();
                inStack[child] = false;
                pq.add((char) (child + 'A'));
                if(cur == child) break;
            }

            String ans = "";
            while(!pq.isEmpty())
            {
                if(pq.size() == 1)
                    ans += pq.poll();
                else 
                    ans += pq.poll() + " ";
            }

            output.add(ans);
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

            if(t++ != 1) pw.println();

            scc = 0;
            dfsCounter = 0;
            dfs_num = new int[26];
            dfs_low = new int[26];
            visited = new boolean[26];
            inStack = new boolean[26];
            stack   = new Stack<>();
            output  = new PriorityQueue<>();
            adjList = new ArrayList[26];

            for(int i = 0; i < 26; i++)
                adjList[i] = new ArrayList<>();

            boolean[] input = new boolean[26];
            for(int i = 0; i < n; i++)
            {
                char[] line = new char[5];
                for(int j = 0; j < 5; j++)
                {
                    line[j] = sc.next().charAt(0);
                    input[line[j] - 'A'] = true;
                }
                
                char choice = sc.next().charAt(0);
                for(int j = 0; j < 5; j++)
                    if(choice != line[j])
                        adjList[choice - 'A'].add(line[j] - 'A');
            }

            for(int i = 0; i < 26; i++)
                if(!visited[i] && input[i])
                    tarjanSCC(i);

            while(!output.isEmpty())
                pw.println(output.poll());
        }

        pw.flush();
        pw.close();
    }
}