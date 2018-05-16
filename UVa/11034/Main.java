//11034
//Ferry Loading IV

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) * 100;
            int cars = Integer.parseInt(st.nextToken());
            Queue<Integer> left = new LinkedList<>();
            Queue<Integer> right = new LinkedList<>();

            while(cars-->0)
            {
                st = new StringTokenizer(br.readLine());
                int tmp = Integer.parseInt(st.nextToken());
                if(st.nextToken().equals("left"))
                    left.add(tmp);
                else
                    right.add(tmp);
            }

            int times = 0;
            boolean side = true;
            while(!left.isEmpty() || !right.isEmpty())
            {
                if(side)
                {
                    int curL = 0;
                    while(!left.isEmpty())
                    {
                        int tmp = left.peek();
                        if(curL + tmp <= l)
                        {
                            curL += tmp;
                            left.poll();
                        }
                        else break;
                    }
                }
                else
                {
                    int curL = 0;
                    while(!right.isEmpty())
                    {
                        int tmp = right.peek();
                        if(curL + tmp <= l)
                        {
                            curL += tmp;
                            right.poll();
                        }
                        else break;
                    }
                }
                times++;
                side = !side;
            }
            pw.println(times);
        }

        pw.flush();
        pw.close();
    }
}