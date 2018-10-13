//1033A
//KingEscape

import java.util.*;

public class KingEscape
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int qX = sc.nextInt();
        int qY = sc.nextInt();
        
        int kX = sc.nextInt();
        int kY = sc.nextInt();

        int tX = sc.nextInt();
        int tY = sc.nextInt();

        int king;
        if(kX < qX)
        {
            if(kY < qY)
                king = 1;
            else
                king = 3;
        }
        else
        {
            if(kY < qY)
                king = 2;
            else
                king = 4;
        }

        int target;
        if(tX < qX)
        {
            if(tY < qY)
                target = 1;
            else
                target = 3;
        }
        else
        {
            if(tY < qY)
                target = 2;
            else
                target = 4;
        }

        System.out.println(king == target ? "YES" : "NO");
    }
}