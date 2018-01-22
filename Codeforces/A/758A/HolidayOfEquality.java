//758A
//Holiday Of Equality

import java.util.Scanner;

public class HolidayOfEquality
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] welfare = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++)
        {
            welfare[i] = sc.nextInt();
            max = Math.max(max, welfare[i]);
        }

        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += max - welfare[i];

        System.out.println(sum);
    }
}