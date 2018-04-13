//304A
//PythagoreanTheorem

import java.util.*;

public class PythagoreanTheorem
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int poss = 0;

        for(int a = 1; a <= n; a++)
            for(int b = a; b <= n; b++)
            {
                int cSQ = (a * a) + (b * b);
                int c = (int) Math.sqrt(cSQ);
                if(c <= n && (c * c) == ((a * a) + (b * b)))
                    poss++;
            }
        System.out.println(poss);
    }
}