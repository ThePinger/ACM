//279B
//Books

import java.util.*;

public class Books
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int books = sc.nextInt();
        int time  = sc.nextInt();
        int[] timeNeeded = new int[books];

        for(int i = 0; i < books; i++)
            timeNeeded[i] = sc.nextInt();
        
        int start = 0;
        int cur   = 0;
        int max   = 0;
        int curBooks = 0;
        int sum   = 0;

        while(cur < books)
        {
            if(timeNeeded[cur] + sum > time)
            {
                if(curBooks > max)
                    max = curBooks;
                sum -= timeNeeded[start];
                curBooks--;
                start++;
            }
            else
            {
                sum += timeNeeded[cur];
                cur++;
                curBooks++;
            }
        }

        if(curBooks > max)
            max = curBooks;

        System.out.println(max);
    }
}