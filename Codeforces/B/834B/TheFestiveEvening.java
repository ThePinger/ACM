//834B
//TheFestiveEvening

import java.util.*;

public class TheFestiveEvening
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int guards = sc.nextInt();
        char[] order = sc.next().toCharArray();
        
        int[] last = new int[26];
        for(int i = 0; i < n; i++)
            last[order[i] - 'A'] = i;

        boolean flag = false;
        boolean[] opened = new boolean[26];
        for(int i = 0; i < n; i++)
        {
            if(opened[order[i] - 'A'])
            {
                if(last[order[i] - 'A'] == i)
                    guards++;
                continue;
            }

            opened[order[i] - 'A'] = true;
            guards--;
            if(guards < 0) flag = true;
            if(last[order[i] - 'A'] == i) guards++;
        }

        System.out.println(flag ? "YES" : "NO");
    }
}