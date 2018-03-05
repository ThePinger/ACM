//450A
//Jzzhu and Children

import java.util.*;

public class JzzhuChildren
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] candiesNeeded = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < candiesNeeded.length; i++)   
        {
            candiesNeeded[i] = sc.nextInt();
            queue.add(i);
        } 

        int last = -1;
        while(!queue.isEmpty())
        {
            last = queue.remove();
            if(candiesNeeded[last] > m)
            {
                candiesNeeded[last] -= m;
                queue.add(last);
            }
        }
        System.out.println(last);
    }
}