//478A
//InitialBet

import java.util.*;

public class InitialBet
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt();
        if(sum % 5 == 0 && sum != 0) System.out.println(sum / 5);
        else System.out.println(-1);    
    }
}