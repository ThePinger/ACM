//978
//Lemmings Battle

import java.util.*;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int fields = sc.nextInt();
            int greens = sc.nextInt();
            int blues  = sc.nextInt();
            PriorityQueue<Integer> greenAlive = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> blueAlive  = new PriorityQueue<>(Collections.reverseOrder());

            while(greens-->0)
                greenAlive.add(sc.nextInt());
            
            while(blues-->0)
                blueAlive.add(sc.nextInt());

            while(!greenAlive.isEmpty() && !blueAlive.isEmpty())
            {
                int cnt = 0;
                Queue<Integer> blueWinner = new LinkedList<>();
                Queue<Integer> greenWinner = new LinkedList<>();
                while(!greenAlive.isEmpty() && !blueAlive.isEmpty() && cnt < fields)
                {
                    int g = greenAlive.poll();
                    int b = blueAlive.poll();
                    if(g > b)
                        greenWinner.add(g - b);
                    else if(b > g)
                        blueWinner.add(b - g);
                    cnt++;
                }

                while(!greenWinner.isEmpty())
                    greenAlive.add(greenWinner.poll());

                while(!blueWinner.isEmpty())
                    blueAlive.add(blueWinner.poll());
            }

            if(greenAlive.isEmpty() && blueAlive.isEmpty())
                System.out.println("green and blue died");
            else if(!greenAlive.isEmpty())
            {
                System.out.println("green wins");
                while(!greenAlive.isEmpty())
                    System.out.println(greenAlive.poll());
            }
            else
            {
                System.out.println("blue wins");
                while(!blueAlive.isEmpty())
                    System.out.println(blueAlive.poll());
            }

            if(t != 0)
                System.out.println();
        }
    }
}