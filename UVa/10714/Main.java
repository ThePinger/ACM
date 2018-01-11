//10714
//Ants

import java.io.*;
import java.util.*;

public class Main 
{

    static int[] position;
    static int distance;

    public static int getMinDistance()
    {
        int ans = 0;
        for(int i = 0; i < position.length; i++)
            ans = Math.max(ans, Math.min(position[i], distance - position[i]));
        
        return ans;
    }

    public static int getMaxDistance()
    {
        int ans = 0;
        for(int i = 0; i < position.length; i++)
            ans = Math.max(ans, Math.max(position[i], distance - position[i]));
        
        return ans;
    }

    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder  sb = new StringBuilder();
        int n = sc.nextInt();

        while(n-->0)
        {
            distance = sc.nextInt();
            int ants = sc.nextInt();
            position = new int[ants];
            
            for(int i = 0; i < ants; i++)
                position[i] = sc.nextInt();
            
            Arrays.sort(position);
            sb.append(getMinDistance() + " " + getMaxDistance() + "\n");
        }
        System.out.print(sb);
    }
}