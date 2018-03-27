//433A
//Kitahara Haruki's Gift

import java.util.Scanner;

public class KitaharaGift
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int hundred = 0;
        int twoHundred = 0;
        while(n-->0)
            if(sc.nextInt() == 100)
                hundred++;
            else twoHundred++;

        boolean flag = true;
        while(twoHundred + hundred > 0)
            if(twoHundred > 0)
            {
                twoHundred--;
                if(twoHundred == 0 && hundred - 2 < 0)
                {
                    flag = false;
                    break;
                }
                else if(twoHundred == 0) hundred -= 2;
                else twoHundred--;
            }
            else if(hundred - 2 < 0)
            {
                flag = false;
                break;
            }
            else hundred -= 2;

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}