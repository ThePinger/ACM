//867A
//Between the Offices

import java.util.*;

public class Offices
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        int sf = 0;
        int fs = 0;
        for(int i = 1; i < n; i++)
        {
            if(arr[i - 1] != arr[i])
            {
                if(arr[i] == 'F') sf++;
                else fs++;
            }
        }
        System.out.println(sf > fs ? "YES" : "NO");
    }
}