//621A
//Wet Shark Even and Odd

import java.util.*;

public class WetSharkEvenOdd
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> odds = new PriorityQueue(Collections.reverseOrder());
        long ans = 0;

        while(n-->0)
        {
            int input = sc.nextInt();
            if(input % 2 == 0)
                ans += input;
            else
                odds.add(input);
        }

        while(odds.size() > 1)
            ans += odds.poll() + odds.poll();

        System.out.println(ans);
    }
}