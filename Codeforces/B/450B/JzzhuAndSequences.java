//450B
//Jzzhu and Sequences

import java.util.Scanner;

public class JzzhuAndSequences
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int f1 = sc.nextInt();
        int f2 = sc.nextInt();
        int n = sc.nextInt();
        int oo = 1000000007;

        if(n == 1)
        {
            if(f1 >= 0)
                System.out.println(f1 % oo);
            else
                System.out.println((f1 % oo) + oo);
        }
        else if(n == 2)
        {
            if(f2 >= 0)
                System.out.println(f2 % oo);
            else
                System.out.println((f2 % oo) + oo);
        }
        else
        {
            int[] arr = new int[6];
            arr[0] = f2 - f1;
            arr[1] = arr[0] - f2;
            for(int i = 2; i < 6; i++)
                arr[i] = arr[i - 1] - arr[i - 2];

            int mod = n % 6;
            if(mod > 2)
            {
                if(arr[mod - 3] >= 0 || arr[mod - 3] % oo == 0)
                    System.out.println(arr[mod - 3] % oo);
                else 
                    System.out.println((arr[mod - 3] % oo) + oo);                
            }
            else
            {   
                if(arr[mod + 3] >= 0 || arr[mod + 3] % oo == 0)
                    System.out.println(arr[mod + 3] % oo);
                else
                    System.out.println((arr[mod + 3] % oo) + oo);
            }
        }
    }
}