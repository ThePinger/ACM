//248A
//Cupboards

import java.util.*;

public class Cupboards
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int cupboards = sc.nextInt();
        int leftOnes  = 0;
        int rightOnes = 0;
        
        for(int i = 0; i < cupboards; i++)
        {
            if(sc.nextInt() == 1)
                leftOnes++;
            if(sc.nextInt() == 1)
                rightOnes++;
        }

        System.out.println(Math.min(leftOnes, cupboards - leftOnes) + Math.min(rightOnes, cupboards - rightOnes));
    }
}