//519C
//TeamTraining

import java.util.Scanner;

public class Teams
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int exp = sc.nextInt();
    int neb = sc.nextInt();
    int teams = 0;
    while(exp + neb > 2 && exp > 0 && neb > 0)
    {
      if(exp > neb)
      {
        exp -= 2;
        neb -= 1;
      }
      else
      {
        neb -= 2;
        exp -= 1;
      }
      teams++;
    }
    System.out.println(teams);
  }
}
