//540

import java.io.*;
import java.util.*;

public class Main
{
  static int[][] teams;
  static boolean[] inQueue;
  static Queue<Integer> team;
  static Queue<Integer>[] teamQueue;

  public static void add(int member)
  {
      int teamNum = getTeam(member);
      if(inQueue[teamNum])
        teamQueue[teamNum].add(member);
      else
      {
        inQueue[teamNum] = true;
        team.add(teamNum);
        teamQueue[teamNum].add(member);
      }
  }

  public static int getTeam(int member)
  {
    for(int i = 0 ; i < teams.length ; i++)
      for(int mem : teams[i])
         if(mem == member)
           return i;
    return -1;
  }

  public static int get()
  {
    int teamNum = team.peek();
    if(teamQueue[teamNum].size() == 1)
    {
      inQueue[teamNum] = false;
      team.remove();
    }
    return teamQueue[teamNum].remove();
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int c = 1;
    while(true)
    {
      int n = Integer.parseInt(br.readLine());
      if(n == 0)
        break ;

      sb.append("Scenario #" + c + "\n");
      teams = new int [n][1000];
      inQueue = new boolean[n];
      team = new LinkedList<>();
      teamQueue = new Queue[n];
      for(int i = 0 ; i < n ; i++)
         teamQueue[i] = new LinkedList<>();
      for(int i = 0 ; i < n ; i++)
      {
         StringTokenizer st = new StringTokenizer(br.readLine());
         int size = Integer.parseInt(st.nextToken());
         for(int j = 0 ; j < size ; j++)
           teams[i][j] = Integer.parseInt(st.nextToken());
      }

      String[] s = br.readLine().split(" ");
      while(!s[0].equals("STOP"))
      {
         if(s.length == 1)
           sb.append(get() + "\n");
         else
           add(Integer.parseInt(s[1]));
         s = br.readLine().split(" ");
      }
      sb.append("\n");
      c++;
    }
    System.out.print(sb);
  }
}
