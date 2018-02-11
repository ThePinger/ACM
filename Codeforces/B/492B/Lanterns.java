//492b
//Vanya and Lanterns

import java.util.*;

public class Lanterns
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = sc.nextInt();
        int[] positions  = new int[n];


        for(int i = 0; i < n; i++)
            positions[i] = sc.nextInt();

        Arrays.sort(positions);

        int max = 0;
        double ends = Math.max(positions[0], length - positions[n - 1]);
        for(int i = 1; i < n; i++)
            max = Math.max(max, positions[i] - positions[i - 1]);

        if(max / 2.0 < ends) System.out.println(ends);
        else System.out.println(max / 2.0);
    }
}