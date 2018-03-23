//34B
//Sale

import java.util.Arrays;
import java.util.Scanner;

public class Sale
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int tv = sc.nextInt();
        int max = sc.nextInt();
        int[] price = new int[tv];

        for(int i = 0; i < tv; i++)
            price[i] = sc.nextInt();

        Arrays.sort(price);

        int taken = 0;
        int money = 0;
        for(int i = 0; i < tv; i++)
            if(taken == max) break;
            else if(price[i] < 1)
            {
                taken++;
                money += Math.abs(price[i]);
            }
            else break;

        System.out.println(money);
    }
}