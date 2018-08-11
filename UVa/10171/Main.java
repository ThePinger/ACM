//10171
//Meeting Prof. Miguel...

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(true)
        {
            int n = sc.nextInt();

            if(n == 0) break;

            int[][] young = new int[26][26];
            int[][] adult = new int[26][26];

            for(int[] x : young)
                Arrays.fill(x, (int) 1e8);

            for(int[] x : adult)
                Arrays.fill(x, (int) 1e8);

            while(n-->0)
            {
                String typ = sc.next();
                String dir = sc.next();
                String x = sc.next();
                String y = sc.next();
                int cost = sc.nextInt();

                if(typ.equals("Y"))
                {
                    if(dir.equals("B"))
                        young[y.charAt(0) - 'A'][x.charAt(0) - 'A'] = cost;
                    young[x.charAt(0) - 'A'][y.charAt(0) - 'A'] = cost;
                }
                else
                {
                    if(dir.equals("B"))
                        adult[y.charAt(0) - 'A'][x.charAt(0) - 'A'] = cost;
                    adult[x.charAt(0) - 'A'][y.charAt(0) - 'A'] = cost;
                }
            }

            for(int i = 0; i < 26; i++)
                young[i][i] = adult[i][i] = 0;

            for(int k = 0; k < 26; k++)
                for(int i = 0; i < 26; i++)
                    for(int j = 0; j < 26; j++)
                        young[i][j] = Math.min(young[i][j], young[i][k] + young[k][j]);


            for(int k = 0; k < 26; k++)
                for(int i = 0; i < 26; i++)
                    for(int j = 0; j < 26; j++)
                        adult[i][j] = Math.min(adult[i][j], adult[i][k] + adult[k][j]);
            
            int min = (int) 1e8;
            int a = sc.next().charAt(0) - 'A';
            int b = sc.next().charAt(0) - 'A';
            for(int i = 0; i < 26; i++)
                min = Math.min(min, young[a][i] + adult[b][i]);

            Queue<Character> q = new LinkedList<>();
            for(int i = 0; i < 26; i++)
                if(young[a][i] + adult[b][i] == min)
                    q.add((char) (i + 'A'));
            
            if(min == (int) 1e8) pw.println("You will never meet.");
            else
            {
                pw.print(min);
                while(!q.isEmpty())
                    pw.print(" " + q.poll());
                pw.println();
            }
        }

        pw.flush();
        pw.close();
    }
}