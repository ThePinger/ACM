//996A
//Hit the Lottery

import java.util.*;

public class Lottery
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = n / 100;
        n %= 100;
        ans += n / 20;
        n %= 20;
        ans += n / 10;
        n %= 10;
        ans += n / 5;
        n %= 5;
        ans += n;
        System.out.println(ans);    
    }
}