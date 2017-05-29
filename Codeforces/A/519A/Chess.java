//519 A
import java.util.Scanner;
import java.lang.Character;
public class Chess
{
  public static String larger(char [][] board)
  {
    int white = 0;
    int black = 0;
    for(int i = 0 ; i < 8 ; i++)
    {
      for(int j = 0 ; j < 8 ; j++)
      {
        char c = board[i][j];
        if(c != '.')
        {
          if(Character.isUpperCase(c))
          {
            int value = state(Character.toLowerCase(c));
            white = white + value;
          }
          else
          {
            int value = state(Character.toLowerCase(c));
             black = black + value;
          }
        }
      }
    }
    if(black == white)
       return "Draw";
    else if(black > white)
       return "Black";
    else
       return "White";
  }

  public static int state(char i)
  {
    switch(i)
    {
      case 'q': return 9;
      case 'r': return 5;
      case 'b': return 3;
      case 'n': return 3;
      case 'p': return 1;
    }
    return 0 ;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    char [][] board = new char[8][8];
    for(int i = 0 ; i < 8 ; i++)
    {
      String b = sc.next();
      for(int j = 0 ; j < 8 ; j++)
      {
        board[i][j] = b.charAt(j);
      }
    }
    System.out.println(larger(board));
  }
}
