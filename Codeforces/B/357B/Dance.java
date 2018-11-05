//358B
//FlagDay

import java.util.*;

public class Dance
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] color = new int[n + 1];

        for(int i = 0; i < m; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(color[a] != 0)
            {
                switch (color[a])
                {
                    case 1: color[b] = 2; color[c] = 3; break;
                    case 2: color[b] = 1; color[c] = 3; break;
                    case 3: color[b] = 1; color[c] = 2; break;
                }
            }
            else if(color[b] != 0)
            {
                switch (color[b])
                {
                    case 1: color[a] = 2; color[c] = 3; break;
                    case 2: color[a] = 1; color[c] = 3; break;
                    case 3: color[a] = 1; color[c] = 2; break;
                }
            }
            else if(color[c] != 0)
            {
                switch (color[c])
                {
                    case 1: color[a] = 2; color[b] = 3; break;
                    case 2: color[a] = 1; color[b] = 3; break;
                    case 3: color[a] = 1; color[b] = 2; break;
                }
            }
            else
            {
                color[a] = 1;
                color[b] = 2;
                color[c] = 3;
            }
        }

        for(int i = 1; i < color.length; i++)
            System.out.print(color[i] + " ");
    }
}
