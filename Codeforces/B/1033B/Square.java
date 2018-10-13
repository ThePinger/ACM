//1033B
//Square

import java.math.BigInteger;
import java.util.*;

public class Square
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-->0)
        {
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger(sc.next());

            BigInteger aa = a.multiply(a);
            BigInteger bb = b.multiply(b);

            BigInteger rem = aa.subtract(bb);
            System.out.println(rem.isProbablePrime(100) ? "YES" : "NO");
        }
    }
}