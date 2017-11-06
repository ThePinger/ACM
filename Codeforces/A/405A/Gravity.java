//405A
//GravityFlip

import java.util.Scanner;
import java.util.PriorityQueue;

public class Gravity
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    while(n-->0)
      pq.add(sc.nextInt());

    while(!pq.isEmpty())
      System.out.print(pq.remove() + " ");
  }
}
