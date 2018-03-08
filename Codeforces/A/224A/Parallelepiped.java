//224A
//Parallelepiped

import java.util.Scanner;

public class Parallelepiped
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();

        int b = (int) Math.sqrt((a1 * a3) / a2);
        int a = a1 / b;
        int c = a3 / b;

        System.out.println((a * 4) + (b * 4) + (c * 4));
    }
}
