//10935
//Throwing Cards

import java.util.*;

public class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    while(true)
    {
       int n = sc.nextInt();
       if(n == 0)
         break;

       Queue <Integer> deck = new LinkedList<>();
       for(int i = 1 ; i <= n ; i++)
         deck.add(i);

       Queue<Integer> discarded = new LinkedList<>();
       while(deck.size() > 1)
       {
         discarded.add(deck.remove());
         deck.add(deck.remove());
       }

       sb.append("Discarded cards:");
       while(!discarded.isEmpty())
       {
         int tmp = discarded.remove();
         if(!discarded.isEmpty())
           sb.append(" " + tmp + ",");
         else
           sb.append(" " + tmp);
       }

       sb.append("\nRemaining card: " + deck.remove() + "\n");
    }
    System.out.print(sb);
  }
}
