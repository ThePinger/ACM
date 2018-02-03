//277A
//Learing Languages

import java.util.*;

public class LearnLanguages
{
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;    
    static ArrayList<Integer>[] languageSpeakers;
    static ArrayList<Integer>[] employeeLanguages;

    public static void dfs(int cur)
    {
        visited[cur] = true;
        for(int nxt : adjList[cur])
            if(!visited[nxt])
                dfs(nxt);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        languageSpeakers = new ArrayList[m + 1];
        employeeLanguages = new ArrayList[n + 1];

        for(int i = 0; i < n + 1; i++)
            employeeLanguages[i] = new ArrayList<>();

        for(int i = 0; i < m + 1; i++)
            languageSpeakers[i] = new ArrayList<>();

        for(int i = 0; i < n + 1; i++)
            adjList[i] = new ArrayList<>();

        int zeros = 0;
        for(int i = 1; i < n + 1; i++)
        {
            int lang = sc.nextInt();
            if(lang == 0) zeros++;
            while(lang-->0)
            {
                int tmp = sc.nextInt();
                languageSpeakers[tmp].add(i);
                employeeLanguages[i].add(tmp);
            }
        }

        for(int i = 1; i < n + 1; i++)
            for(int nxtLang : employeeLanguages[i])
                for(int node : languageSpeakers[nxtLang])
                    if(node != i)
                        adjList[i].add(node);

        int ans = 0;
        for(int i = 1; i < n + 1; i++)
            if(!visited[i])
            {
                dfs(i);
                ans++;
            }

        if(zeros == n) System.out.println(n);
        else System.out.println(ans - 1);
    }
}