//734B
//Anton and Digits

import java.util.*;

public class AntonDigits
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int k2     = sc.nextInt();    
        int k3     = sc.nextInt();    
        int k5     = sc.nextInt();    
        int k6     = sc.nextInt(); 
        
        long ans = Math.min(k2, Math.min(k5, k6)) * 256;
        k2  -= Math.min(k2, Math.min(k5, k6));
        ans += Math.min(k2, k3) * 32;
        System.out.println(ans);
    }
}