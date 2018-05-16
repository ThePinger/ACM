//315A
//SerejaAndBottles

import java.util.Scanner;

public class SerejaAndBottles
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] opens = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = a;
            opens[i] = b;
        }

        int notOpened = n;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                if(i != j && opens[j] == arr[i])
                {
                    notOpened--;
                    break;
                }
        }

        System.out.println(notOpened);
    }
}