//218B
//Airport

import java.util.*;

public class Airport
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int passengers = sc.nextInt();
        int planes     = sc.nextInt();
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        while(planes-->0)
        {
            int tmp = sc.nextInt();
            min.add(tmp);
            max.add(tmp);
        }

        int minAns = 0;
        int maxAns = 0;
        while(passengers-->0)
        {
            int tmp = min.poll();
            minAns += tmp;
            if(tmp > 1) min.add(tmp - 1);

            tmp = max.poll();
            maxAns += tmp;
            if(tmp > 1) max.add(tmp - 1);
        }

        System.out.println(maxAns + " " + minAns);
    
    }
}