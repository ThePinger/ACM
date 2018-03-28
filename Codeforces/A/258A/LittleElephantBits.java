//258A
//Little Elephant Bits

import java.util.Scanner;

public class LittleElephantBits
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] sss = sc.next().toCharArray();
        
        boolean flag = false;
        for(int i = 0; i < sss.length; i++)
            if(sss[i] == '0' && !flag)
                flag = true;
            else if(!flag && i + 1 == sss.length)
                continue;
            else System.out.print(sss[i]);

        System.out.println();
    }
}