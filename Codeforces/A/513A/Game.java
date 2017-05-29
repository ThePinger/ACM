//513 A
import java.util.Scanner;
public class Game
{
  public static String game(int [] c)
  {
    int [] playerOne = new int[2];
    int [] playerTwo = new int[2];
    playerOne[0] = c[0];
    playerOne[1] = c[2];
    playerTwo[0] = c[1];
    playerTwo[1] = c[3];
    boolean turn = true;
    boolean game = true;

    while(game)
    {
      if(turn)
      {
        if(playerOne[0] == 1)
          return "Second";
        else
        {
          playerOne[0]--;
          turn = false;
        }
      }
      if(!turn)
      {
        if(playerTwo[0] == 1)
          return "First";
        else
        {
          playerTwo[0]--;
          turn = true;
        }
      }
    }
    return null;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int [] c = new int [4];
    for(int i = 0 ; i < 4 ; i++)
    {
      c[i] = sc.nextInt();
    }
    System.out.println(game(c));
  }
}
