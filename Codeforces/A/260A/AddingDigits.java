//260A
//AddingDigits

import java.util.Scanner;

public class AddingDigits
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        
        boolean added = false;
        String tmp = a + "";
        for(int i = 0; i < 10; i++)
        {
            int test = Integer.parseInt(tmp + i);
            if(test % b == 0)
            {
                tmp += i;
                added = true;
                break;
            }
        }

        if(added)
        {
            StringBuilder sb = new StringBuilder(tmp);
            for(int i = 1; i < n; i++)
                sb.append(0);
            System.out.println(sb);
        }
        else System.out.println(-1);
    }
}