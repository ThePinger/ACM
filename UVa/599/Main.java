//599
//The Forrest of Trees

import java.io.*;
import java.util.ArrayList;

public class Main 
{
    static ArrayList<Integer>[] adjList;
    static boolean[] vis;

    public static int dfs(int i)
    {
        if(adjList[i].size() == 0)
            return 0;
            
        vis[i] = true;
        int v = 0;
        for(int e : adjList[i])
            if(!vis[e])
                v += 1 + dfs(e);
                
        return v;
    }

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0)
        {
            int trees  = 0;
            int acrons = 0;
            adjList = new ArrayList[26];
            vis = new boolean[26];

            for(int i = 0; i < 26; i++)
                adjList[i] = new ArrayList<>();

            while(true)
            {
                String[] s = br.readLine().split(",");
                if(s.length == 1) break;
                
                adjList[s[0].charAt(1) - 'A'].add(s[1].charAt(0) - 'A');
                adjList[s[1].charAt(0) - 'A'].add(s[0].charAt(1) - 'A');   
            }

            for(int i = 0; i < 26; i++)
                if(dfs(i) > 0)
                    trees++;

            String[] s = br.readLine().split(",");
            for(int i = 0; i < s.length; i++)
                if(!vis[s[i].charAt(0) - 'A'])
                    acrons++;

            pw.println("There are " + trees + " tree(s) and " + acrons + " acorn(s).");
        }

        pw.flush();
        pw.close();
    }
}