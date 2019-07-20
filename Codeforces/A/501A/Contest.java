//501A
//Contest

import java.util.*;

public class Contest
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int misha = Math.max((3 * a) / 10, a - ((a / 250) * c));
        int vasya = Math.max((3 * b) / 10, b - ((b / 250) * d));

        System.out.println(misha < vasya ? "Vasya" : misha > vasya ? "Misha" : "Tie");
    }
}