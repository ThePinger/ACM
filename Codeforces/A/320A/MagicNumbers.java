//320A
//Magic Numbers

import java.util.Scanner;

public class MagicNumbers
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] num = sc.next().toCharArray();
        
        int cons4 = 0;
        boolean flag = true;
        for(int i = 0; i < num.length; i++)
            if(num[i] != '1' && num[i] != '4')
            {
                flag = false;
                break;
            }
            else if(num[i] == '4')
            {
                cons4++;
                if(cons4 > 2 || i == 0) 
                {
                    flag = false;
                    break;
                }
            }
            else cons4 = 0;

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}