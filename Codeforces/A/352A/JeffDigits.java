//352A
//Jeff and Digits

import java.util.Scanner;

public class JeffDigits
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int zeroes = 0;
        int fives = 0;

        while(n-->0)
            if(sc.nextInt() == 0)
                zeroes++;
            else fives++;

        if(zeroes == 0) System.out.println(-1);
        else if(fives < 9) System.out.println(0);
        else 
        {
            int max = (fives / 9) * 9;
            for(int i = 0; i < max; i++)
                System.out.print(5);
            for(int i = 0; i < zeroes; i++)
                System.out.print(0);
            System.out.println();
        }
        
    }
}