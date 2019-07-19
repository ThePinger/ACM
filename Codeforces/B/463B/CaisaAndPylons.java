//463B
//Caisa and Pylons

import java.io.*;
import java.util.*;

public class CaisaAndPylons
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for(int i = 1; i < arr.length; i++)
            arr[i] = sc.nextInt();

        int money = 0;
        int energy = 0;
        for(int i = 0; i < arr.length - 1; i++)
        {
            if(energy + (arr[i] - arr[i + 1]) < 0)
            {
                money += Math.abs(energy + (arr[i] - arr[i + 1]));
                energy = 0;
            }
            else energy += arr[i] - arr[i + 1];
        }

        System.out.println(money);
    }
}