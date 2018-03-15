//681A
//A Good Contest

import java.util.Scanner;

public class GoodContest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;

        while(n-->0)
        {
            sc.next();
            int before = sc.nextInt();
            int after  = sc.nextInt();

            if(before >= 2400 && after >= 2400 && after > before)
                flag = true;
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
