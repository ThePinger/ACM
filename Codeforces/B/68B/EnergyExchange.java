//68B
//Energy Exchange

import java.text.DecimalFormat;
import java.util.*;

public class EnergyExchange
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        double[] energy = new double[n];
        double max = 0;

        for(int i = 0; i < n; i++)
        {
            energy[i] = sc.nextInt();
            max = Math.max(max, energy[i]);
        }

        Arrays.sort(energy);
        double lo = 0;
        double hi = max;
        max = 0;
        for(int j = 0; j < max + 50; j++)
        {
            double mid = (hi + lo) / 2;
            double above = 0;
            for(int i = 0; i < n; i++)
                if(energy[i] > mid)
                    above += energy[i] - mid;

            above = above - ((above * k) / 100.0);
            boolean flag = true;
            for(int i = 0; i < n && flag; i++)
            {
                if(energy[i] < mid)
                {
                    if(above - (mid - energy[i]) < 0)
                        flag = false;
                    above -= (mid - energy[i]);
                }
                else
                    break;
            }

            if(flag)
            {
                lo = mid;
                max = mid;
            }
            else
                hi = mid;        
        }
        DecimalFormat df = new DecimalFormat("#0.000000000");
        System.out.println(df.format(max));
    }
}