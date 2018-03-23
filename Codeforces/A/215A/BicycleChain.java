//215A
//Bicycle Chain

import java.util.Scanner;

public class BicycleChain
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();    

        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        int maxRatio = 0;
        int count    = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
            {
                int tmp = b[j] / a[i];
                if(tmp > maxRatio && tmp * a[i] == b[j])
                {
                    maxRatio = tmp;
                    count = 1;
                } 
                else if(tmp == maxRatio && tmp * a[i] == b[j]) 
                    count++;
            }
        
        System.out.println(count);
    }
}