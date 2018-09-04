//460B
//LittleDimaEquation

import java.util.*;

public class LittleDimaEquation
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 1; i <= 81; i++)
        {
            long x = (b * (long) Math.pow(i, a)) + c;
            if(x < 1 || x >= 1000000000) continue;

            int sum = 0;
            String tmp = x + "";
            for(int j = 0; j < tmp.length(); j++)
                sum += Character.getNumericValue(tmp.charAt(j));

            if(sum == i) pq.add(x);
        }

        System.out.println(pq.size());
        while(!pq.isEmpty())
            System.out.print(pq.poll() + " ");

    }
}