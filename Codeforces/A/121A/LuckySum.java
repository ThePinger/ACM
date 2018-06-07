//121A
//LuckySum

import java.util.*;

public class LuckySum
{

    static PriorityQueue<Long> values = new PriorityQueue<>();

    public static void getValues(String num, int length)
    {
        if(num.length() == length)
        {
            values.add(Long.parseLong(num));
            return;
        }

        getValues(num + "4", length);
        getValues(num + "7", length);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        
        for(int i = 0; i < 10; i++)
            getValues("", i + 1);

        long ans = 0;
        long cur = values.peek();
        while(l <= r)
        {
            while(cur < l)
            {
                values.remove();
                cur = values.peek();
            }        
            
            if(r < cur)
            {
                ans += (r - l + 1) * cur;
                break;
            }
            else
            {
                ans += (cur - l + 1) * cur;
                l = (int) cur + 1;
            }
        }

        System.out.println(ans);
    }
}