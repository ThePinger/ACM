//43C
//LuckyTickets

import java.util.*;

public class LuckyTickets
{

    public static int sumDigits(int x)
    {
        int sum = 0;
        String s = x + "";
        for(int i = 0; i < s.length(); i++)
            sum += Character.getNumericValue(s.charAt(i));
        return sum;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int div = 0;
        ArrayList<Integer> notDiv = new ArrayList<>();    
        for(int i = 0; i < n; i++)
        {
            int sum = sumDigits(sc.nextInt());
            if(sum % 3 == 0) div++;
            else notDiv.add(sum);
        }

        int count = 0;
        boolean[] taken = new boolean[notDiv.size()];
        for(int i = 0; i < notDiv.size(); i++)
        {
            for(int j = 0; j < notDiv.size(); j++)
                if(i != j && !taken[i] && !taken[j])
                {
                    int tmp = notDiv.get(i) + notDiv.get(j);
                    if(tmp % 3 == 0)
                    {
                        count++;
                        taken[i] = taken[j] = true;
                    }
                }
        }

        System.out.println(count + div / 2);
    }
}