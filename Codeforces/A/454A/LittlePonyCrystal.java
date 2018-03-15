//454A
//Little Pony and Crystal Mine

import java.util.Scanner;
import java.lang.StringBuilder;

public class LittlePonyCrystal
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        int toBeAdded = 1;
        for(int i = 0; i < n; i++)
        {

            for(int j = 0; j < (n - toBeAdded) / 2; j++)
                sb.append('*');

            for(int j = 0; j < toBeAdded; j++)
                sb.append('D');

            for(int j = 0; j < (n - toBeAdded) / 2; j++)
                sb.append('*');

            sb.append("\n");
            if(i < n / 2) toBeAdded += 2;
            else toBeAdded -= 2;
        }

        System.out.println(sb);

    }
}
