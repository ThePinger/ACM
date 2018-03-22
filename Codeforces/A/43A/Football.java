//43A
//Football

import java.util.Scanner;

public class Football
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String team1 = "";
        String team2 = "";
        int t1 = 0;
        int t2 = 0;

        while(n-->0)
        {
            String tmp = sc.next();
            if(team1.equals(""))
            {
                team1 = tmp;
                t1++;
            }
            else if(tmp.equals(team1))
                t1++;
            else if(team2.equals(""))
            {
                team2 = tmp;
                t2++;
            }
            else t2++;
        }

        if(t1 > t2) System.out.println(team1);
        else System.out.println(team2);
    }
}