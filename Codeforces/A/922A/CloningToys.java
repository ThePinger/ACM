//922A
//CloningToys

import java.util.*;

public class CloningToys
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int copies = sc.nextInt();
        int origin = sc.nextInt();
        
        if(origin - 1 > copies || origin == 0 || (origin == 1 && copies != 0)) System.out.println("NO");
        else if(origin - 1 == copies) System.out.println("YES");
        else
        {
            int lo = 1;
            int hi = copies;
            while(lo <= hi)
            {
                int mid = (lo + hi) / 2;
                int totalC = (mid * 2) + origin - 1;
                if(totalC < copies)
                    lo = mid + 1;
                else
                    hi = mid - 1;

                if(totalC == copies)
                {
                    System.out.println("YES");
                    return;
                }
            }
            System.out.println("NO");
        }
    }
}