//1154A
//RestoringNumbers

import java.util.*;

public class RestoringNumber
{
    public static boolean isOk(int x, int y, int z, int abc)
    {
        int b = (z - y + x) / 2;
        int a = x - b;
        int c = y - x + b;

        if(a >= 0 && b >= 0 && c >= 0 && a + b + c == abc)
        {
            System.out.println(a + " " + b + " " + c);
            return true;
        }
        return false;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int k = sc.nextInt();
        
        int abc = Math.max(Math.max(x, y), Math.max(z, k));
        int[] arr;

        if(x == abc)
            arr = new int[]{y, z, k};
        else if(y == abc)
            arr = new int[]{x, z, k};
        else if(z == abc)
            arr = new int[]{x, y, k};
        else
            arr = new int[]{x, y, z};

        if(isOk(arr[0], arr[1], arr[2], abc));
        else if(isOk(arr[0], arr[2], arr[1], abc));
        else if(isOk(arr[1], arr[0], arr[2], abc));
        else if(isOk(arr[1], arr[2], arr[0], abc));
        else if(isOk(arr[2], arr[0], arr[1], abc));
        else if(isOk(arr[2], arr[1], arr[0], abc));
    }
}