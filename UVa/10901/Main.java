//10901
//Ferry Loading III

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int t = 1;

        while(n-->0)
        {
            if(t++ != 1) pw.println();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int capacity = Integer.parseInt(st.nextToken());
            int trip = Integer.parseInt(st.nextToken());
            int cars = Integer.parseInt(st.nextToken());
            int[] reach = new int[cars];
            Queue<Pair> left = new LinkedList<>();
            Queue<Pair> right = new LinkedList<>();

            for(int i = 0; i < cars; i++)
            {
                st = new StringTokenizer(br.readLine());
                int tmp = Integer.parseInt(st.nextToken());
                if(st.nextToken().equals("left"))
                    left.add(new Pair(i, tmp));
                else
                    right.add(new Pair(i, tmp));
            }

            int time = 0;
            boolean side = true;
            while(!left.isEmpty() || !right.isEmpty())
            {
                if(side)
                {
                    int loaded = 0;
                    boolean changeSide = false;
                    while(!left.isEmpty())
                    {
                        Pair peek = left.peek();
                        if(peek.arrival <= time)
                        {
                            loaded++;
                            reach[peek.idx] = time + trip;
                            left.poll();
                            changeSide = true;
                        }
                        else break;

                        if(loaded == capacity) break;
                    }   

                    if(changeSide)
                    {
                        time += trip;
                        side = !side;
                    }
                    else if(!right.isEmpty())
                    {
                        Pair peek = right.peek();
                        if(peek.arrival <= time)
                        {
                            time += trip;
                            side = !side;
                        }
                        else time++;
                    }
                    else time++;
                }
                else
                {
                    int loaded = 0;
                    boolean changeSide = false;
                    while(!right.isEmpty())
                    {
                        Pair peek = right.peek();
                        if(peek.arrival <= time)
                        {
                            loaded++;
                            reach[peek.idx] = time + trip;
                            right.poll();
                            changeSide = true;
                        }
                        else break;

                        if(loaded == capacity) break;
                    }   

                    if(changeSide)
                    {
                        time += trip;
                        side = !side;
                    }
                    else if(!left.isEmpty())
                    {
                        Pair peek = left.peek();
                        if(peek.arrival <= time)
                        {
                            time += trip;
                            side = !side;
                        }
                        else time++;
                    }
                    else time++;
                }
            }

            for(int i = 0; i < cars; i++)
                pw.println(reach[i]);
        }

        pw.flush();
        pw.close();
    }

    static class Pair
    {
        int idx;
        int arrival;

        public Pair(int idx, int arrival)
        {
            this.idx = idx;
            this.arrival = arrival;
        }
    }
}