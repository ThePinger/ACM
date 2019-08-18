//731A
//NightAtTheMuseum

import java.util.*;

public class NightAtTheMuseum
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int cur = 0;
        int moves = 0;
        char[] arr = sc.nextLine().toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
            int tmp = arr[i] - 'a';
            int count1 = 0;
            for(int j = cur; ; j++)
            {
                if(j == tmp) break;
                if(j == 26) j = -1;
                else count1++;
            }

            int count2 = 0;
            for(int j = cur; ; j--)
            {
                if(j == tmp) break;
                if(j == -1) j = 26;
                else count2++;
            }

            moves += Math.min(count1, count2);
            cur = tmp;
        }

        System.out.println(moves);
    }
}
