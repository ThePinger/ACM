//381B
//SerejaAndStairs

import java.util.*;

public class SerejaAndStairs
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(n-->0)
            pq.add(sc.nextInt());
            
        Stack<Integer> duplicates = new Stack<>();
        Queue<Integer> order = new LinkedList<>();
        int last = 0;
        while(!pq.isEmpty())
        {
            int tmp = pq.poll();
            if(last == tmp)
                duplicates.push(tmp);
            else
            {
                order.add(tmp);
                last = tmp;
            }
        }

        while(!duplicates.isEmpty())
        {
            int tmp = duplicates.pop();
            if(last == tmp) continue;
            order.add(tmp);
            last = tmp;
        }

        System.out.println(order.size());
        while(!order.isEmpty())
            System.out.print(order.poll() + " ");
    }
}