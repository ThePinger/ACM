//980A
//LinksAndPearls

import java.util.Scanner;

public class LinksAndPearls
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] necklace = sc.next().toCharArray();
        int links = 0;
        int pearls = 0;

        for(int i = 0; i < necklace.length; i++)
            if(necklace[i] == '-')
                links++;
            else 
                pearls++;
        
        if(links >= pearls)
        {
            if(pearls == 0 || links % pearls == 0)
                System.out.println("YES");
            else  
                System.out.println("NO");
        }
        else
        {
            if(links == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}