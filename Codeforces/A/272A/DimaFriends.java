//272A
//Dima and Friends

import java.util.*;

public class DimaFriends
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1;
        int sum = 0;
        for(int i = 0; i < n - 1; i++) sum += sc.nextInt();
        
        int ways = 0;
        int coun = 1;
        while(coun < 6)
        {
            if((sum + coun) % n != 1)
                ways++;
            coun++;
        }
        System.out.println(ways);
    }
}