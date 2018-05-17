//75A
//LifeWithoutZeroes

import java.util.Scanner;

public class LifeWithoutZeroes
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;
        
        String aa = a + "";
        String bb = b + "";
        String cc = c + "";

        String newAA = "";
        String newBB = "";
        String newCC = "";
        
        for(int i = 0; i < aa.length(); i++)
            if(aa.charAt(i) != '0')
                newAA += aa.charAt(i);

        for(int i = 0; i < bb.length(); i++)
            if(bb.charAt(i) != '0')
                newBB += bb.charAt(i);

        for(int i = 0; i < cc.length(); i++)
            if(cc.charAt(i) != '0')
                newCC += cc.charAt(i);

        a = Integer.parseInt(newAA);
        b = Integer.parseInt(newBB);
        c = Integer.parseInt(newCC);

        if(a + b == c)
            System.out.println("YES");
        else 
            System.out.println("NO");
    }
}