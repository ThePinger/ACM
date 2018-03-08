//34A
//Reconnaissance2

import java.util.Scanner;

public class Reconnaissance
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] soldiers = new int[n];

        for(int i = 0; i < n; i++)
            soldiers[i] = sc.nextInt();

        int x = -1;
        int y = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
        {
            if(i + 1 == n)
            {
                int tmp = Math.abs(soldiers[i] - soldiers[0]);
                if(tmp < min)
                {
                    x = i;
                    y = 0;
                    min = tmp;
                }
            }
            else
            {
                int tmp = Math.abs(soldiers[i] - soldiers[i + 1]);
                if(tmp < min)
                {
                    x = i;
                    y = i + 1;
                    min = tmp;
                }
            }
        }

        System.out.println((x + 1) + " " + (y + 1));
    }
}
