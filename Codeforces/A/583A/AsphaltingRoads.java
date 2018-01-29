//583A
//AsphaltingRoads

import java.util.*;

public class AsphaltingRoads
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] horizontal = new boolean[n + 1];
        boolean[] vertical   = new boolean[n + 1];
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < n * n; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(horizontal[x] || vertical[y]) continue; 
            
            set.add(i + 1);
            horizontal[x] = vertical[y] = true;
        }

        while(!set.isEmpty())
            System.out.print(set.pollFirst() + " ");
        
        System.out.println();
    }
}