//102B
//SumOfDigits

import java.util.*;

public class SumOfDigits
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] line = sc.next().toCharArray();
        
        if(line.length == 1)
            System.out.println(0);
        else
        {
            int sum = 0;
            for(int i = 0; i < line.length; i++)
                sum += Character.getNumericValue(line[i]);
            
            int spells = 1;
            line = (sum + "").toCharArray();
            while(line.length != 1)
            {
                sum = 0;
                for(int i = 0; i < line.length; i++)
                    sum += Character.getNumericValue(line[i]);
                
                line = (sum + "").toCharArray();
                spells++;
            }

            System.out.println(spells);
        }
    }
}