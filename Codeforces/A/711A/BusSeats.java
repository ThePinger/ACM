import java.util.*;

public class BusSeats
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int n = sc.nextInt();
    char[][] seats = new char[n][n];
    for(int i = 0 ; i < n ; i++)
       seats[i] = sc.next().toCharArray();

    boolean f = false;
    for(int i = 0 ; i < n ; i++)
       if(seats[i][0] == 'O' && seats[i][1] == 'O')
       {
         seats[i][0] = '+';
         seats[i][1] = '+';
         f = true;
         break;
       }
       else if(seats[i][3] == 'O' && seats[i][4] == 'O')
       {
         seats[i][3] = '+';
         seats[i][4] = '+';
         f = true;
         break;
       }

    if(f) sb.append("YES\n");
    else sb.append("NO\n");

    if(f)
    {
        for(int i = 0 ; i < n ; i++)
        {
           for(int j = 0 ; j < 5 ; j++)
              sb.append(seats[i][j]);

           sb.append("\n");
        }
    }
    System.out.print(sb);
  }
}
