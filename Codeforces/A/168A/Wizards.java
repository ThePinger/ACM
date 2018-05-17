//168A
//Wizards

import java.util.Scanner;

public class Wizards
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int percent = sc.nextInt();
        int req = (int) Math.ceil((n * percent) / 100.0);
        System.out.println(req - w < 0 ? 0 : req - w);
    }
}