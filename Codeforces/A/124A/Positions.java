//124A
import java.util.Scanner;

public class Positions
{
  public static int numPositions(int people , int front , int back)
  {
    if( (front + back) == people)
      return back;
    else if((front+back) >= people)
      return people - front;
    else
      return back + 1;
  }

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int people = sc.nextInt();
    int front = sc.nextInt();
    int back = sc.nextInt();
    System.out.println(numPositions(people , front , back));
  }
}
