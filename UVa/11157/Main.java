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
            long maxLeap = 0;
            long last    = 0;
            Stack<Long> returnRoute = new Stack<>();
            returnRoute.push((long) 0);
            while(st.hasMoreTokens())
            {
                String[] s = st.nextToken().split("-");
                Long tmp = Long.parseLong(s[1]);
                if(s[0].equals("B"))
                {
                    returnRoute.push(tmp);
                    maxLeap = Math.max(maxLeap, tmp - last);
                    last = tmp;
                }
                else
                {
                    if(turn)
                    {
                        maxLeap = Math.max(maxLeap, tmp - last);
                        last = tmp;
                        turn  = false;
                    }
                    else
                    {
                        returnRoute.push(tmp);
                        turn  = true;
                    }
                }

            }

            maxLeap = Math.max(maxLeap, distance - last);
            
            last = distance;
            while(!returnRoute.isEmpty())
            {
                long tmp = returnRoute.pop();
                maxLeap = Math.max(maxLeap, last - tmp);
                last = tmp;
            }
            sb.append("Case " + (t++) + ": " + maxLeap + "\n");
        }
        System.out.print(sb);
    }
}