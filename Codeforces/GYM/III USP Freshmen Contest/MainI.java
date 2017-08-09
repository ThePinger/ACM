import java.io.*;
import java.util.*;

public class MainI
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int i = 0 ; i < n ; i++)
    {
      int team1 = sc.nextInt();
      int team2 = sc.nextInt();
      if(team1 == team2 || Math.abs(team1-team2) == 1)
        System.out.println("Ok");
      else
      {
        int team = team1 + team2;
        if(team % 2 == 0)
          System.out.println((team/2) + " " + (team/2));
        else
          System.out.println((team/2) + " " + ((team/2) + 1));
      }
    }
  }
}
