
import java.util.*;

public class A
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String h = sc.next();
        String m = sc.next();

        if(h.charAt(0) == '7' || h.charAt(1) == '7' || m.charAt(0) == '7' || m.charAt(1) == '7')
            System.out.println(0);
        else
        {
            int hh = Integer.parseInt(h);
            int mm = Integer.parseInt(m);

            int press = 0;
            while(true)
            {
                if(mm - n < 0)
                {
                    if(hh - 1 < 0)
                    {
                        hh = 23;
                        mm = 60 - (n - mm);
                    }
                    else
                    {
                        hh--;
                        mm = 60 - (n - mm); 
                    }
                }
                else
                    mm -= n;
                press++;
                h = hh + "";
                m = mm + "";

                if(h.length() == 1)
                {
                    if(h.charAt(0) == '7')
                        break;  
                }
                else
                {
                    if(h.charAt(0) == '7' || h.charAt(1) == '7')
                        break;
                }  

                if(m.length() == 1)
                {
                    if(m.charAt(0) == '7')
                        break;
                }
                else
                {
                    if(m.charAt(0) == '7' || m.charAt(1) == '7')
                        break;
                }
            }
            System.out.println(press);
        }

    }
}