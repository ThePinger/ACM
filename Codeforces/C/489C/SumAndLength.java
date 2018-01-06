//489C
//Given Sum and Length

import java.util.*;

public class SumAndLength
{

    static int sum, length;
    static String maxS = "" , minS = "";


    public static void calculateMax()
    {
        int rem = sum;
        while(maxS.length() != length)
        {
            if(rem >= 9)
            {
                maxS += 9;
                rem -= 9;
            }
            else
            {
                maxS += rem;
                rem = 0;
            }
        }
    }

    public static void calculateMin()
    {
        int zeros = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < maxS.length(); i++)
        {
            int tmp = Character.getNumericValue(maxS.charAt(i));
            if(tmp != 0)
                queue.add(tmp);
            else
                zeros++;
        }

        if(queue.peek() > 1 && zeros > 0)
        {
            queue.add(queue.remove() - 1);
            zeros--;
            minS += 1;
            while(zeros-->0)
                minS += 0;
        }
        else
        {
            minS += queue.remove();
            while(zeros-->0)
                minS += 0;
        }

        while(!queue.isEmpty())
            minS += queue.remove();
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        sum    = sc.nextInt();
        
        if(sum == 0)
        {
            if(length == 1)
                System.out.println("0 0");
            else
                System.out.println("-1 -1");
            return;
        }

        if((9*length) < sum)
        {
            System.out.println("-1 -1");
            return;
        }

        calculateMax();
        calculateMin();
        System.out.println(minS + " " + maxS);

    }
}