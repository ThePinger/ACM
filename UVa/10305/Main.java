//10305
//Ordering Tasks
//Topological Sort 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main
{

    static boolean[] visited;
    static Stack<Integer> stack;
    static ArrayList<Integer>[] adjList;

    public static void dfs(int i)
    {
        visited[i] = true;
        for(int nxt : adjList[i])
            if(!visited[nxt])
                dfs(nxt);
        stack.push(i);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        while(true)
        {
            int n = sc.nextInt();
            int e = sc.nextInt();

            if(n == 0) break;

            stack = new Stack<>();
            visited = new boolean[n + 1];
            adjList = new ArrayList[n + 1];
            for(int i = 0; i < n + 1; i++)
                adjList[i] = new ArrayList<>();

            while(e-->0)
                adjList[sc.nextInt()].add(sc.nextInt());

            for(int i = 1; i < n + 1; i++)
                if(!visited[i])
                    dfs(i);

            while(!stack.isEmpty())
            {
                if(stack.size() == 1) pw.print(stack.pop());
                else pw.print(stack.pop() + " ");
            }

            pw.println();
        }

        pw.flush();
        pw.close();
    }
}