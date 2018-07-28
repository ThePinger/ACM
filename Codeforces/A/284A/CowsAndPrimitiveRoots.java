//284A
//CowsAndPrimitiveRoots

import java.util.*;

public class CowsAndPrimitiveRoots
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int count = 0;
        loop : for(int x = 1; x < p; x++)
        {
            int tmp = x;
            for(int i = 1; i < p - 1; i++)
            {
                if((tmp - 1) % p == 0)
                    continue loop;
                tmp = (tmp * x) % p;
            }
            count++;
        }    
        System.out.println(count);
    }
}