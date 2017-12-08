//490A
//TeamOlympiad

import java.util.*;

public class TeamOlympiad
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    Queue<Integer> programming = new LinkedList<>();
    Queue<Integer> maths       = new LinkedList<>();
    Queue<Integer> pe          = new LinkedList<>();

    for(int i = 1 ; i < n + 1 ; i++)
    {
      int input = sc.nextInt();
      switch(input)
      {
        case 1 : programming.add(i); break;
        case 2 : maths.add(i)      ; break;
        case 3 : pe.add(i)         ; break;
      }
    }

    int teams = 0;
    while(!programming.isEmpty() && !maths.isEmpty() && !pe.isEmpty())
    {
      sb.append(programming.remove() + " " + maths.remove() + " " + pe.remove() + "\n");
      teams++;
    }

    System.out.println(teams);
    System.out.print(sb);
  }
}
