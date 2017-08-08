//158B
//School Queue

import java.util.Scanner;

public class SchoolQ
{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int seconds = sc.nextInt();
    String q = sc.next();
    boolean[] queue = new boolean[n];
    for(int i = 0 ; i < n ; i++)
       if(q.charAt(i) == 'B')
         queue[i] = true;
       else
         queue[i] = false;
    while(seconds-- > 0)
    {
      for(int i = 0 ; i < n - 1 ; i++)
         if(queue[i] && !queue[i+1])
         {
           boolean f = queue[i+1];
           queue[i+1] = queue[i];
           queue[i] = f;
           i++;
         }
    }
    for(int i = 0 ; i < n ; i++)
       if(queue[i])
         System.out.print("B");
       else
         System.out.print("G");
  }
}
