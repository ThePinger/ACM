
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
public class C
{
  static ArrayList<Integer>[] adjList;
  static boolean[] visited;
  static double routes;
  public static double dfs(int cur)
  {
    visited[cur] = true;
    int tot = 0;
    double distance = 0;
    for(int nxt : adjList[cur])
    {
      if(!visited[nxt])
      {
        distance += 1 + dfs(nxt) ;
        tot++;
      }
    }
    if(tot != 0)
      distance /= tot;
    return distance;
  }
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(br.readLine());
    adjList = new ArrayList[n];
    visited = new boolean[n];
    for(int i = 0 ; i < n ; i++)
      adjList[i] = new ArrayList<>();
    for(int i = 0 ; i < n  - 1; i++)
    {
      String[] s = br.readLine().split(" ");
      int first = Integer.parseInt(s[0]) - 1;
      int second = Integer.parseInt(s[1])- 1;
      adjList[first].add(second);
      adjList[second].add(first);
    }
    DecimalFormat df = new DecimalFormat("0.000000000000000");
    System.out.println(df.format(dfs(0)));
  }
}
