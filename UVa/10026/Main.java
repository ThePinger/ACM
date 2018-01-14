//10026
//ShoeMaker Problem

import java.io.*;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n-->0)
        {
            br.readLine();
            int jobs = Integer.parseInt(br.readLine());
            int totalDays = 0;
            int totalFine = 0;
            Job[] daysXfine = new Job[jobs];

            for(int i = 0; i < jobs; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                daysXfine[i] = new Job(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for(int i = 0; i < jobs; i++)
                for(int j = 0; j < jobs - 1; j++)
                    if(daysXfine[j + 1].days * daysXfine[j].fine < daysXfine[j].days * daysXfine[j + 1].fine)
                    {
                        Job tmp = daysXfine[j + 1];
                        daysXfine[j + 1] = daysXfine[j];
                        daysXfine[j] = tmp;
                    }

            for(int i = 0; i < jobs; i++)
                if(i + 1 == jobs)
                    sb.append((daysXfine[i].idx + 1) + "\n");
                else
                    sb.append((daysXfine[i].idx + 1) + " ");
            
            if(n > 0)
                    sb.append("\n");
        }
        System.out.print(sb);
    }

    static class Job
    {
        int idx, days, fine;
        
        public Job(int idx, int days, int fine)
        {
            this.idx  = idx;
            this.days = days;
            this.fine = fine;
        }
    }

}