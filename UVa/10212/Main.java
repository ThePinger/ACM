//10212
//The Last Non-zero Digit

import java.io.*;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int twos = 0;
            int fives = 0;
            int copyN = n;
            int copyK = k;
            while(copyK-->0)
            {
                int tmp = copyN;
                while(tmp % 2 == 0)
                {
                    twos++;
                    tmp /= 2;
                }

                while(tmp % 5 == 0)
                {
                    fives++;
                    tmp /= 5;
                }

                copyN--;
            }

            int min = Math.min(twos, fives);
            twos = min; fives = min;
            long ans = 1;
            while(k-->0)
            {
                int tmp = n;
                while(twos > 0 && tmp % 2 == 0)
                {
                    twos--;
                    tmp /= 2;
                }

                while(fives > 0 && tmp % 5 == 0)
                {
                    fives--;
                    tmp /= 5;
                }

                ans = (ans * tmp) % 10;
                n--;
            }

            pw.println(ans % 10);
        }

        pw.flush();
        pw.close();
    }
}