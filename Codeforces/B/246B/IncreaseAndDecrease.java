//246B
//IncreaseAndDecrease

import java.util.*;

public class IncreaseAndDecrease
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += sc.nextInt();
        System.out.println(sum % n == 0 ? n : n - 1);
    }
}