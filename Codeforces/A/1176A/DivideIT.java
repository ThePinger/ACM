//1176A
//DivideIT

import java.io.PrintWriter;
import java.util.*;

public class DivideIT
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int q = sc.nextInt();
        while(q-->0)
        {
            long n = sc.nextLong();
            int moves = 0;
            while(n > 1)
            {
                if(n % 5 == 0)
                {
                    moves++;
                    n = (n / 5) * 4;
                }
                else if(n % 3 == 0)
                {
                    moves++;
                    n = (n / 3) * 2;
                }
                else if(n % 2 == 0)
                {
                    moves++;
                    n = n / 2;
                }
                else
                {
                    moves = -1;
                    break;
                }
            }

            pw.println(moves);
        }
        pw.flush();
        pw.close();
    }
}