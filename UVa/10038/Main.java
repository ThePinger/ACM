//10038
//Jolly Jumpers

import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = 1;
        
        while(sc.hasNext())
        {
            if(t > 1) sb.append("\n");

            int n = sc.nextInt();            
            boolean[] visited = new boolean[n];
            int[] numbers = new int[n];
            for(int i = 0; i < n; i++)
                numbers[i] = sc.nextInt();
            
            for(int i = 0; i < n - 1; i++)
                if(Math.abs(numbers[i] - numbers[i + 1]) < n)
                    visited[Math.abs(numbers[i] - numbers[i + 1])] = true;

            boolean f = true;
            for(int i = 1; i < n && f; i++)
                if(!visited[i])
                    f = false;
            
            if(f) sb.append("Jolly");
            else sb.append("Not jolly");
            t++;
        }

        System.out.println(sb);
    }
}