//11157
//Dynamic Frog

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int t = 1;

        while(n-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rocks = Integer.parseInt(st.nextToken());
            long distance = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());

            boolean turn  = false;
            long maxLeap1 = 0;
            long maxLeap2 = 0;
            long last1    = 0;
            long last2    = 0;
            Stack<Long> returnRoute1 = new Stack<>();
            Stack<Long> returnRoute2 = new Stack<>();            
            returnRoute1.push((long) 0);
            returnRoute2.push((long) 0);
            while(st.hasMoreTokens())
            {
                String[] s = st.nextToken().split("-");
                Long tmp = Long.parseLong(s[1]);
                if(s[0].equals("B"))
                {
                    returnRoute1.push(tmp);
                    returnRoute2.push(tmp);
                    maxLeap1 = Math.max(maxLeap1, tmp - last1);
                    maxLeap2 = Math.max(maxLeap2, tmp - last2);
                    last1 = tmp;
                    last2 = tmp;
                }
                else
                {
                    if(turn)
                    {
                        returnRoute2.push(tmp);
                        maxLeap1 = Math.max(maxLeap1, tmp - last1);
                        last1 = tmp;
                        turn  = false;
                    }
                    else
                    {
                        returnRoute1.push(tmp);
                        maxLeap2 = Math.max(maxLeap2, tmp - last2);
                        last2 = tmp;
                        turn  = true;
                    }
                }

            }

            maxLeap1 = Math.max(maxLeap1, distance - last1);
            maxLeap2 = Math.max(maxLeap2, distance - last2);
            
            last1 = distance;
            while(!returnRoute1.isEmpty())
            {
                long tmp = returnRoute1.pop();
                maxLeap1 = Math.max(maxLeap1, last1 - tmp);
                last1 = tmp;
            }

            last2 = distance;
            while(!returnRoute2.isEmpty())
            {
                long tmp = returnRoute2.pop();
                maxLeap2 = Math.max(maxLeap1, last2 - tmp);
                last2 = tmp;
            }

            long maxLeap = Math.min(maxLeap1, maxLeap2);
            sb.append("Case " + (t++) + ": " + maxLeap + "\n");
        }
        System.out.print(sb);
    }
}