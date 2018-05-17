//300A
//Array

import java.util.*;

public class Array
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pos = 0;
        int neg = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            if(tmp > 0 && pos == 0)
                pos = tmp;
            else if(tmp < 0 && neg == 0)
                neg = tmp;
            else arr.add(tmp);
        }

        System.out.println("1 " + neg);
        if(pos == 0)
        {
            int pos1 = 0;
            int pos2 = 0;
            for(int i = 0; i < arr.size(); i++)
            {
                int cur = arr.get(i);
                if(cur < 0)
                {
                    if(pos1 == 0)
                        pos1 = cur;
                    else
                        pos2 = cur;
                    arr.remove(i);
                    i--;
                }

                if(pos2 != 0) break;
            }
            System.out.println("2 " + pos1 + " " + pos2);
        }
        else
            System.out.println("1 " + pos);
        
        System.out.print(arr.size() + " ");
        for(int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }
}