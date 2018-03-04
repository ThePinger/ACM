//611A
//New Year and Days

import java.util.*;

public class NewYearDays
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        
        if(s[2].equals("week")) 
        {
            int tmp = Integer.parseInt(s[0]);
            if(tmp == 5 || tmp == 6) System.out.println(53);            
            else System.out.println(52);
        }
        else
        {
            int tmp = Integer.parseInt(s[0]);
            if(tmp == 31) System.out.println(7);
            else if(tmp > 29) System.out.println(11);
            else System.out.println(12);
        }
    }
}