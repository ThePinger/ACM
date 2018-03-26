//298B
//Sail

import java.util.Scanner;

public class Sail
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        char[] sss = sc.next().toCharArray();

        int time = 0;
        for(int i = 0; i < t; i++)
            if(sx == ex && sy == ey)
                break;
            else
            {
                if(sss[i] == 'E' && sx < ex)
                    sx++;
                else if(sss[i] == 'S' && sy > ey)
                    sy--;
                else if(sss[i] == 'W' && sx > ex)
                    sx--;
                else if(sss[i] == 'N' && sy < ey)
                    sy++;
                
                time++;
            }
        
        if(sx == ex && sy == ey)
            System.out.println(time);
        else
            System.out.println(-1);
    }
}