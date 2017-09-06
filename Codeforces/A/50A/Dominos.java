//50A
//Domino Pilling

import java.util.Scanner;
public class Dominos
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int l = sc.nextInt();
    int w = sc.nextInt();
    int squares = l * w;
    System.out.println(squares / 2);
  }
}
